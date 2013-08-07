package com.mutaz.business.exception;

import java.util.ResourceBundle;

/**
 * Base Exception for all exception that could be thrown by the system
 * Each Exception /Error has a code , which is a No that the system
 * used to identify the error message that will be shown to a user 
 * 
 *   errorMessageCode : error code that has been thrown by the system
 * 
 *   errorMessageFile : The name of the file that contains the error  description
 * 
 * @author mutaz.kabbashi
 * 
 */
public class TweetException extends RuntimeException {

	/*
	
	 */
	private String errorMessageCode;
	private ResourceBundle errorMessageFile;

	public TweetException(String errorMessageCode/* ,String errorMessageFile */) {
		super(errorMessageCode);
		// getMessage();

	}

	public TweetException(Throwable cause) {

		super(cause);
	}

	public TweetException(String message, Throwable cause) {
		super(message, cause);
	}

	public TweetException() {
	}

	@Override
	/**
	 * We use this method to override the getMessage() method of the throwable
	 * class so that we can modify the default mechanism and display the error
	 * message as follow errorCode -- errorDescription
	 */
	public String getMessage() {

		return super.getMessage() + " -- "
				+ getErrorMessageFile().getString(errorMessageCode);
	}

	public String getDetailMessage() {

		return super.getMessage();
	}

	public String getErrorMessageCode() {
		return errorMessageCode;
	}

	public void setErrorMessageCode(String errorMessageCode) {
		this.errorMessageCode = errorMessageCode;
	}

	public ResourceBundle getErrorMessageFile() {
		return errorMessageFile;
	}

	public void setErrorMessageFile(ResourceBundle errorMessageFile) {
		this.errorMessageFile = errorMessageFile;
	}
}