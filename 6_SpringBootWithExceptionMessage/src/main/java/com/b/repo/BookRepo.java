package com.b.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.b.model.Book;

@Repository
public interface BookRepo extends JpaRepository<Book, Integer> {
	
	List<Book> findByBname(String bname);
	List<Book> findByBprice(float bprice);
	
	@Query("select b from Book b where b.bprice>?1")
	List<Book> findGreaterPrice(float bprice);
	
	@Query("select b from Book b where b.bname>=?1 and b.bprice>?2")
	public List<Book> findPriceName(String bname, float bprice);
}
