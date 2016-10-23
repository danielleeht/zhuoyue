package com.zhuoyue.crawler.jd.model;

public class JdBookProperty {

	private String propertyName;

	private String propertyValue;

	public String getPropertyName() {
		return propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	public String getPropertyValue() {
		return propertyValue;
	}

	public void setPropertyValue(String propertyValue) {
		this.propertyValue = propertyValue;
	}

	@Override
	public String toString() {
		return "JDBookProperty [propertyName=" + propertyName + ", propertyValue=" + propertyValue + "]";
	}


}
