package br.com.poc.api.error.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;

import br.com.poc.api.error.ApiErrorHandler;



public class BaseExcpetionHandler {

	protected ResponseEntity<Object> buildResponseEntity(ApiErrorHandler apiError) {
		return ResponseEntity.status(apiError.getStatus()).body(apiError);
	}
	
	protected ApiErrorHandler getApiError(int httpStatus, Exception ex, HttpServletRequest request ){
		ApiErrorHandler apiError = new ApiErrorHandler(httpStatus, ex.getMessage(), ex);
		apiError.setPath(request.getRequestURI());
		//apiError.setError(httpStatus.getReasonPhrase());
		apiError.setException(ex.getClass().getName());
		return apiError;
	}
	
}
