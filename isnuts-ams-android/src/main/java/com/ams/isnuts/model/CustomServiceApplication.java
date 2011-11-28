package com.ams.isnuts.model;

public class CustomServiceApplication extends ServiceApplication {
	private int customServiceId;
	private String name;

	public int getCustomServiceId() {
		return customServiceId;
	}

	public void setCustomServiceId(int customServiceId) {
		this.customServiceId = customServiceId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
