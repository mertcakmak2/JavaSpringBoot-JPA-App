package com.javaDemo.springBootOneToMany.Response;

import java.util.List;

import com.javaDemo.springBootOneToMany.Entities.IEntity;

public class EntitiesResponse <T extends IEntity> implements IEntityResponse {
	
	private List<T> Data;
	private String Status;
	private int StatusCode;
	
	public EntitiesResponse(List<T> Data, String status, int statusCode) {
		super();
		this.Data = Data;
		Status = status;
		StatusCode = statusCode;
	}
	public EntitiesResponse() {}
	public List<T> getData() {
		return Data;
	}
	public void setData(List<T> Data) {
		this.Data = Data;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public int getStatusCode() {
		return StatusCode;
	}
	public void setStatusCode(int statusCode) {
		StatusCode = statusCode;
	}

}
