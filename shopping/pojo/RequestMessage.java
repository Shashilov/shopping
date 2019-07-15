package com.shopping.pojo;

public class RequestMessage {
private boolean success;
private String message;
public boolean isSuccess() {
	return success;
}
public void setSuccess(boolean success) {
	this.success = success;
}
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
public RequestMessage() {
	super();
}
public RequestMessage(boolean success, String message) {
	super();
	this.success = success;
	this.message = message;
}
}
