package com.nagarro.minijava2.validation;

public class AplhabetsValidator implements Validator {
	@Override
	public boolean validate(String input) {

		return input.matches("[a-zA-Z]+");
	}

}
