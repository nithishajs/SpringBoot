package com.oto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oto.model.Parent;
import com.oto.repo.ParentRepo;
import com.oto.exception.*;

@Service
public class ParentService {
	
	@Autowired
	ParentRepo repo;
	
   public Parent addParent(Parent s) {
		
		boolean status = repo.existsById(s.getPid());
		
		if(status==false) {
			return repo.save(s);
		}else {
			throw new NotFoundException("Parent already exist!");
		}
		
	}
	
	public List<Parent> listParent(){
		return repo.findAll();
		
	}
	
	public Parent viewParent(int id) {
		
		Optional<Parent> s = repo.findById(id);
		
		if(s.isPresent()) {
			return s.get();
		}else {
			throw new NotFoundException("Parent not found!");
		}
		
	}
	
    public Parent updateParent(Parent s) {
		
		boolean status = repo.existsById(s.getPid());
		
		if(status!=false) {
			return repo.save(s);
		}else {
			throw new NotFoundException("Parent not found!");
		}
		
	}
    
    public void deleteParent(int id) {
		
		boolean status = repo.existsById(id);
		
		if(status!=false) {
			repo.deleteById(id);
		}else {
			throw new NotFoundException("Parent not found!");
		}
		
	}

}



