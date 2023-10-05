package com.h2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.h2.model.Student;
import com.h2.service.StudentService;

@RestController
@RequestMapping
public class StudentController {
	
	@Autowired
	StudentService srevice;
	
	@PostMapping
	public String add(@RequestBody Student s) {
		srevice.addStudent(s);
		return "Student added sucessfully!";	
	}
	
	@GetMapping
	public List<Student> list(){
		return srevice.listStudnet();
	}
	
	@GetMapping("/{id}")
	public Student view(@PathVariable int id){
		return srevice.viewStudent(id);
	}
	
	@PutMapping("/{id}")
	public String add(@PathVariable int id, @RequestBody Student s) {
		s.setId(id);
		srevice.updateStudent(s);
		return "Student updated sucessfully!";	
	}
	
	@DeleteMapping("/{id}")
	public String add(@PathVariable int id) {
		srevice.deleteStudent(id);
		return "Student deleted sucessfully!";	
	}

}
