package com.example.repo;

import java.util.List;

import com.example.model.Book;
import com.example.model.Review;

public interface BookDal {
	public Book create(Book b);
	public Book find(String id);
	public List<Book> findall();
	public List<Review> getBookReviews(String id);
	public Review createReview(Review r);
	public Book addReviewToBook(Review r,Book b);
	public boolean deleteBook(String id);
}	
