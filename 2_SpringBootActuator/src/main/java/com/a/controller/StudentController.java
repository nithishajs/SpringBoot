package com.a.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.a.model.Student;
import java.util.*;
@RestController
@RequestMapping
public class StudentController {
	

	Student s;
	
	@GetMapping("/list")
	public List<Student> listAll() {
		
		List <Student> l = new ArrayList <Student> ();
		
		s = new Student();
		s.setId(1);
		s.setName("Nithish");
		s.setDepartment("Ece");
		s.setCollege("VEC");
		
		l.add(s);
		
		s = new Student(2,"sam","it","NBV");
		l.add(s);
		
		for(Student x : l) {
			System.out.println(x.getId()+" "+ x.getName()+" "+x.getDepartment()+" "+x.getCollege());
		}
		return l;
		
		
	}

}
