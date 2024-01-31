package k24.Bookstore.domain;

public class Book {
	public String title;
	public String author;
	public String publicationYear;
	public String isbn;
	public double price;
	
	public Book(String title, String author, String publicationYear, String isbn, double price) {
		this.title = title;
		this.author = author;
		this.publicationYear = publicationYear;
		this.isbn = isbn;
		this.price = price;
	}
}
