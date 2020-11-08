package com.javaDemo.springBootOneToMany.Response;

import com.javaDemo.springBootOneToMany.Entities.IEntity;

public class EntityResponse <T extends IEntity> implements IEntityResponse{
	private T Data;
	private String Status;
	private int StatusCode;
	
	public EntityResponse(T Data, String status, int statusCode) {
		super();
		this.Data = Data;
		Status = status;
		StatusCode = statusCode;
	}
	public EntityResponse() {}
	public T getData() {
		return Data;
	}
	public void setData(T Data) {
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
