package br.com.poc.api.validation;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;

public class UniqueRecordValidator implements ConstraintValidator<UniqueRecord, Serializable> {

	private ApplicationContext context;
	private UniqueRecord constraint;
	private Logger logger =  LoggerFactory.getLogger(UniqueRecordValidator.class);
	

	public UniqueRecordValidator(ApplicationContext context) {
		this.context = context;
	}

	public void initialize(UniqueRecord constraint) {
		this.constraint = constraint;
	}

	public boolean isValid(Serializable parameter, ConstraintValidatorContext context) {
		Method method = null;
		try {
			Object instance = this.context.getBean(this.constraint.repository());
			method = this.context.getBean(this.constraint.repository()).getClass().getMethod(this.constraint.method(), String.class);
			Object obj = method.invoke(instance, parameter);
			if(obj != null){
				return Boolean.TRUE;
			}
		} catch (BeansException | NoSuchMethodException | SecurityException e) {
			logger.error("Error get class instance from context {}", e);
			throw new RuntimeException("Error get class instance from context");
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			logger.error("Error invoking reflection method {}", e);
			throw new RuntimeException("Error invoking reflection method");
		} 
		
		return Boolean.FALSE;
	}
	
	

}