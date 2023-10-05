package com.rep.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rep.model.Task;
import com.rep.repo.TaskRepo;

@Service
public class TaskService {
	
	@Autowired
	TaskRepo trepo;
	
	public void addTask(Task t) {
		trepo.save(t);
	}
	
	public List<Task> listTask() {
		return trepo.findAll();
	}
	
	public List<Task> listCompletedTask() {
		return trepo.CompletedTrue();
	}
	
	public List<Task> listInCompletedTask() {
		return trepo.CompletedFalse();
	}
	
	public Optional<Task> viewTask(int id) {
		return trepo.findById(id);
	}
		
	public void updateTask(Task t) {
		trepo.save(t);
	}

	public void deleteTask(int id) {
		trepo.deleteById(id);
	}
}
