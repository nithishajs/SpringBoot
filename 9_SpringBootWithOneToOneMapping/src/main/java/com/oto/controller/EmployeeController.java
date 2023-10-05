package com.oto.controller;

import java.util.Iterator;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.oto.model.Address;
import com.oto.model.Employee;
import com.oto.service.EmployeeService;

@RestController
@RequestMapping
public class EmployeeController {
	
	@Autowired
	EmployeeService eservice;
	
	@PostMapping
	public ResponseEntity<String> add(@RequestBody Employee e) {
		
		return ResponseEntity.ok(eservice.addEmployee(e));
	}
	
	@GetMapping
	public ResponseEntity<List<Employee>> list() {
		List<Employee> e = eservice.listEmployee();
//		Iterator itr = e.iterator();
//		while(itr.hasNext()) {
//			Employee ds = (Employee)itr.next();
//			
//			System.out.println("--------------------"+ds.getName()+" "+ds.getAddress().getCity());
//		}
		return ResponseEntity.ok(eservice.listEmployee());
	}
	
	@GetMapping("/g/{id}")
	public ResponseEntity<List<Employee>> listAll(@PathVariable int id) {
		return ResponseEntity.ok(eservice.listAll(id));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<String> view(@PathVariable int id) {
		String e = eservice.viewEmployee(id);
		System.out.println("------------"+e.toString());
		return ResponseEntity.ok(eservice.viewEmployee(id));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<String> update(@RequestBody Employee e, @PathVariable int id) {
		e.setId(id);
		return ResponseEntity.ok(eservice.updateEmployee(e));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable int id) {
		return ResponseEntity.ok(eservice.deleteEmployee(id));
	}
	

}
