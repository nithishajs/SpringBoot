package com.b.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.b.model.Book;
import com.b.repo.BookRepo;
import com.b.exception.*;

@Service
public class BookService {
	
	@Autowired
	BookRepo brepo;
	
	public Book addBook(Book b) {
		
		boolean status = brepo.existsById(b.getId());
		
		if(status==false) 
			return brepo.save(b);
		else {
			throw new NotFound("Book already exist!");
		}	
	}
	
	public List<Book> listBook(){
		return brepo.findAll();
	}

	public List<Book> bookName(String bname){
		return brepo.findByBname(bname);
	}
	
	public List<Book> bookPrice(float bprice){
		return brepo.findByBprice(bprice);
	}
	
	public List<Book> greaterPrice(float bprice){
		return brepo.findGreaterPrice(bprice);
	}
	
	public List<Book> priceName(String bname, float bprice){
		return brepo.findPriceName(bname, bprice);
	}
	
	public Book view(int id){
		
		Optional<Book> b = brepo.findById(id);
		
		if(b.isPresent()) 
			return b.get();
		else {
			throw new NotFound("Book not found!");
		}
	}
	
	public Book updateBook(Book b){
		
		boolean status = brepo.existsById(b.getId());
		
		if(status!=false) 
			return brepo.save(b);
		else {
			throw new NotFound("Book not found!");
		}	
	}
	
	public void deleteBook(int id) throws NotFound {
		
		boolean status = brepo.existsById(id);
		
		if(status!=false) 
	        brepo.deleteById(id);
		else {
			throw new NotFound("Book not found!");
		}	
	}
}
