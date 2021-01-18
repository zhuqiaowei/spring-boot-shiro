package com.zqw.entity;

public class JsonEntity {
	private String state;
	private String message;
	private String data;
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "JsonEntity [state=" + state + ", message=" + message + ", data=" + data + "]";
	}
	
	
}
