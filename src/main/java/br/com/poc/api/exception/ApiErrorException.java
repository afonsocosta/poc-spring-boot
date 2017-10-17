package br.com.poc.api.exception;

public interface ApiErrorException {

	String getCode();
	
	String getDescription();
	
	int getHttpErrorCode();
	
}
