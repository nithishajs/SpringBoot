package com.msg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.msg.model.Employee;
import com.msg.service.EmployeeService;

@RestController
@RequestMapping
public class EmployeeController {
	
	@Autowired
	EmployeeService eservice;
	
	@PostMapping
	public ResponseEntity <String> Create(@RequestBody Employee em) {
		
		return ResponseEntity.ok(eservice.addEmployee(em));
		
	}
	
	@GetMapping
	public List<Employee> ListAll() {
		return eservice.listAllEmployee();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<String> ListId(@PathVariable int id) {
		return ResponseEntity.ok(eservice.listById(id));
	}
		
	
	@PutMapping("/{id}")
	public ResponseEntity<String> update(@RequestBody Employee em, @PathVariable int id) {
		em.setId(id);
		return ResponseEntity.ok(eservice.updateEmployee(em));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity <String> delete(@PathVariable int id) {
		return ResponseEntity.ok(eservice.deleteEmployee(id));
		
	}

}
