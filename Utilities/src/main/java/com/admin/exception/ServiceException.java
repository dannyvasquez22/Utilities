package com.admin.exception;

import com.admin.util.ErrorMessage;

public class ServiceException extends Exception {

	private static final long serialVersionUID = 1L;
	private Integer httpStatus;
	private String message;
	private Integer code;
	private String developerMessage;
	
	public ServiceException(Integer httpStatus, String message, Integer code, String developerMessage) {
		this.httpStatus = httpStatus;
		this.message = message;
		this.code = code;
		this.developerMessage = developerMessage;
	}

	public ServiceException(Integer httpStatus, String message, Integer code) {
		super();
		this.httpStatus = httpStatus;
		this.message = message;
		this.code = code;
	}
	
	public ServiceException(ErrorMessage errorMessage) {
		this.httpStatus = errorMessage.getHttpStatus();
		this.message = errorMessage.getMessage();
		this.code = errorMessage.getCode();
		this.developerMessage = errorMessage.getDeveloperMessage();
	}

	public Integer getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(Integer httpStatus) {
		this.httpStatus = httpStatus;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getDeveloperMessage() {
		return developerMessage;
	}

	public void setDeveloperMessage(String developerMessage) {
		this.developerMessage = developerMessage;
	}
		
}
