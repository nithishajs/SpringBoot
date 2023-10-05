package com.api.repo;

import org.springframework.stereotype.Repository;

import com.api.model.Student;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {
	
}
