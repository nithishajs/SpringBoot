package com.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.model.Student;
import com.api.repo.StudentRepo;

@Service
public class StudentService {
	
	@Autowired
	StudentRepo srepo;
	
	public void save(Student s ) {
		srepo.save(s);
	}

	public List<Student> list(){
		return srepo.findAll();
	}
	
	public Optional<Student> view( int id) {
		return srepo.findById(id);
		
	}
	
	public void update(Student s ) {
		srepo.save(s);
	}
	
	public void delete(int id) {
		srepo.deleteById(id);
	}
	
	
}
