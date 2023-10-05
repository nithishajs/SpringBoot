package com.rep.controller;

import java.util.List;
import java.util.Optional;

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

import com.rep.model.Task;
import com.rep.service.TaskService;

@RestController
@RequestMapping
public class TaskController {
	
	@Autowired
	TaskService tservice;
	
	@PostMapping
	public ResponseEntity<String> add(@RequestBody  Task t){
		tservice.addTask(t);
		return ResponseEntity.ok("Task added");
		
	}
	
	@GetMapping
	public ResponseEntity<List<Task>> list(){
		return ResponseEntity.ok(tservice.listTask());
		
	}
	
	@GetMapping("/t")
	public ResponseEntity<List<Task>> completedt(){
		return ResponseEntity.ok(tservice.listCompletedTask());
		
	}
	
	@GetMapping("/f")
	public ResponseEntity<List<Task>> inCompleted(){
		return ResponseEntity.ok(tservice.listInCompletedTask());
		
	}

	@GetMapping("/{id}")
	public ResponseEntity<Optional<Task>> view(@PathVariable int id){
		return ResponseEntity.ok(tservice.viewTask(id));
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<String> update(@PathVariable int id, @RequestBody  Task t){
		t.setId(id);
		tservice.addTask(t);
		return ResponseEntity.ok("Task Updated");
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable int id){
		tservice.deleteTask(id);
		return ResponseEntity.ok("Task Deleted");
		
	}
}
