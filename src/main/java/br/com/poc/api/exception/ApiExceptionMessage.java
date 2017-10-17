package br.com.poc.api.exception;

import br.com.poc.api.util.http.HttpStatusCode;

public enum ApiExceptionMessage implements ApiErrorException {

	INVALID_TOKEN("invalid.token", "Invalid token request", HttpStatusCode.BUSINESS_ERROR);
	
	private String code;
	private String description;
	private int httpErrorCode;
	private String apiErrorCode;

	ApiExceptionMessage(String code, String description, int httpErrorCode){
		this.code = code;
		this.description = description;
		this.httpErrorCode = httpErrorCode;
	}
	
	ApiExceptionMessage(String code, String description, int httpErrorCode, String apiErrorCode){
		this.code = code;
		this.description = description;
		this.httpErrorCode = httpErrorCode;
		this.apiErrorCode = apiErrorCode;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getHttpErrorCode() {
		return httpErrorCode;
	}

	public void setHttpErrorCode(int httpErrorCode) {
		this.httpErrorCode = httpErrorCode;
	}

	public String getApiErrorCode() {
		return apiErrorCode;
	}

	public void setApiErrorCode(String apiErrorCode) {
		this.apiErrorCode = apiErrorCode;
	}
	
	
	
}
