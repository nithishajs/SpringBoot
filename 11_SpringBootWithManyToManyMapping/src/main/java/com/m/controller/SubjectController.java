package com.m.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.m.model.Subject;
import com.m.repo.StudentRepository;
import com.m.repo.SubjectRepository;
import com.m.service.SubjectService;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/Subject")
public class SubjectController {

    @Autowired
    private SubjectService service;
    
    @Autowired
    private SubjectRepository srepo;

    @Autowired
    private StudentRepository strepo;

	
	@PostMapping("/{id}")
	public ResponseEntity<String> add(@PathVariable int id, @RequestBody Set<Subject> s){
		return ResponseEntity.ok(service.addSubjectsToStudent(id, s));
		
	}
	
//	@PostMapping()
//	public ResponseEntity<Subject> add(Subject s){
//		return ResponseEntity.ok(service.addSubjectsToStudent(s));
//		
//	}
	
	@GetMapping
	public ResponseEntity<List<Subject>> list(){
		return ResponseEntity.ok(service.listSubject());
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Subject> view(@PathVariable int id){
		return ResponseEntity.ok(service.viewSubject(id));
		
	}
	
	@GetMapping("/student/{id}")
	public ResponseEntity<List<Subject>> viewStud(@PathVariable int id){
		return ResponseEntity.ok(srepo.findByStudentsId(id));
		
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<String> upadte(@PathVariable int id, @RequestBody Subject s){
		s.setId(id);
		return ResponseEntity.ok(service.updateSubject(s));
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable int id){
		service.deleteSubject(id);
		return ResponseEntity.ok("Dleted");
		
	}
}
