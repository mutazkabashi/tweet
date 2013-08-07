package com.mutaz.business.repository.exception;

import java.util.ResourceBundle;

import com.mutaz.business.exception.TweetException;

/**
 * Base Exception for all Service Exception
 * 
 * @author mutaz hussein kabashi
 */
public class RepositroyException extends TweetException {

	public RepositroyException(String str, Throwable nested) {
		super(str, nested);
	}

	public RepositroyException(Throwable nested) {
		super(nested);
	}

	public RepositroyException(String errorMessageCode/*
														 * , String
														 * errorMessageFile
														 */) {
		super(errorMessageCode/* , errorMessageFile */);
		setErrorMessageCode(errorMessageCode);
		setErrorMessageFile(getErrorMessageFile().getBundle("repositoryErrorMessages"));

	}

	public RepositroyException() {
		super();
	}

}