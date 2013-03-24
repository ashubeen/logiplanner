package com.tan.logistics.admin.response;

import org.codehaus.jackson.annotate.JsonProperty;

public class Option {
	
	@JsonProperty("DisplayText")
	String displayText;
	
	@JsonProperty("Value")
	String value;

	public String getDisplayText() {
		return displayText;
	}

	public void setDisplayText(String displayText) {
		this.displayText = displayText;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	public Option(String value, String displayText){
		this.value = value;
		this.displayText = displayText;
	}
	
}
