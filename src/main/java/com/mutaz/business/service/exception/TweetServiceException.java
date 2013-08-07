package com.mutaz.business.service.exception;

import java.util.ResourceBundle;

import com.mutaz.business.exception.TweetException;

/**
 * Base Exception for all Service Exception
 * 
 * @author mutaz hussein kabashi
 */
public class TweetServiceException extends TweetException {

	public TweetServiceException(String str, Throwable nested) {
		super(str, nested);
	}

	public TweetServiceException(Throwable nested) {
		super(nested);
	}

	public TweetServiceException(String errorMessageCode/*
														 * , String
														 * errorMessageFile
														 */) {
		super(errorMessageCode/* , errorMessageFile */);
		setErrorMessageCode(errorMessageCode);
		setErrorMessageFile(getErrorMessageFile().getBundle("serviceErrorMessages"));

	}

	public TweetServiceException() {
		super();
	}

}