package com.ams.isnuts.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class ServiceApplication {
	
	@SerializedName("serviceApplicationId")
	private long serviceApplicationId;
	
	@SerializedName("activePromo")
	private boolean activePromo;

	@SerializedName("serviceType")
	private String serviceType;

	@SerializedName("title")
	private String title;

	@SerializedName("description")
	private String description;

	@SerializedName("serviceNumber")
	private String serviceNumber;

	@SerializedName("appendMobileToServiceNumber")
	private boolean appendMobileToServiceNumber;

	@SerializedName("keywordItems")
	private List<InputParams> keywordItems;

	@SerializedName("categories")
	private List<Category> categories;
	
	public long getServiceApplicationId() {
		return serviceApplicationId;
	}

	public void setServiceApplicationId(long serviceApplicationId) {
		this.serviceApplicationId = serviceApplicationId;
	}

	public boolean isActivePromo() {
		return activePromo;
	}

	public void setActivePromo(boolean activePromo) {
		this.activePromo = activePromo;
	}

	public String getServiceType() {
		return serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getServiceNumber() {
		return serviceNumber;
	}

	public void setServiceNumber(String serviceNumber) {
		this.serviceNumber = serviceNumber;
	}

	public boolean isAppendMobileToServiceNumber() {
		return appendMobileToServiceNumber;
	}

	public void setAppendMobileToServiceNumber(boolean appendMobileToServiceNumber) {
		this.appendMobileToServiceNumber = appendMobileToServiceNumber;
	}

	public List<InputParams> getKeywordItems() {
		return keywordItems;
	}

	public void setKeywordItems(List<InputParams> keywordItems) {
		this.keywordItems = keywordItems;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
	

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ServiceApplication [activePromo=");
		builder.append(activePromo);
		builder.append(", serviceType=");
		builder.append(serviceType);
		builder.append(", title=");
		builder.append(title);
		builder.append(", description=");
		builder.append(description);
		builder.append(", serviceNumber=");
		builder.append(serviceNumber);
		builder.append(", appendMobileToServiceNumber=");
		builder.append(appendMobileToServiceNumber);
		builder.append(", keywordItems=");
		builder.append(keywordItems);
		builder.append(", categories=");
		builder.append(categories);
		builder.append("]");
		return builder.toString();
	}

}
