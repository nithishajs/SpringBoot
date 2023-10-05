package com.oto.controller;

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

import com.oto.model.Parent;
import com.oto.service.ParentService;

@RestController
@RequestMapping("/parent")
public class ParentController {
	
	@Autowired
	ParentService srevice;
	
	@PostMapping
	public String add(@RequestBody Parent s) {
		srevice.addParent(s);
		return "Parent added sucessfully!";	
	}
	
	@GetMapping
	public List<Parent> list(){
		return srevice.listParent();
	}
	
	@GetMapping("/{id}")
	public Parent view(@PathVariable int id){
		return srevice.viewParent(id);
	}
	
	@PutMapping("/{id}")
	public String add(@PathVariable int id, @RequestBody Parent s) {
		s.setPid(id);
		srevice.updateParent(s);
		return "Parent updated sucessfully!";	
	}
	
	@DeleteMapping("/{id}")
	public String add(@PathVariable int id) {
		srevice.deleteParent(id);
		return "Parent deleted sucessfully!";	
	}


}
