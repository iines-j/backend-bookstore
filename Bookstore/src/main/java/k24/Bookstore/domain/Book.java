package k24.Bookstore.domain;
import jakarta.persistence.*;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotEmpty(message="Author cannot be empty")
	@Size(min = 2, max = 250)
	private String author;
	
	@NotEmpty(message="Title cannot be empty")
	@Size(min = 2, max = 250)
	private String title;
	
	@NotEmpty(message="Year cannot be empty")
	@Size(min = 2, max = 250)
	private String publicationYear;

	@NotEmpty(message="ISBN cannot be empty")
	@Size(min = 2, max = 250)
	private String isbn;
	// private double price;
	
	@ManyToOne
	@JoinColumn(name="categoryid")
	private Category category;
	
	public Book() {}
	
	//  double price 		this.price = price;
	public Book(String title, String author, String publicationYear, String isbn, Category category) {
		this.title = title;
		this.author = author;
		this.publicationYear = publicationYear;
		this.isbn = isbn;
		this.category = category;
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
	
	public Category getCategory() {
		return this.category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
}
