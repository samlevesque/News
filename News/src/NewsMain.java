import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

import org.apache.commons.io.IOUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class NewsMain {
	
	static String argError = "Veuillez entrer en argument :" + "\n"
			+ "'-w' pour ajouter les nouvelles à la base de donnée;" + "\n"
			+ "'-r' pour afficher les nouvelles de la base de donnée;" + "\n"
			+ "et ajouter '-redis' pour faire appel à Redis.";

	public static void main(String[] args) {
		try {
			if(args[0].equals("-w")) {
				if(args.length == 2 && args[1].equals("-redis")) {
					writeRedis();
				}
				else {
					write();
				}
			}
			else if(args[0].equals("-r")) {
				if(args.length == 2 && args[1].equals("-redis")) {
					readRedis();
				}
				else {
					read();
				}
			}
			else {
				throw new IllegalArgumentException();
			}
			
		} catch (IllegalArgumentException e) {
			System.out.print(argError);
		}
	}
	
	private static void write() {
		
		URL url = null;
		try {
			url = new URL("https://newsapi.org/v2/top-headlines?country=us&category=business&apiKey=57f4696d8c28484f849bc09108670849");
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		JSONParser parser = new JSONParser();
		JSONObject json = new JSONObject();
		try {
			json = (JSONObject) parser.parse(IOUtils.toString(url, Charset.forName("UTF-8")));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JSONArray articles = (JSONArray) json.get("articles");
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
		sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
		
		MySQLAccess dao = new MySQLAccess();
		dao.connect();
		for(int i = 0; i < articles.size();i++) {
			JSONObject article = (JSONObject) articles.get(i);
			try {
				dao.addNouvelle(
						new Nouvelle(
								String.valueOf(article.get("title")),
								String.valueOf(article.get("descritption")),
								String.valueOf(article.get("url")),
								dateToUnixTimestamp(sdf, String.valueOf(article.get("publishedAt")))));
			} catch (java.text.ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		dao.disconnect();
	}
	
	private static long dateToUnixTimestamp(SimpleDateFormat sdf, String date) throws java.text.ParseException {
		return sdf.parse(date).getTime()/1000;
	}

	private static void writeRedis() {
		// TODO Auto-generated method stub
		
	}

	private static void read() {
		// TODO Auto-generated method stub
		
	}

	private static void readRedis() {
		// TODO Auto-generated method stub
		
	}

	

}
