package k24.Bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import k24.Bookstore.domain.Book;
import k24.Bookstore.domain.BookRepository;

@Controller
public class BookController {
	
	@Autowired
	private BookRepository repository;

	@GetMapping("index")
	public String indexPage() {
		return "index";
	}
	
	@Bean
	public CommandLineRunner demo(BookRepository repository) {
		return (args) -> {
			System.out.println("Luodaan demodata");
			// String title, String author, String publicationYear, String isbn, double price
			// repository.save(new Book());
			repository.save(new Book("Varjostus", "Max Myttynen", "2006", "12222331-1", 40));
			repository.save(new Book("Kellarin väki", "Toni Tapio Taunola", "1999", "424424-133", 20.2));
		};
		
	}
	
	@RequestMapping(value="bookList")
	public String bookList(Model model) {
		model.addAttribute("books", repository.findAll());
		return "bookList";
	}
	

}
