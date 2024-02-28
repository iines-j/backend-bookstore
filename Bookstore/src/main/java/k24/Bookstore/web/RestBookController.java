package k24.Bookstore.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import k24.Bookstore.domain.BookRepository;
import k24.Bookstore.domain.Book;

@RestController
public class RestBookController {
	
	@Autowired
	private BookRepository repository;
	
	// get ALL books
    @RequestMapping(value="/books", method = RequestMethod.GET)
    public @ResponseBody Iterable<Book> bookListRest() {	
        return repository.findAll();
    }    
    
    // get ONE book BY ID
    @RequestMapping(value="/book/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<Book> bookRest(@PathVariable("id") Long id) {	
        return repository.findById(id);
    } 
    
    // ADD
    @PostMapping("books")
    Book newBook(@RequestBody Book newBook) {
    	return repository.save(newBook);
    }
    
    // EDIT
    @PutMapping("/books/{id}")
    Book editBook(@RequestBody Book editedBook, @PathVariable Long id) {
    	editedBook.setId(id);
    	return repository.save(editedBook);
    }
    
    // DELETE
    @DeleteMapping("/books/{id}")
    public Iterable<Book> deleteBook(@PathVariable Long id) {
    	repository.deleteById(id);
    	return repository.findAll();
    }
}
