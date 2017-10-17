package br.com.poc.api.validation;

import java.lang.reflect.Method;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.ReflectionUtils;

public class CustomValidator implements ConstraintValidator<Validate, Object> {

  private static Log log = LogFactory.getLog(CustomValidator.class);
  private String validator;


  @Override
  public void initialize(Validate constraintAnnotation) {
    validator = constraintAnnotation.method();
  }

  @Override
  public boolean isValid(Object bo, ConstraintValidatorContext constraintContext) {
    try {
      return isValidForMethod(bo);
    } catch (Exception e) {
      /* Error durante la ejecución de la condición o del validador */
      log.error("Error validating "+bo, e);
      return false;
    }
  }


  private boolean isValidForMethod(Object bo) throws Exception {
    Method validatorMethod =  ReflectionUtils.findMethod(bo.getClass(), validator, new Class[] {});
    if (validatorMethod != null) {
      /* Validator call */
      Boolean valid = (Boolean) validatorMethod.invoke(bo);
      return valid != null && valid;
    } else {
      /* Method not found */
      log.error("Validator method not found.");
      return false;
    }
  }

}