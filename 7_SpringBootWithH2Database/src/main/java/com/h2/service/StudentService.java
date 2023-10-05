package com.h2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.h2.exception.NotFoundException;
import com.h2.model.Student;
import com.h2.repo.StudentRepo;

@Service
public class StudentService {
	
	@Autowired
	StudentRepo srepo;
	
	public Student addStudent(Student s) {
		
		boolean status = srepo.existsById(s.getId());
		
		if(status==false) {
			return srepo.save(s);
		}else {
			throw new NotFoundException("Student already exist!");
		}
		
	}
	
	public List<Student> listStudnet(){
		return srepo.findAll();
		
	}
	
	public Student viewStudent(int id) {
		
		Optional<Student> s = srepo.findById(id);
		
		if(s.isPresent()) {
			return s.get();
		}else {
			throw new NotFoundException("Student not found!");
		}
		
	}
	
    public Student updateStudent(Student s) {
		
		boolean status = srepo.existsById(s.getId());
		
		if(status!=false) {
			return srepo.save(s);
		}else {
			throw new NotFoundException("Student not found!");
		}
		
	}
    
    public void deleteStudent(int id) {
		
		boolean status = srepo.existsById(id);
		
		if(status!=false) {
			 srepo.deleteById(id);
		}else {
			throw new NotFoundException("Student not found!");
		}
		
	}

}
