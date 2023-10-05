package com.m.repo;


import org.springframework.data.jpa.repository.JpaRepository;

import com.m.model.Employee;
import com.m.model.Student;

import java.util.List;


public interface StudentRepository extends JpaRepository<Student, Integer> {
    List<Student> findAllById(Long stdId);
}
