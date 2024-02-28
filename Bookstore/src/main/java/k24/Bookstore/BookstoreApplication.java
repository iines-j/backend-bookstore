package k24.Bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import k24.Bookstore.domain.AppUserRepository;
import k24.Bookstore.domain.AppUser;
import k24.Bookstore.domain.Book;
import k24.Bookstore.domain.BookRepository;
import k24.Bookstore.domain.Category;
import k24.Bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	// MAKE DATA
	@Bean
	public CommandLineRunner demo(BookRepository repository, CategoryRepository crepository, AppUserRepository urepository) {
		return (args) -> {
			System.out.println("Luodaan demodata");
			
			Category c1 = new Category("SciFi");
			Category c2 = new Category("Horror");
			Category c3 = new Category("Romance");
			
			crepository.save(c1);
			crepository.save(c2);
			crepository.save(c3);
			
			
			// String title, String author, String publicationYear, String isbn, double price
			// repository.save(new Book());
			repository.save(new Book("Varjostus", "Max Myttynen", "2006", "12222331-1", c1));
			repository.save(new Book("Kellarin väki", "Toni Tapio Taunola", "1999", "424424-133", c3));
			
			
			// CREATE USERS
			// Create users: admin/admin user/user
			AppUser user1 = new AppUser("user", "$2a$10$w..2V64Ch2dRemyEksOc6ekQlcfgq0wiHXaBIaUDHVej2SD5wUlIa", "USER");
			AppUser user2 = new AppUser("admin", "$2a$10$UsuNBBhiW9CGU/vE1ISB8ufJpT6hRwEAtx8mHX4YcXp9Ofq4n6SLW", "ADMIN");
			urepository.save(user1);
			urepository.save(user2);
			
		};	
	}
	
	
	
}
