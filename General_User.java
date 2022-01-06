import java.sql.*;
import java.util.*;





//General user upon logging with id can
//             a) query all books which are available done
//             b) query a specific book by title  done
//             c) put a book in the shoppingCart
//             c) borrow a book (when a book is borrowed no other student  can borrow that specific book add a dueDate of 3 weeks from when book is borrowed)
//             d) return a book ( when the book is returned the student another student can borrow the book and the dueDate goes to null)
//             e) check what books they borrowed and their due date
//             f) pay the balance


public class General_User extends User {
	private int userID;
	private int choice;
	private String query;
	private int bookID=0;
	private String title;
	private String titleChoice;
	private String author;
	private int continueChoice;
	Scanner scan=new Scanner(System.in);
	Connection conn=DatabaseConnection.getConnection();
	public General_User(int userID) 
	{
		// TODO Auto-generated constructor stub


		this.userID=userID;


	}
	public void run()
	{
		System.out.println("Welcome to the main menu.\n"
				+"Enter in an option what to do:\n"
				+"1 to borrow books.\n"
				+"2 to borrow a specific book by title.\n"
				+"3 to borrow a book.\n"
				+"4 to return books.\n"
				+"5 to check what books you borrowed and their due date.\n"
				+"6 to pay the balance");
		choice=scan.nextInt();
		switch(choice) 
		{

		case 1:
		{
			System.out.println("To search all books that are available to borrow press 1, To search for a specific book by title press 2 "); 
			if(scan.nextInt()==1)
				{query="select book.bookID,book.title,book.author from Book where book.bookID not in (select book.bookID from book, Student_Book where book.bookID=student_book.bookID) ;";
				scan.nextLine();}
			else
			{
				scan.nextLine();//This line is put in to use up a /n
				String title;
				System.out.println("Please enter a title");
				title=scan.nextLine();
				
				query="select * from Book where title="+"\""+title+"\"and book.bookID not in (select book.bookID from book, Student_Book where book.bookID=student_book.bookID) ;";
			}
			try  {
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(query);
				while (rs.next()) {
					bookID=rs.getInt("bookID");  
					String title= rs.getString("title");
					String author= rs.getString("author");


					System.out.println("bookID:"+bookID+ ", title:" +title  + " , author:" + author);
				}
				if(bookID==0) 
				{
					System.out.println("That book is not in stock in the library");
				}
			} catch (SQLException e) {
				e.printStackTrace();}
			System.out.println("To add a book to your shopping cart enter their bookID number. To borrow multiple books enter their id number followed by a comma between each book"
				+"(ie 1, 4, 5 to borrow the books with the ids of 1 , 4  and 5");
			
			String shoppingCart=scan.nextLine();
			String []res=shoppingCart.split("[,]",0);
			int [] idList= new int[res.length];
			ArrayList<Book>bookList=new ArrayList<Book>();
			 for(int i=0;i<res.length;i++) {
				    try{
			            idList[i] = Integer.parseInt(res[i]);
			          
			        }
			        catch (NumberFormatException ex){
			        	System.out.println("You have entered an invalid number");
			            ex.printStackTrace();
			        }
				    bookID=0;
				    query="select * from Book where book.bookID not in (select book.bookID from book, Student_Book where book.bookID=student_book.bookID)and book.bookID="+idList[i]+";";
					try  {
						Statement stmt = conn.createStatement();
						ResultSet rs = stmt.executeQuery(query);
						while (rs.next()) {
							bookID=rs.getInt("bookID");  
							String title= rs.getString("title");
							String author= rs.getString("author");
					        if(bookID!=0) 
							{
					        Book b=new Book(bookID,title,author);
					        bookList.add(b);
					        System.out.println("bookID:"+bookID+ ", title:" +title  + " , author:" + author);
					        }
					        else
					        	System.out.println("Book with bookID"+idList[i]+"is not in stock");
					        
						}
					} catch (SQLException e) {
						e.printStackTrace();}
		       }
			System.out.println("To actualy borrow the books enter 1 ");
			if(scan.nextInt()==1)
				
			//Insert 
			for(int i=0;i<bookList.size();i++) {
			try {
				   
				String insert ="insert into Student_Book(StudentID, bookID, dueDate) values("+userID+","+bookList.get(i).getID()+","+" DATE_ADD(now(), INTERVAL 3 WEEK) );";
				DatabaseConnection.executeUpdate(insert);
				
			    } catch (SQLException e) {
				
				e.printStackTrace();
				return;
				}
			}
		}
		break;
		}

	}

}
