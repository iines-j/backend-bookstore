package k24.Bookstore.domain;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	public String title;
	public String author;
	public String publicationYear;
	public String isbn;
	public double price;
	
	public Book() {}
	
	public Book(String title, String author, String publicationYear, String isbn, double price) {
		this.title = title;
		this.author = author;
		this.publicationYear = publicationYear;
		this.isbn = isbn;
		this.price = price;
	}
}
