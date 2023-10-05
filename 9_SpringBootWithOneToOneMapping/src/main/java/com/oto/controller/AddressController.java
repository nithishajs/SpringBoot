package com.oto.controller;

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

import com.oto.model.Address;
import com.oto.service.AddressService;

@RestController
@RequestMapping("/address")
public class AddressController {
	
	@Autowired
	AddressService eservice;
	
	
	
	@PostMapping("/{id}/add")
	public void add(@PathVariable int id, @RequestBody Address a) {
		 eservice.addAddress(id, a);
	}
	
	@GetMapping
	public ResponseEntity<List<Address>> list() {
		return ResponseEntity.ok(eservice.listAddress());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<String> view(@PathVariable int id) {
		return ResponseEntity.ok(eservice.viewAddress(id));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<String> update(@RequestBody Address a, @PathVariable int id) {
		a.setAid(id);
		return ResponseEntity.ok(eservice.updateAddress( a));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable int id) {
		return ResponseEntity.ok(eservice.deleteAddress(id));
	}

}
