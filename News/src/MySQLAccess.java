import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class MySQLAccess {
    private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    
    private String DRIVER = "com.mysqljdbc.Driver";
    private String CONNECT = "jdbc:mysql://localhost/feedback?";
    private String TIMEZONE_CORRECTIONS = "useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&";
    private String OTHER_CORRECTIONS = "useSSL=false&";
    private String user;
    private String password;
    
    public MySQLAccess(String user, String password) {
    	this.user = user;
    	this.password = password;
    }
    
    public void connect() {
    	try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Erreur Driver");
			e.printStackTrace();
		}
        try {
			connect = DriverManager
			        .getConnection("jdbc:mysql://localhost/news?" + TIMEZONE_CORRECTIONS + OTHER_CORRECTIONS 
			                + "user="+ user + "&password=" + password);
		} catch (SQLException e) {
			System.out.println("Erreur connection");
			e.printStackTrace();
		}
    }
    
    public void addNouvelle(Nouvelle nouvelle) {
    	try {
	    	preparedStatement = connect
	                .prepareStatement("INSERT INTO news.news VALUES (default, ?, ?, ?, ?)");
	    	preparedStatement.setString(1, nouvelle.getTitle());
	        preparedStatement.setString(2, nouvelle.getDescription());
	        preparedStatement.setString(3, nouvelle.getUrl());
	        preparedStatement.setLong(4, nouvelle.getPublishedAt());
	        preparedStatement.executeUpdate();
    	} catch (SQLException e) {
    		System.out.println("Erreur insertion");
    	}
    }

    public void disconnect() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }

            if (statement != null) {
                statement.close();
            }

            if (connect != null) {
                connect.close();
            }
        } catch (Exception e) {
        	System.out.println("Erreur deconnection");
        }
    }

	public ArrayList<Nouvelle> getNouvelles() {
		ArrayList<Nouvelle> nouvelles = new ArrayList<Nouvelle>();
		try {
			preparedStatement = connect
			        .prepareStatement("SELECT * FROM news.news ORDER BY publishedAt DESC");

	        resultSet = preparedStatement.executeQuery();
	        while (resultSet.next()) {
	        	nouvelles.add(new Nouvelle(
	        			resultSet.getString("title"),
	        			resultSet.getString("description"),
	        			resultSet.getString("url"),
	        			resultSet.getLong("publishedAt")));
	        }
	        
		} catch (SQLException e) {
			System.out.println("Erreur selection des nouvelles");
			e.printStackTrace();
		} finally {
			return nouvelles;
		}
	}

}