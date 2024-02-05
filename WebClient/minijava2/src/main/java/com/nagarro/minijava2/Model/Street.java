package com.nagarro.minijava2.Model;

public class Street {
	private String number;
	private String name;

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Street(String number, String name) {
		super();
		this.number = number;
		this.name = name;
	}

	public Street() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Street [number=" + number + ", name=" + name + "]";
	}

}
