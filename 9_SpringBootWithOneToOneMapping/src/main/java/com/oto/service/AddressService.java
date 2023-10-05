package com.oto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oto.model.Address;
import com.oto.model.Employee;
import com.oto.repo.AddressRepo;
import com.oto.repo.EmployeeRepo;

@Service
public class AddressService {
	
	@Autowired
	AddressRepo arepo;
	
	@Autowired
	EmployeeRepo erepo;
	
   public String addAddress(int id,  Address a) {
		
	
		
	   Optional<Employee> optionalEmployee = erepo.findById(id);

       if (optionalEmployee.isPresent()) {
           Employee employee = optionalEmployee.get();
           employee.setAddress(a);
           arepo.save(a);
           return "Address added successfully!";
       } else {
           return "Employee Not Found!";
       }
		
	}
	
	public List<Address> listAddress(){
		return arepo.findAll();
		
	}
	
	public String viewAddress(int id) {
		
		Optional <Address> e = arepo.findById(id);
		
		if(e.isPresent()) {
			return e.get().toString();
		}else {
			return "Address Not Found!";
		}
	
	}
	
    public String updateAddress(Address a) {
		
		boolean status = arepo.existsById(a.getAid());
		
		if(status != false) {
			arepo.save(a);
			return "Address Updated successfully!";
		}else {
			return "Address Not Found!";
		}
	}
    
    
    public String deleteAddress(int id) {
		
		Optional <Address> e = arepo.findById(id);
		
		if(e.isPresent()) {
			arepo.deleteById(id);
			return "Address deleted sucessfully!";
		}else {
			return "Address Not Found!";
		}
	
	}

}
