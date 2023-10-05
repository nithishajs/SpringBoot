package com.m.repo;


import org.springframework.data.jpa.repository.JpaRepository;

import com.m.model.Project;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Long> {
    List<Project> findAllByProjectId(long projectId);
}
