package com.m.controller;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.m.dto.OwnerDto;
import com.m.dto.VehicleDto;
import com.m.model.Owner;
import com.m.model.Vehicle;
import com.m.repo.OwnerRepo;
import com.m.service.OwnerService;

@RestController
@RequestMapping("/owners")
public class OwnerController {

    @Autowired
    private OwnerService ownerService;
    

   
    @PostMapping
	public ResponseEntity<String> add(@RequestBody Owner o) {
    	ownerService.addOwner(o);
		return ResponseEntity.ok("Owner Added Succesfully");
	}

    
    
    @GetMapping
    public ResponseEntity<List<Owner>> getDetails() {

        return ResponseEntity.ok(ownerService.list());
    }
    
    @GetMapping("/{id}")
	public ResponseEntity<Owner> view(@PathVariable int id) {
	  
	    return ResponseEntity.ok(ownerService.viewOwner(id));
	}


    @PutMapping("/{ownerId}")
    public ResponseEntity<Owner> updateOwner(@PathVariable int ownerId, @RequestBody Owner updatedOwner) {
    	updatedOwner.setId(ownerId);
        Owner updated = ownerService.updateOwner(updatedOwner);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable int id) {
    	ownerService.deleteOwner(id);
		return ResponseEntity.ok("Owner Deleted Succesfully");
	}
}
