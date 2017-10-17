package br.com.poc.api.exception;

import java.util.ArrayList;
import java.util.Arrays;

public class PocApiException extends ApiException {

	private static final long serialVersionUID = 2178460015775834638L;

	public PocApiException(ApiExceptionMessage exception, String... params){
		super(exception.getHttpErrorCode(), exception.getCode(), exception.getDescription());
		if(params != null){
			this.setParams(new ArrayList<String>(Arrays.asList(params)));
		}
	}
	
	public PocApiException(ApiExceptionMessage exception, Throwable cause, String... params){
		super(exception.getHttpErrorCode(), exception.getCode(), exception.getDescription(), cause);
		if(params != null){
			this.setParams(new ArrayList<String>(Arrays.asList(params)));
		}
	}
	
}
