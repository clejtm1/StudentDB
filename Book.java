
public class Book {
private int id;
private String title;
private String author;
public Book(int id, String title, String author)
{
	this.id=id;
	this.title=title;
	this.author=author;
}
public String toString()
{
	return "bookID"+this.id+"title"+this.title+"author"+this.author;
}
public int getID() 
{
	return this.id;
}

}
