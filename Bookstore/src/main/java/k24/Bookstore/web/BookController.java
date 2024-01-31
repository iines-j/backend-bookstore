package k24.Bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	
	// MAKE DATA
	@Bean
	public CommandLineRunner demo(BookRepository repository) {
		return (args) -> {
			System.out.println("Luodaan demodata");
			// String title, String author, String publicationYear, String isbn, double price
			// repository.save(new Book());
			repository.save(new Book("Varjostus", "Max Myttynen", "2006", "12222331-1"));
			repository.save(new Book("Kellarin väki", "Toni Tapio Taunola", "1999", "424424-133"));
		};	
	}
	
	// BOOKLIST
	@RequestMapping(value="bookList")
	public String bookList(Model model) {
		model.addAttribute("books", repository.findAll());
		return "bookList";
	}

	// DELETE
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public String deleteBook(@PathVariable("id") Long id, Model model) {
		repository.deleteById(id);
		return "redirect:../bookList";
	}
	
	
	// ADD BOOK
	@RequestMapping(value="/add")
	public String addBook(Model model) {
		model.addAttribute("book", new Book());
		return "addBook";
	}
	// SAVE ADDED BOOK
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String save(Book book) {
		repository.save(book);
		return "redirect:bookList";
	}

	
	// EDIT BOOK
	@RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
	public String editBook(@PathVariable("id") Long id, Model model, Book book) {
		model.addAttribute("book", repository.findById(id));
		return "editBook";
	}
	// SAVE EDITED BOOK
	@RequestMapping(value="/saveEdit", method=RequestMethod.POST)
	public String saveEdit(Book book) {
		repository.save(book);
		return "redirect:bookList";
	}

}
