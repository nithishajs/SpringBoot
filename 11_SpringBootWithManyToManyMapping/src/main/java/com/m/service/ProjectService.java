package com.m.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.m.model.Project;
import com.m.repo.ProjectRepository;

import java.util.List;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public void saveProject(Project projectObj) {
        projectRepository.save(projectObj);
    }

    public List<Project> getProjectDetails(Long projectId) {
        if (null != projectId) {
            return projectRepository.findAllByProjectId(projectId);
        } else {
            return projectRepository.findAll();
        }
    }

    public void deleteProject(Long projectId) {
        projectRepository.deleteById(projectId);
    }
}
