package com.m.repo;


import org.springframework.data.jpa.repository.JpaRepository;

import com.m.model.Employee;

import java.util.List;


public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findAllByEmpId(Long empId);
}
