package com.example.model;

import javax.annotation.Generated;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;



public class Review {
	
	@Id
	@Generated(value = "com.acme.generator.CodeGen")
	private String id;
	
	private String review;
	
	@DBRef
	private Book book;

	public Review(String review,Book b) {
		super();
		this.review = review;
		this.book=b;
	}

	public String getId() {
		return id;
	}
	
	
	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public Review() {
	}
	
	
	
}
