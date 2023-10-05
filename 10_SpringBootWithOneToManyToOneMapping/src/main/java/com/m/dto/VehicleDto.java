package com.m.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class VehicleDto {
    private int vid;
    private String vname;
    private String vtype;
	public VehicleDto(int vid, String vname, String vtype) {
		super();
		this.vid = vid;
		this.vname = vname;
		this.vtype = vtype;
	}
	public VehicleDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getVid() {
		return vid;
	}
	public void setVid(int vid) {
		this.vid = vid;
	}
	public String getVname() {
		return vname;
	}
	public void setVname(String vname) {
		this.vname = vname;
	}
	public String getVtype() {
		return vtype;
	}
	public void setVtype(String vtype) {
		this.vtype = vtype;
	}
    
    
    
}