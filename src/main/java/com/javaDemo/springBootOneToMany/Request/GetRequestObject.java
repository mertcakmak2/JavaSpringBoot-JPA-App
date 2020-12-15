package com.javaDemo.springBootOneToMany.Request;

public class GetRequestObject {
	
	//Tablo alanlarını alır..
	private String fieldName;
	
	//Alan değelerini alır.. 
	private String fieldValue;

	//Operasyon alır (like,in, between, equal
	private String operation;

	public GetRequestObject(String fieldName, String fieldValue, String operation) {
		super();
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
		this.operation = operation;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getFieldValue() {
		return fieldValue;
	}

	public void setFieldValue(String fieldValue) {
		this.fieldValue = fieldValue;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}
	
	
}
