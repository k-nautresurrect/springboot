package com.nagarro.minijava2.Model;


public class Gender {
	private String gender;

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Gender(String gender) {
		super();
		this.gender = gender;
	}

	public Gender() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Gender [gender=" + gender + "]";
	}
	
	

}
