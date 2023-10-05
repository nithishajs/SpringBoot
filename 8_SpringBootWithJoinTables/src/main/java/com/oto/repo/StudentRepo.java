package com.oto.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.oto.dto.StudentParent;
import com.oto.model.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {
	
	
	 @Query("SELECT new com.oto.dto.StudentParent(s.name, p.pname, p.relation) FROM Student s INNER JOIN Parent p ON s.pid = p.pid WHERE s.id=?1")
	 public List<StudentParent> listAllNamesAndParentNames(int id);

}
