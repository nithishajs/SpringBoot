package com.msg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msg.model.Employee;
import com.msg.repo.EmployeeRepo;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepo erepo;


	public String addEmployee(Employee em) {
		boolean status = erepo.existsById(em.getId());
		
		if(status==false) {
			erepo.save(em);
			return "Employee added successfully!";
		}
		else {
			return "Something error!!!";
		}
		
	}


	public List<Employee> listAllEmployee() {
		
        return erepo.findAll();
		
	}


	public String listById(int id)  {
		Optional <Employee> op = erepo.findById(id);
		
		if(op.isPresent()) {
			return op.get().toString();
		}
		else {
			return "Employee not found!";
		}
		
	}

	public String updateEmployee(Employee em) {
		boolean status = erepo.existsById(em.getId());
		
		if(status!=false) {
			erepo.save(em);
			return "Employee updated successfully!";
		}
		else {
			return "Employee not found!";
		}
		
	}


	public String deleteEmployee(int id) {
		 Optional<Employee> op = erepo.findById(id);
			
			if(op.isPresent()) {
				erepo.deleteById(id);
			    return "Deleted Successfully";
			}
			else {
				return "Employee not found!";
			}
	}

}


