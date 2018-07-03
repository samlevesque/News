
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
