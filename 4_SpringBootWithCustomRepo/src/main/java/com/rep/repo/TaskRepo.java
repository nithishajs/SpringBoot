package com.rep.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rep.model.Task;

@Repository
public interface TaskRepo extends JpaRepository<Task, Integer> {
	
	List<Task> CompletedTrue();
	List<Task> CompletedFalse();

}
