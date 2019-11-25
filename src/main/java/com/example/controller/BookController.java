package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Book;
import com.example.model.Review;
import com.example.repo.BookDal;

@CrossOrigin
@RestController
public class BookController {
	
	@Autowired
	private BookDal bookDal;
	
	@RequestMapping(value = "/books", method = RequestMethod.GET, produces = "application/json")
	public List<Book> findall() {
		return bookDal.findall();
	}
	
	@RequestMapping(value = "/books/reviews/{id}", method = RequestMethod.GET, produces = "application/json")
	public List<Review> findReviews(@PathVariable("id") String id){
		return bookDal.getBookReviews(id);
	}
	
	@DeleteMapping(value="/books/{id}")
	public boolean deletBook(@PathVariable("id") String id) {
		return bookDal.deleteBook(id);
	}
	
	@PostMapping(value="/books/new")
	public Book createBook(@RequestBody Book b) {
		return bookDal.create(b);
	}
	
	@PostMapping(value="/books/{id}/{review}")
	public Book newReview(@PathVariable("id") String id , @PathVariable("review") String review) {
		Book b=bookDal.find(id);
		Review r = new Review(review,b);
		bookDal.createReview(r);
		bookDal.addReviewToBook(r, b);
		return b;
	}
	@GetMapping(value="/books/{id}")
	public Book find(@PathVariable("id") String id) {
		return bookDal.find(id);
	}
	
}
