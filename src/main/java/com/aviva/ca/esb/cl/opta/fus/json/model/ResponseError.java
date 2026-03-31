package com.aviva.ca.esb.cl.opta.fus.json.model;

import javax.xml.bind.annotation.XmlType;

@XmlType(name = "ResponseError")
public class ResponseError extends Exception {
	
	private static final long serialVersionUID = 1L;
	private String code;
	private String message;
	
	public ResponseError(String code, String message) {
		super();
		this.code = code;
		this.message = message;
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}