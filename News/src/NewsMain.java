import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;

import org.apache.commons.io.IOUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.SortingParams;

public class NewsMain {
	
	static URL url;
	static JSONArray articles;
	static SimpleDateFormat simpleDateFormat;
	static String argError = "Veuillez entrer en argument :" + "\n"
			+ "'-w' pour ajouter les nouvelles à la base de donnée;" + "\n"
			+ "'-r' pour afficher les nouvelles de la base de donnée;" + "\n"
			+ "et ajouter '-redis' pour faire appel à Redis." + "\n"
			+ "Si vous choisissez MySQL, veuillez ajouter '-u' suivi du user et -p suivi du mot de passe.";

	public static void main(String[] args) {
		try {
			if(args[0].equals("-w")) {
				if(args.length == 2 && args[1].equals("-redis")) {
					writeRedis();
				}
				else if(args.length == 5 && args[1].equals("-u") && args[3].equals("-p")) {
					write(args[2], args[4]);
				}
			}
			else if(args[0].equals("-r")) {
				if(args.length == 2 && args[1].equals("-redis")) {
					readRedis();
				}
				else if(args.length == 5 && args[1].equals("-u") && args[3].equals("-p")) {
					read(args[2], args[4]);
				}
			}
			else {
				throw new IllegalArgumentException();
			}
			
		} catch (IllegalArgumentException | ArrayIndexOutOfBoundsException e) {
			System.out.print(argError);
		}
	}
	
	private static void write(String user, String password) {
		getUrl();
		parseJSON();
		setTimeZone();
		
		MySQLAccess dao = new MySQLAccess(user, password);
		dao.connect();
		for(int i = 0; i < articles.size();i++) {
			JSONObject article = (JSONObject) articles.get(i);
			try {
				dao.addNouvelle(
						new Nouvelle(
								String.valueOf(article.get("title")),
								String.valueOf(article.get("description")),
								String.valueOf(article.get("url")),
								dateToUnixTimestamp(String.valueOf(article.get("publishedAt")))));
			} catch (java.text.ParseException e) {
				System.out.println("Erreur dans le parsing de la date");
				e.printStackTrace();
			}
		}
		dao.disconnect();
	}
	
	private static void setTimeZone() {
		simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
		simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
	}

	private static void parseJSON() {
		JSONParser parser = new JSONParser();
		JSONObject json = new JSONObject();
		try {
			json = (JSONObject) parser.parse(IOUtils.toString(url, Charset.forName("UTF-8")));
		} catch (ParseException e) {
			System.out.println("Erreur dans le parsing du JSON");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Erreur dans le parsing du JSON (IOU)");
			e.printStackTrace();
		}
		articles = (JSONArray) json.get("articles");
	}

	private static void getUrl() {
		url = null;
		try {
			url = new URL("https://newsapi.org/v2/top-headlines?country=us&category=business&apiKey=57f4696d8c28484f849bc09108670849");
		} catch (MalformedURLException e1) {
			System.out.println("Erreur dans l'url de l'API.");
			e1.printStackTrace();
		}
		
	}

	private static long dateToUnixTimestamp(String date) throws java.text.ParseException {
		return simpleDateFormat.parse(date).getTime()/1000;
	}

	private static void writeRedis() {
		getUrl();
		parseJSON();
		setTimeZone();
		

		Jedis jedis = new Jedis();
		
		for(int i = 0; i < articles.size();i++) {
			JSONObject article = (JSONObject) articles.get(i);
			jedis.hset("news#" + String.valueOf(i), "title", String.valueOf(article.get("title")));
			jedis.hset("news#" + String.valueOf(i), "description", String.valueOf(article.get("description")));
			jedis.hset("news#" + String.valueOf(i), "url", String.valueOf(article.get("url")));
			try {
				jedis.hset("news#" + String.valueOf(i), "publishedAt", String.valueOf(dateToUnixTimestamp(String.valueOf(article.get("publishedAt")))));
			} catch (java.text.ParseException e) {
				System.out.println("Erreur dans le parsing de la date");
				e.printStackTrace();
			}
		}
		
		
	}

	private static void read(String user, String password) {
		MySQLAccess dao = new MySQLAccess(user, password);
		dao.connect();
		ArrayList<Nouvelle> nouvelles = dao.getNouvelles();
		for(Nouvelle nouvelle : nouvelles) {
			System.out.print(nouvelle.toString());
		}
		dao.disconnect();
	}

	private static void readRedis() {
		Jedis jedis = new Jedis();
		Set<String> keys = jedis.keys("news#*");
		
		// Essai d'order
		/*
		String[] indices = new String[keys.size()];
		for(int i = 0; i < keys.size(); i++) {
			indices[i] = String.valueOf(i);
		}
		jedis.sadd("indices", indices);

		List<String> orderedKeys = jedis.sort("indices", new SortingParams().by("news#*->publishedAt").desc().get("news#*"));
		*/
		for(String key : keys) {
			System.out.println(jedis.hgetAll(key));
		}
	}

	

}
