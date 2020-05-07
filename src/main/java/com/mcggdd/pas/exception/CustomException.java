package com.zifeng.pas.exception;

public class CustomException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4791500670620160846L;

	private int code;

	public CustomException() {
		super();
	}

	public CustomException(int code, String message) {
		super(message);
		this.setCode(code);
	}

	public int getCode() {
		return this.code;
	}

	public void setCode(int code) {
		this.code = code;
	}
}
