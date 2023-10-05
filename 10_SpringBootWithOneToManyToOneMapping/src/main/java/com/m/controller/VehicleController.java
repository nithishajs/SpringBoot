package com.m.controller;

import java.util.List;
import java.util.Set;

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

import com.m.dto.VehicleDto;
import com.m.model.Vehicle;
import com.m.repo.VehicleRepo;
import com.m.service.VehicleService;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;
    

    @PostMapping("/{id}")
    public ResponseEntity<String> createVehicle(@PathVariable int id, @RequestBody List<Vehicle> vehicle) {
        vehicleService.addVehicles(id,vehicle);
        return ResponseEntity.ok("Vehicles Added Successfully");
    }

    @GetMapping
	public ResponseEntity<List<Vehicle>> list() {
		return ResponseEntity.ok(vehicleService.listVehicle());
	}
	
	@GetMapping("{id}/owned")
	public ResponseEntity<List<Vehicle>> listOwned(@PathVariable int id) {
		return ResponseEntity.ok(vehicleService.listVehicleOwned(id));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Vehicle> view(@PathVariable int id) {

		return ResponseEntity.ok(vehicleService.viewVehicle(id));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<String> update(@RequestBody Vehicle e, @PathVariable int id) {
		e.setId(id);
		vehicleService.updateVehicle(e);
		return ResponseEntity.ok("Vehicle Updated Succesfully");
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable int id) {
		vehicleService.deleteVehicle(id);
		return ResponseEntity.ok("Vehicle Deleted Succesfully");
	}

}