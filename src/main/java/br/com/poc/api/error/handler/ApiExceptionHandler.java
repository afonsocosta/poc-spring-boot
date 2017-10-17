package br.com.poc.api.error.handler;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.poc.api.error.ApiErrorHandler;
import br.com.poc.api.exception.ApiException;
import br.com.poc.api.util.http.HttpStatusCode;
import javassist.bytecode.stackmap.TypeData.ClassName;


@ControllerAdvice
public class ApiExceptionHandler extends BaseExcpetionHandler {
	
	
	private  static final Logger LOGGER =  LoggerFactory.getLogger(ClassName.class.getName());
	

	@ExceptionHandler(Exception.class)
	protected ResponseEntity<Object> handleEntityNotFound(Exception e, HttpServletRequest request) {
		ApiErrorHandler apiError =  getApiError(HttpStatusCode.BAD_REQUEST, e, request);
		LOGGER.warn("handleEntityNotFound" , e);
		return buildResponseEntity(apiError);
	}
	
	
	@ExceptionHandler({IllegalArgumentException.class, NullPointerException.class, RuntimeException.class})
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	protected ResponseEntity<Object> handleInternalServerError(Exception e, HttpServletRequest request) throws IOException {
	    ApiErrorHandler apiError =  getApiError(HttpStatusCode.INTERNAL_SERVER_ERROR, e, request);
	    LOGGER.warn("handleInternalServerError" , e);
		return buildResponseEntity(apiError);
	}
	
	@ExceptionHandler({ApiException.class})
	protected ResponseEntity<Object> handlePocApiException(HttpServletResponse response, ApiException e, HttpServletRequest request) throws IOException {
		ApiErrorHandler apiError =  getApiError(e.getStatus(), e, request);
		LOGGER.warn("handlePocApiException" , e);
		return buildResponseEntity(apiError);
	
	}
	

}