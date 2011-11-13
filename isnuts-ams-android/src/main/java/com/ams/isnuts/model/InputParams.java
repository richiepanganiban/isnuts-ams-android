package com.ams.isnuts.model;

import com.google.gson.annotations.SerializedName;

public class InputParams {
	@SerializedName("itemType")
	private String itemType;

	@SerializedName("literalValue")
	private String literalValue;

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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("InputParams [itemType=");
		builder.append(itemType);
		builder.append(", literalValue=");
		builder.append(literalValue);
		builder.append("]");
		return builder.toString();
	}

}
