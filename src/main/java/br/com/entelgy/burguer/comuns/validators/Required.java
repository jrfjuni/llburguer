package br.com.entelgy.burguer.comuns.validators;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy=RequiredValidator.class)
@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface Required {
	
	String message() default "{message.err.field.required}";
	
	Class<?>[] groups() default {};
    
	Class<? extends Payload>[] payload() default {};	
}