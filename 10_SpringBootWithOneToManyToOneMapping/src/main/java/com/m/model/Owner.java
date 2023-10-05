package com.m.model;

import java.util.*;

import jakarta.annotation.Nullable;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Owner {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    
	    private int id;
	    private String name;

	    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
	    private List<Vehicle> vehicles = new ArrayList<>();

}
