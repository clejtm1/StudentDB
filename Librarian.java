import java.sql.Connection;

public class Librarian extends User {

	public Librarian() {
		// TODO Auto-generated constructor stub
		Connection conn=null;
		conn=DatabaseConnection.getConnection();
	}
	public void run() 
	{
		
	}

}
