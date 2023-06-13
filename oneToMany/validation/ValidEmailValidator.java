package com.netsmartz.oneToMany.validation;

import java.util.regex.Pattern;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidEmailValidator implements ConstraintValidator<ValidEmail, String> {

	private static Pattern EMAIL_PATTERN = Pattern.compile("[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");

	@Override
	public boolean isValid(String email, ConstraintValidatorContext context) {
		if (email == null) {
//			return EMAIL_PATTERN.matcher(email).matches() && email.length() >= 10 && email.length() <= 20;
			return false;
		}
		return EMAIL_PATTERN.matcher(email).matches();
	}

}
