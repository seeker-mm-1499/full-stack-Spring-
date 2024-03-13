package com.jdc.mappings.model.dto;

import java.util.Objects;

public class Result {

	private Status status;
	private String message;
	
	public Result() {
		
	}
	
	public Result(Status status, String message) {
		super();
		this.status = status;
		this.message = message;
	}

	public enum Status{
		Success, Warning, Error
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public int hashCode() {
		return Objects.hash(message, status);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Result other = (Result) obj;
		return Objects.equals(message, other.message) && status == other.status;
	}
	
}
