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
	
	private String title;
	private String author;
	private String publicationYear;
	private String isbn;
	// private double price;
	
	public Book() {}
	
	//  double price 		this.price = price;
	public Book(String title, String author, String publicationYear, String isbn) {
		this.title = title;
		this.author = author;
		this.publicationYear = publicationYear;
		this.isbn = isbn;
	}
	
	public Long getId() {
		return this.id;
	}
	public void setId(Long id) {
		this.id=id;
	}
	
	public String getAuthor() {
		return this.author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public String getTitle() {
		return this.title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getPublicationYear() {
		return this.publicationYear;
	}
	public void setPublicationYear(String publicationYear) {
		this.publicationYear = publicationYear;
	}
	
	public String getIsbn() {
		return this.isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
}
