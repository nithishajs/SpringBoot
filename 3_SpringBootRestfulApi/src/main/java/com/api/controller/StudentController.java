package com.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.model.Student;
import com.api.service.StudentService;

@RestController
@RequestMapping
public class StudentController {
	
	@Autowired
	StudentService ss;
	
	@PostMapping("/")
	public void add(@RequestBody Student s) {
		ss.save(s);
	}
	
	@GetMapping("/")
	public List<Student> listALL(){
		return ss.list();
	}
	
	@GetMapping("/{id}")
	public Optional<Student> view(@PathVariable int id) {
		return ss.view(id);
		
	}
	
	@PutMapping("/{id}")
	public void update(@RequestBody Student s, @PathVariable int id) {
		s.setId(id);
		ss.save(s);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		ss.delete(id);
	}
}
