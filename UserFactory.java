import java.util.*;
import java.sql.*;
public class UserFactory {
static int id;
public static Scanner scan=new Scanner(System.in);
public static User getUser(int userID) 
{
	Connection conn = null;
	conn = DatabaseConnection.getConnection();
	HashSet<Integer> ids = new HashSet<Integer>();
	if(userID==-1) 
	{
		return new Librarian();
	}
	else {
		id=userID;
		try  { 
			String checkIDQuery="select studentID from Student_Library;";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(checkIDQuery);
			while (rs.next()) 
			{
				int studentID=rs.getInt("studentID");
				ids.add(studentID);  
			}
		} catch (SQLException e) {
			e.printStackTrace();}
		while(!ids.contains(id))
		{
			System.out.println("That id is not in use. Please enter your id.");
			id=scan.nextInt();
			
		}
	return new General_User(id);
	}
}
}
