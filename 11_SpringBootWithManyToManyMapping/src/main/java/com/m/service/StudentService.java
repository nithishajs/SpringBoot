package com.m.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.m.model.Student;
import com.m.repo.StudentRepository;
import com.m.repo.SubjectRepository;

import java.util.List;
import java.util.Optional;


@Service
public class StudentService {

    @Autowired
    private StudentRepository StudentRepository;
    
    public String addStudent(Student s) {
		boolean status = StudentRepository.existsById(s.getId());
		
		if(status == false) {
			StudentRepository.save(s);
			return "Student added successfully";
		}else {
			return "Something wrong!";
		}
	}
	
	public List<Student> listStudent(){
		
		return StudentRepository.findAll();
		
	}

//    public void saveStudent(Student empObj) {
//        StudentRepository.save(empObj);
//    }
//
//    public List<Student> getStudentDetails(Long stdId) {
//        if (null != stdId) {
//            return StudentRepository.findAllById(stdId);
//        } else {
//            return StudentRepository.findAll();
//        }
//    }

    public Student viewStudent(int id) {
		
		Optional <Student> op = StudentRepository.findById(id);
		
		if(op.isPresent()) {
			return op.get();
		}else {
			return op.orElseThrow();
		}
	}
	
	public String updateStudent(Student s) {
		boolean status = StudentRepository.existsById(s.getId());
		
		if(status != false) {
			StudentRepository.save(s);
			return "Student updated successfully";
		}else {
			return "Student not found!";
		}
	}
	
	public String deleteStudent(int id) {
		boolean status = StudentRepository.existsById(id);
		
		if(status != false) {
			StudentRepository.deleteById(id);
			return "Student deleted successfully";
		}else {
			return "Student not found!";
		}
	}
}
