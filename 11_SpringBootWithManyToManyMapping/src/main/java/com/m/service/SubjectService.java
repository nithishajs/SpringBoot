package com.m.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.m.model.Student;
import com.m.model.Subject;
import com.m.repo.StudentRepository;
import com.m.repo.SubjectRepository;

import jakarta.persistence.EntityNotFoundException;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;
    
    @Autowired
    private StudentRepository StudentRepository;

//    public void saveSubject(Subject SubjectObj) {
//        subjectRepository.save(SubjectObj);
//    }
//
//    public List<Subject> getSubjectDetails(Long SubjectId) {
//        if (null != SubjectId) {
//            return subjectRepository.findAllById(SubjectId);
//        } else {
//            return subjectRepository.findAll();
//        }
//    }
    
    
	
	public String addSubjectsToStudent(int id, Set<Subject> subjects) {
	    Optional<Student> studentOptional = StudentRepository.findById(id);

	    if (studentOptional.isPresent()) {
	        Student student = studentOptional.get();
	        
	        // Associate the subjects with the student
	        subjects.forEach(subject -> subject.getStudents().add(student));

	        // Save the subjects (assuming srepo is a repository for subjects)
	        subjectRepository.saveAll(subjects);

	        return "Subjects added successfully";
	    } else {
	        return "Student not found!";
	    }
	}
	
//	public Subject addSubjectsToStudent(Subject s) {
//		return subjectRepository.save(s);
//	}
//	
	public List<Subject> listSubject(){
		return subjectRepository.findAll();
		
	}
	
	public Subject viewSubject(int id) {
		
		Optional <Subject> op = subjectRepository.findById(id);
		
		if(op.isPresent()) {
			return op.get();
		}else {
			return op.orElseThrow();
		}
	}
	
	public String updateSubject(Subject s) {
		boolean status = subjectRepository.existsById(s.getId());
		
		if(status != false) {
			subjectRepository.save(s);
			return "Subject updated successfully";
		}else {
			return "Subject not found!";
		}
	}
	


    public String deleteSubject(int id) {
    	
     boolean status = subjectRepository.existsById(id);
		
		if(status != false) {
			subjectRepository.deleteById(id);
			return "Subject deleted successfully";
		}else {
			return "Subject not found!";
		}
	}

}
