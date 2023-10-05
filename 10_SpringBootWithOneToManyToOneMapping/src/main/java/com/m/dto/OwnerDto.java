package com.m.dto;

import java.util.List;


public class OwnerDto {
    private int id;
    private String name;
    private List<VehicleDto> vehicles;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<VehicleDto> getVehicles() {
		return vehicles;
	}
	public void setVehicles(List<VehicleDto> vehicles) {
		this.vehicles = vehicles;
	}
	public OwnerDto(int id, String name, List<VehicleDto> vehicles) {
		super();
		this.id = id;
		this.name = name;
		this.vehicles = vehicles;
	}
	public OwnerDto() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
}
