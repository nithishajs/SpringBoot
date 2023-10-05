package com.m.model;


import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	private String name;
	private String college;

    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name = "Student_Subjects",
            joinColumns = @JoinColumn(name = "stId"),
            inverseJoinColumns = @JoinColumn(name = "sbId")
    )
    private Set<Subject> subjects = new HashSet<>();
}
