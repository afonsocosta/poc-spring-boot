package br.com.poc.api.exception;

import java.util.List;

public interface IApiException {
	
	String getErrorCode();
	
	int getStatus();
	
	List<String> getParams();
	
	String getMessage();
	
	void addParam(String params);

}
