package k24.Bookstore.web;

import org.springframework.web.bind.annotation.GetMapping;

public class BookController {

	@GetMapping("index")
	public String indexPage() {
		return "index";
	}
	
}
