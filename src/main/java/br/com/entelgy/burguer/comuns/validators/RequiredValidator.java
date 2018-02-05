package br.com.entelgy.burguer.comuns.validators;

import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.util.StringUtils;

public class RequiredValidator implements ConstraintValidator<Required, Object>{

	public void initialize(Required arg0) {}

	public boolean isValid(Object value, ConstraintValidatorContext ctx) {
		if (StringUtils.isEmpty(value) || (value instanceof List && ((List<?>)value).isEmpty())) {
			return false;
		}
		return true;
	}
}