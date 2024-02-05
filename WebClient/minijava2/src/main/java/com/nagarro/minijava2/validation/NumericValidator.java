package com.nagarro.minijava2.validation;

public class NumericValidator implements Validator {
	@Override
	public boolean validate(String input) {
		try {

			Integer.parseInt(input);
			return true;
		} catch (NumberFormatException e) {

			return false;
		}
	}
}