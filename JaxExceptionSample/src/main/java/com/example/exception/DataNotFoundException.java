package com.example.exception;

public class DataNotFoundException extends RuntimeException {
	public DataNotFoundException(String e) {
		super(e);
	}
}
