package com.oto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oto.model.Address;
import com.oto.model.Employee;
import com.oto.repo.EmployeeRepo;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepo erepo;
	
	public String addEmployee(Employee e) {
		
		boolean status = erepo.existsById(e.getId());
		
		if(status == false) {
			
			erepo.save(e);
			return "Employee Added successfully!";
		}else {
			return "something wrong!";
		}
	}
	
	public List<Employee> listEmployee(){
		return erepo.findAll();
		
	}
	
	public List<Employee> listAll(int id){
		return erepo.listAll(id);
		
	}
	public String viewEmployee(int id) {
		
		Optional <Employee> e = erepo.findById(id);
		
		if(e.isPresent()) {
			return e.get().toString();
		}else {
			return "Employee Not Found!";
		}
	
	}
	
    public String updateEmployee(Employee e) {
		
		boolean status = erepo.existsById(e.getId());
		
		if(status != false) {
			erepo.save(e);
			return "Employee Updated successfully!";
		}else {
			return "Employee Not Found!";
		}
	}
    
    
    public String deleteEmployee(int id) {
		
		Optional <Employee> e = erepo.findById(id);
		
		if(e.isPresent()) {
			erepo.deleteById(id);
			return "Employee deleted sucessfully!";
		}else {
			return "Employee Not Found!";
		}
	
	}


}
