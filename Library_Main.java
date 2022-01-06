import java.sql.Connection;
import java.util.*;


public class Library_Main {
//There are 3 tables Books and Students and Student_Book
//Books has id (primary key) Title, and  author's (last) name (there can be multiple books with the same title and  author)
//Students has id(primary key), lName, fName, and balance
//Student_Book has studentID which references Students.id, bookID which references Book.id and dueDate 
//and 2 users Student and Librarian
//General user upon logging with id can
//             a) query all books which are available
//             b) query a specific book by title 
//             c) borrow a book (when a book is borrowed no other student  can borrow that specific book add a dueDate of 3 weeks from when book is borrowed)
//             d) return a book ( when the book is returned the student another student can borrow the book and the dueDate goes to null)
//             e) check what books they borrowed and their due date
//             f) pay the balance
//Librarian upon logging in with id (0) can:
//             a)query all books which are available
//             b)query a specific book by title
//             c)add a student
//             d)delete a student
//	           e)query all students and their balances
//             f)add a book 
//             g)delete a book
//             h)query all the books a specific student borrowed

    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn = null;
		conn = DatabaseConnection.getConnection();
		System.out.println("Connected to database");
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter in an id");
		User u=UserFactory.getUser(scan.nextInt());
		u.run();
		

	}

}
