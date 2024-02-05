package com.nagarro.minijava2.validation;

public class ValidatorFactory {
	public static Validator getValidator(String input) {
		if (input.matches("\\d+")) {
			return new NumericValidator();
		} else if (input.matches("[a-zA-Z]+")) {
			return new AplhabetsValidator();
		} else {
			throw new IllegalArgumentException("Unsupported parameter type");
		}
	}

}
