package br.com.poc.api.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ ElementType.TYPE, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CustomValidator.class)
@Documented
/**
 * Annotation to allow custom validation against model classes
 */
public @interface Validate {

  /**
   * Validation message
   */
  String message();

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};

  /**
   * Validation method name
   */
  String method() default "";
}