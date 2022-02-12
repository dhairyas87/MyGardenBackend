package com.mygarden.demo.api;

public enum RoleEnum {
	ADMIN("ADMIN"), USER("USER");

	private String roleenum;

	private RoleEnum(String roleenum) {
		this.roleenum = roleenum;

	}

	@Override
	public String toString() {
		return roleenum;
	}
}
