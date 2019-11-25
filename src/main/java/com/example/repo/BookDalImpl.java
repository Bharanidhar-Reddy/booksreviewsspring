package com.example.repo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.example.model.Book;
import com.example.model.Review;

@Repository
public class BookDalImpl implements BookDal{

	@Autowired
	private MongoTemplate mongo;
	
	@Override
	public Book create(Book b) {
		return mongo.insert(b);
	}

	@Override
	public Book find(String id) {
		return mongo.find(new Query(Criteria.where("id").is(id)), Book.class).get(0);
	}

	@Override
	public List<Book> findall() {
		return mongo.findAll(Book.class);
	}

	@Override
	public List<Review> getBookReviews(String id) {
		return mongo.find(new Query(Criteria.where("id").is(id)), Book.class).get(0).getReviews();
	}

	@Override
	public Review createReview(Review r) {
		return mongo.save(r);
	}

	@Override
	public Book addReviewToBook(Review r, Book b) {
		b.setReviews(r);
		return mongo.save(b);
	}

	@Override
	public boolean deleteBook(String id) {
		Book b=find(id);
		return mongo.remove(b).wasAcknowledged();
	}

}
