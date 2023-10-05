package com.m.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.m.exception.NotFoundException;
import com.m.model.Owner;
import com.m.model.Vehicle;
import com.m.repo.OwnerRepo;
import com.m.repo.VehicleRepo;

@Service
public class VehicleService {
	
	   @Autowired
	   private VehicleRepo vehicleRepo;
	  
	   @Autowired
	   private OwnerRepo ownerRepo;


	    public List<Vehicle> addVehicles(int ownerId, List<Vehicle> vehicles) {
	        Optional<Owner> ownerOptional = ownerRepo.findById(ownerId);
	        
	        if (ownerOptional.isPresent()) {
	            Owner owner = ownerOptional.get();
	            vehicles.forEach(vehicle -> vehicle.setOwner(owner));
//	            owner.setVehicles(vehicles);
	            return vehicleRepo.saveAll(vehicles);
	        } else {
	            throw new NotFoundException("Owner not found!");
	        }
	    }

	    public List<Vehicle> listVehicleOwned(int id){
			return vehicleRepo.findByOwner_Id(id);
			
		}
	 
	public List<Vehicle> listVehicle(){
		return vehicleRepo.findAll();
		
	}
	
	public Vehicle viewVehicle(int id) {
		
		Optional<Vehicle> op = vehicleRepo.findById(id);
		
		if(op.isPresent()) {
			return op.get();
		}else {
			throw new NotFoundException("Vehicle not found!");
		}
	
	}
	
	public Vehicle updateVehicle( Vehicle o) {
		
		boolean status = vehicleRepo.existsById(o.getId());
		
		if(status != false) {
			return vehicleRepo.save(o);
		}else {
			throw new NotFoundException("Vehicle not found!");
		}
	}
	
	public void deleteVehicle( int id) {
		
		boolean status = vehicleRepo.existsById(id);
		
		if(status != false) {
			 vehicleRepo.deleteById(id);
		}else {
			throw new NotFoundException("Vehicle not found!");
		}
	}
}
