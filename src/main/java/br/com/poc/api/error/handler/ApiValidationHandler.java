package br.com.poc.api.error.handler;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.poc.api.error.ApiErrorHandler;
import br.com.poc.api.error.ApiSubErrorHandler;
import br.com.poc.api.error.ApiValidationErrorHandler;
import br.com.poc.api.util.http.HttpStatusCode;

@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class ApiValidationHandler extends BaseExcpetionHandler{
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public ResponseEntity<Object> handleValidationError(HttpServletRequest request, MethodArgumentNotValidException ex) throws IOException {
		
		BindingResult result = ex.getBindingResult();
		result.getTarget().getClass().getDeclaredFields();
		ApiErrorHandler apiError =  getApiError(HttpStatusCode .BAD_REQUEST, ex, request);
		apiError.setSubErrors(new ArrayList<ApiSubErrorHandler>());
		result.getAllErrors().forEach(error -> apiError.getSubErrors().add(processValidationError((FieldError) error, result.getTarget())));
		
		return buildResponseEntity(apiError);
	}

	
	private ApiValidationErrorHandler processValidationError(FieldError error, Object target) {
		
		ApiValidationErrorHandler validationError = new ApiValidationErrorHandler();
		
		validationError.setMessage(error.getDefaultMessage());
		validationError.setCodeValidation(error.getCode());
		validationError.setField(error.getField());
		validationError.setObject(error.getObjectName());
		validationError.setRejectedValue(error.getRejectedValue());
		
		
		return validationError;
		
	}
	
}