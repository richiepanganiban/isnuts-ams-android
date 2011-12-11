package com.ams.isnuts.model;

import com.google.gson.annotations.SerializedName;

public class InputParams implements Comparable<InputParams> {
	@SerializedName("itemType")
	private String itemType;

	@SerializedName("literalValue")
	private String literalValue;

	private String promptMessage;

	@SerializedName("label")
	private String label;
	
	private int order;

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

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
	
	public String getPromptMessage() {
		return promptMessage;
	}

	public void setPromptMessage(String promptMessage) {
		this.promptMessage = promptMessage;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public int compareTo(InputParams inputParam) {
		return inputParam.getOrder() - this.getOrder();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((itemType == null) ? 0 : itemType.hashCode());
		result = prime * result
				+ ((literalValue == null) ? 0 : literalValue.hashCode());
		result = prime * result + order;
		result = prime * result
				+ ((promptMessage == null) ? 0 : promptMessage.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		InputParams other = (InputParams) obj;
		if (itemType == null) {
			if (other.itemType != null) {
				return false;
			}
		} else if (!itemType.equals(other.itemType)) {
			return false;
		}
		if (label == null) {
			if (other.label != null) {
				return false;
			}
		} else if (!label.equals(other.label)) {
			return false;
		}
		if (literalValue == null) {
			if (other.literalValue != null) {
				return false;
			}
		} else if (!literalValue.equals(other.literalValue)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("InputParams [itemType=");
		builder.append(itemType);
		builder.append(", literalValue=");
		builder.append(literalValue);
		builder.append(", label=");
		builder.append(label);
		builder.append("]");
		return builder.toString();
	}
	
}
