package com.ams.isnuts.model;

import com.google.gson.annotations.SerializedName;

public class InputParams {
	@SerializedName("itemType")
	private String itemType;

	@SerializedName("literalValue")
	private String literalValue;
	
	private String promptMessage;

	public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	public String getLiteralValue() {
		return literalValue;
	}

	public void setLiteralValue(String literalValue) {
		this.literalValue = literalValue;
	}

	public String getPromptMessage() {
		return promptMessage;
	}

	public void setPromptMessage(String promptMessage) {
		this.promptMessage = promptMessage;
	}

}
