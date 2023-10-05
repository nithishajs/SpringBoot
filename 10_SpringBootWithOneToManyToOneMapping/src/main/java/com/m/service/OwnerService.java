package com.m.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.m.model.Owner;
import com.m.model.Vehicle;
import com.m.repo.OwnerRepo;
import com.m.dto.OwnerDto;
import com.m.exception.*;

@Service
public class OwnerService {
	
	    @Autowired
	    private OwnerRepo ownerRepo;

	    public Owner addOwner( Owner o) {
			
			boolean status = ownerRepo.existsById(o.getId());
			
			if(status == false) {
				return ownerRepo.save(o);
			}else {
				throw new NotFoundException("Something went wrong!");
			}
		}
	    
	    public List<Owner> list() {
	        return ownerRepo.findAll();
	    }

	    
	    public Owner viewOwner(int id) {
			
			Optional<Owner> op = ownerRepo.findById(id);
			
			if(op.isPresent()) {
				return op.get();
			}else {
				throw new NotFoundException("Owner not found!");
			}
		
		}
	    
//	    public Owner updateOwner( int id, List<Owner> updatedOwner) {
//	        Optional<Owner> ownerOptional = ownerRepo.findById(id);
//	        
//	        if (ownerOptional.isPresent()) {
//	            Owner owner = ownerOptional.get();
//	            updatedOwner.forEach(vehicle -> owner.setVehicles(owner.getVehicles()));
//	           
//	            return ownerRepo.save(owner);
//	        } else {
//	            throw new NotFoundException("Owner not found!");
//	        }
//	    }
	    
	
	    public Owner updateOwner( Owner o) {
			
	 			boolean status = ownerRepo.existsById(o.getId());
	 			
	 			if(status != false) {
	 				return ownerRepo.save(o);
	 			}else {
	 				throw new NotFoundException("Owner not found!");
	 			}
	 		}
	    

	    public void deleteOwner( int id) {
			
			boolean status = ownerRepo.existsById(id);
			
			if(status != false) {
				ownerRepo.deleteById(id);
			}else {
				throw new NotFoundException("Owner not found!");
			}
		}

}
