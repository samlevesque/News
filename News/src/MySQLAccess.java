import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLAccess {
    private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    
    private String DRIVER = "com.mysqljdbc.Driver";
    private String CONNECT = "jdbc:mysql://localhost/feedback?";
    private String TIMEZONE_CORRECTIONS = "useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&";
    private String OTHER_CORRECTIONS = "useSSL=false&";
    private String USER = "com.mysql.jdbc.Driver";
    private String PASSWORD = "com.mysql.jdbc.Driver";
    
    public void connect() {
    	try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        // Setup the connection with the DB
        try {
			connect = DriverManager
			        .getConnection("jdbc:mysql://localhost/news?" + TIMEZONE_CORRECTIONS + OTHER_CORRECTIONS 
			                + "user=sqluser&password=sqluserpw");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
    		
    	}
    }


    private void writeResultSet(ResultSet resultSet) throws SQLException {
        // ResultSet is initially before the first data set
        while (resultSet.next()) {
            // It is possible to get the columns via name
            // also possible to get the columns via the column number
            // which starts at 1
            // e.g. resultSet.getSTring(2);
            String user = resultSet.getString("myuser");
            String website = resultSet.getString("webpage");
            String summary = resultSet.getString("summary");
            String comment = resultSet.getString("comments");
            System.out.println("User: " + user);
            System.out.println("Website: " + website);
            System.out.println("summary: " + summary);
            System.out.println("Comment: " + comment);
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

        }
    }

}