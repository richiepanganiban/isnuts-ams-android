package com.ams.isnuts.model;

import java.util.LinkedList;
import java.util.List;

import com.google.gson.annotations.SerializedName;

public class ServiceApplication {

	@SerializedName("id")
	private long id;

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
	private LinkedList<InputParams> keywordItems;

	@SerializedName("categories")
	private List<Category> categories;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public LinkedList<InputParams> getKeywordItems() {
		return keywordItems;
	}

	public void setKeywordItems(LinkedList<InputParams> keywordItems) {
		this.keywordItems = keywordItems;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (activePromo ? 1231 : 1237);
		result = prime * result + (appendMobileToServiceNumber ? 1231 : 1237);
		result = prime * result + ((categories == null) ? 0 : categories.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((keywordItems == null) ? 0 : keywordItems.hashCode());
		result = prime * result + ((serviceNumber == null) ? 0 : serviceNumber.hashCode());
		result = prime * result + ((serviceType == null) ? 0 : serviceType.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ServiceApplication other = (ServiceApplication) obj;
		if (activePromo != other.activePromo)
			return false;
		if (appendMobileToServiceNumber != other.appendMobileToServiceNumber)
			return false;
		if (categories == null) {
			if (other.categories != null)
				return false;
		} else if (!categories.equals(other.categories))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id != other.id)
			return false;
		if (keywordItems == null) {
			if (other.keywordItems != null)
				return false;
		} else if (!keywordItems.equals(other.keywordItems))
			return false;
		if (serviceNumber == null) {
			if (other.serviceNumber != null)
				return false;
		} else if (!serviceNumber.equals(other.serviceNumber))
			return false;
		if (serviceType == null) {
			if (other.serviceType != null)
				return false;
		} else if (!serviceType.equals(other.serviceType))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
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
