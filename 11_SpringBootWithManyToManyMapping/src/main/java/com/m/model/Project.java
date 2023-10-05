package com.m.model;





import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import jakarta.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "PROJECT")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long projectId;
    private String projectName;

    @JsonIgnore
    @ManyToMany(mappedBy = "assignedProjects",cascade=CascadeType.ALL)
    private Set<Employee> employeeSet = new HashSet<>();

	public Project(Long projectId, String projectName, Set<Employee> employeeSet) {
		super();
		this.projectId = projectId;
		this.projectName = projectName;
		this.employeeSet = employeeSet;
	}
    
    
}
