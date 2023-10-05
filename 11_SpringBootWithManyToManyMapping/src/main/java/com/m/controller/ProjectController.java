package com.m.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.m.model.Project;
import com.m.repo.EmployeeRepository;
import com.m.repo.ProjectRepository;
import com.m.service.ProjectService;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;
    
    @Autowired
    private ProjectRepository srepo;

    @Autowired
    private EmployeeRepository strepo;

    @PostMapping("/save")
    public ResponseEntity createProject(@RequestBody Project projectObj) {
        projectService.saveProject(projectObj);
        return new ResponseEntity(HttpStatus.CREATED);
    }
//    @PostMapping("/{id}")
//    public List<Project> addProjectsToEmployee(Long id, Set<Project> Projects) {
//    	
//    
//        Set<Employee> EmployeeOptional = strepo.findAllByEmpId(id);
//
//        if (EmployeeOptional!=null) {
//           
//            
//            Projects.forEach(vehicle -> vehicle.setEmployeeSet(EmployeeOptional.addAll(EmployeeOptional)));
////            owner.setVehicles(vehicles);
//            return srepo.saveAll(Projects);
//
//            // Save the Projects first if they are not already saved
//            for (Project project : Projects) {
//                if (project.getProjectId() == null) {
//                	srepo.save(project);
//                }
//            }
//
//            // Associate the Projects with the Employee
//            Employee.getAssignedProjects().addAll(Projects);
//
//            // Save the Employee entity (this will update the associations)
//            strepo.save(Employee);
//
//            return "Projects added successfully";
//        } else {
//            return "Employee not found!";
//        }
//    }

    @GetMapping(value = {"/getProjects", "/{projectId}"})
    public List<Project> getProjects(@PathVariable(required = false) Long projectId) {
        return projectService.getProjectDetails(projectId);
    }

    @DeleteMapping("/delete/{projectId}")
    public ResponseEntity removeProject(@PathVariable Long projectId) {
        projectService.deleteProject(projectId);
        return new ResponseEntity(HttpStatus.OK);
    }
}
