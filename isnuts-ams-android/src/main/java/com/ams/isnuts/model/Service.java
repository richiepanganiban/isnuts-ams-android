package com.ams.isnuts.model;

import java.util.List;
import java.util.Map;

public class Service {

	private boolean activePromo;
	private String serviceType;
	private String title;
	private String description;
	private String serviceNumber;
	private boolean appendMobileToServiceNumber;
	private Map<String, String> keywordItems;
	private List<String> categories;
	
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
	public Map<String, String> getKeywordItems() {
		return keywordItems;
	}
	public void setKeywordItems(Map<String, String> keywordItems) {
		this.keywordItems = keywordItems;
	}
	public List<String> getCategories() {
		return categories;
	}
	public void setCategories(List<String> categories) {
		this.categories = categories;
	}
	
	
}
