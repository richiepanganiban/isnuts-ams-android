package com.ams.isnuts.model;

public class CustomServiceApplication {
	private int customServiceId;
	private String title;
	private ServiceApplication serviceApplication;

	public int getCustomServiceId() {
		return customServiceId;
	}

	public void setCustomServiceId(int customServiceId) {
		this.customServiceId = customServiceId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public ServiceApplication getServiceApplication() {
		return serviceApplication;
	}

	public void setServiceApplication(ServiceApplication serviceApplication) {
		this.serviceApplication = serviceApplication;
	}

	@Override
	public String toString() {
		return getTitle();
	}
}
