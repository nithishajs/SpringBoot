package com.oto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oto.model.Student;
import com.oto.repo.StudentRepo;
import com.oto.dto.StudentParent;
import com.oto.exception.*;

@Service
public class StudentService {
	
	@Autowired
	StudentRepo repo;

 public Student addStudent(Student s) {
		
		boolean status = repo.existsById(s.getId());
		
		if(status==false) {
			return repo.save(s);
		}else {
			throw new NotFoundException("Student already exist!");
		}
		
	}
	
	public List<Student> listStudnet(){
		return repo.findAll();
		
	}
	
	public List<StudentParent> listStudnetParent(int id){
		return repo.listAllNamesAndParentNames(id);
		
	}
	
	public Student viewStudent(int id) {
		
		Optional<Student> s = repo.findById(id);
		
		if(s.isPresent()) {
			return s.get();
		}else {
			throw new NotFoundException("Student not found!");
		}
		
	}
	
    public Student updateStudent(Student s) {
		
		boolean status = repo.existsById(s.getId());
		
		if(status!=false) {
			return repo.save(s);
		}else {
			throw new NotFoundException("Student not found!");
		}
		
	}
    
    public void deleteStudent(int id) {
		
		boolean status = repo.existsById(id);
		
		if(status!=false) {
			 repo.deleteById(id);
		}else {
			throw new NotFoundException("Student not found!");
		}
		
	}

}
