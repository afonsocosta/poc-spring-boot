package br.com.poc.api.exception;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ApiException extends Exception implements IApiException{
	
	
	private static final long serialVersionUID = 7354721957032036954L;

	protected int status;
	
	protected String errorCode;
	
	private List<String> params = new ArrayList<String>();

	
	public ApiException(){
		super("unknown error");
		init();
	}
	
	public ApiException(String message){
		super(message);
		init();
	}
	
	public ApiException(Throwable cause){
		super(cause);
		init();
	}
	
	public ApiException(int status, String errorCode, String message, Throwable cause){
		super(message, cause);
		this.status = status;
		this.errorCode = errorCode;
	}
	
	public ApiException(int status, String errorCode, String message){
		super(message);
		this.status = status;
		this.errorCode = errorCode;
	}
	
	public ApiException(String errorCode, String message){
		super(message);
		this.status = 200;
		this.errorCode = errorCode;
	}
	
	public ApiException(String message, ApiErrorException apiError, String... params){
		this(apiError.getHttpErrorCode(), apiError.getCode(), apiError.getDescription() + ":" + message);
		if(params != null){
			this.params = new ArrayList<String>(Arrays.asList(params));
		}
	}
	
	public ApiException(ApiErrorException apiError, Number id){
		this(apiError.getHttpErrorCode(), apiError.getCode(), apiError.getDescription());
		addParam(id.toString());
	}
	
	
	public void init(){
		errorCode = "internal_server_error";
		status = 500;
	}
	
	@Override
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	@Override
	public List<String> getParams() {
		return params;
	}

	public void setParams(List<String> params) {
		this.params = params;
	}

	
	@Override
	public void addParam(String param) {
		if(params == null){
			params = new ArrayList<String>();
		}
		
		this.params.add(param);
	}

	

}
