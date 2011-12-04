package com.ams.isnuts.model;

public class CustomServiceApplication {
	private int customServiceId;
	private ServiceApplication serviceApplication;

	public int getCustomServiceId() {
		return customServiceId;
	}

	public void setCustomServiceId(int customServiceId) {
		this.customServiceId = customServiceId;
	}

	public ServiceApplication getServiceApplication() {
		return serviceApplication;
	}

	public void setServiceApplication(ServiceApplication serviceApplication) {
		this.serviceApplication = serviceApplication;
	}

	public void setTitle(String title) {
		serviceApplication.setTitle(title);
	}

	public String getTitle() {
		return serviceApplication.getTitle();
	}

	@Override
	public String toString() {
		return getTitle();
	}

}
