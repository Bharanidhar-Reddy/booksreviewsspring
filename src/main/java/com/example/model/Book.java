package com.example.model;

import java.util.LinkedList;
import java.util.List;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Document(collection = "books")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
public class Book {
	
	@Id
	private String id;
	
	private String name;
	private String author;
	private String price;
	
	@DBRef
	private List<Review> reviews = new LinkedList<Review>(); 

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
	
	
	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(Review r) {
		this.reviews.add(r);
	}


	public Book() {
		super();
	}
	
}
