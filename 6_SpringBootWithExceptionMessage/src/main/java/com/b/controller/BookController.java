package com.b.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.b.model.Book;
import com.b.service.BookService;

@RestController
@RequestMapping
public class BookController {
	
	@Autowired
	BookService bservice;
	
	@PostMapping
	public String add(@RequestBody Book b) {
		bservice.addBook(b);
		return "Book added successfully";
	}
	
	@GetMapping
	public List<Book> list() {
		return bservice.listBook();
	}
	
	@GetMapping("/n/{bname}")
	public List<Book> listName(@PathVariable String bname) {
		return bservice.bookName(bname);
	}
	
	@GetMapping("/p/{bprice}")
	public List<Book> listPrice(@PathVariable float bprice) {
		return bservice.bookPrice(bprice);
	}
	
	@GetMapping("/pn")
	public List<Book> listPricename(@RequestParam String bname, @RequestParam float bprice) {
		return bservice.priceName(bname,bprice);
	}
	
	@GetMapping("/g/{bprice}")
	public List<Book> listGreaterPrice(@PathVariable float bprice) {
		return bservice.greaterPrice(bprice);
	}
	@GetMapping("/{id}")
	public Book view(@PathVariable int id) {
		return bservice.view(id);
	}
	
	@PutMapping("/{id}")
	public String update(@PathVariable int id, @RequestBody Book b) {
		b.setId(id);
		bservice.updateBook(b);
		return "Book updated successfully";
	}
	
	@DeleteMapping("/{id}")
	public String delete(@PathVariable int id) {
		bservice.deleteBook(id);
		return "Book deleted successfully";
	}
}
