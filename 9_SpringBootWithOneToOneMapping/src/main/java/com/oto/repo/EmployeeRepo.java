package com.oto.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.oto.model.Employee;



@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer>{
	
	@Query("FROM Employee e INNER JOIN Address a ON e.address.aid=a.aid WHERE e.id = :id")
	List<Employee> listAll(int id);

}