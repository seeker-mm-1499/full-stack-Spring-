package com.jdc.form.mvc.validator;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = PhoneConstraint.class)
@Retention(RUNTIME)
@Target(FIELD)
public @interface Phone {
	String message();
	Class<?>[] groups() default {};
	Class<? extends Payload>[]  payload() default {};
	
	String pattern() default "09\\d-\\d{4}-\\d{4}";
}
