package com.m.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.m.model.Student;
import com.m.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/Student")
public class StudentController {

    @Autowired
    private StudentService service;

    @PostMapping
	public ResponseEntity<String> add(@RequestBody Student s){
		return ResponseEntity.ok(service.addStudent(s));
		
	}
	
	@GetMapping
	public ResponseEntity<List<Student>> list(){
		return ResponseEntity.ok(service.listStudent());
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Student> view(@PathVariable int id){
		return ResponseEntity.ok(service.viewStudent(id));
		
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<String> upadte(@PathVariable int id, @RequestBody Student s){
		s.setId(id);
		return ResponseEntity.ok(service.updateStudent(s));
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable int id){
		return ResponseEntity.ok(service.deleteStudent(id));
		
	}
}
