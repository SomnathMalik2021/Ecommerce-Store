package com.example.demo.error;

@SuppressWarnings("serial")
public class ElementNotFoundException extends Exception{
	
	private String message;
	
	public ElementNotFoundException(String message) {
		super();
		this.message = message;
	}

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return this.message;
	}

	
}
