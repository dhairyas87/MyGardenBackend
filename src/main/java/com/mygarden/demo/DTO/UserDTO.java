package com.mygarden.demo.DTO;

import java.util.HashSet;
import java.util.Set;

import com.mygarden.demo.api.RoleEnum;

public class UserDTO {
	
	private long id;
	
	private String name;
	
	private RoleEnum role;
	
	
    
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public RoleEnum getRole() {
		return role;
	}
	public void setRole(RoleEnum role) {
		this.role = role;
	}
	public UserDTO(String name, RoleEnum role) {
		super();
	
		this.name = name;
		this.role = role;
	}
	
	
	
}
