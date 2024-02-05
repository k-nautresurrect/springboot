package com.nagarro.minijava2.Model;

public class Location {
	private Street street;

	public Street getStreet() {
		return street;
	}

	public void setStreet(Street street) {
		this.street = street;
	}

	public Location(Street street) {
		super();
		this.street = street;
	}

	public Location() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Location [street=" + street + "]";
	}
	
	

}
