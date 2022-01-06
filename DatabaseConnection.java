// This is the singleton desighn pattern it returns only one instance of connection
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class DatabaseConnection {
	 private static Connection con = null;
	  
	    static
	    {
	        String url = "jdbc:mysql:// localhost:3306/students";
	        String user = "root";
	        String pass = "#DizzleTizzle01";
	        try {
	            Class.forName("com.mysql.jdbc.Driver");
	            con = DriverManager.getConnection(url, user, pass);
	        }
	        catch (ClassNotFoundException | SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    public static Connection getConnection()
	    {
	        return con;
	    }
	    public static void closeConnection() 
	    {
	    	 try {
	 			con.close();
	 			System.out.println("Connection Closed");
	 		} catch (SQLException e) {
	 			// TODO Auto-generated catch block
	 			e.printStackTrace();
	 		}
	    }
		public static boolean executeUpdate( String command) throws SQLException {
		    Statement stmt = null;
		    try {
		        stmt = con.createStatement();
		        stmt.executeUpdate(command); // This will throw a SQLException if it fails
		        return true;
		    } finally {

		    	// This will run whether we throw an exception or not
		        if (stmt != null) { stmt.close(); }
		    }
		}
		public static void exec(String q) 
		{
			try {
				   
				String insert=q;
				DatabaseConnection.executeUpdate(insert);
				
			    } catch (SQLException e) {
				
				e.printStackTrace();
				return;
				}
			}

}
