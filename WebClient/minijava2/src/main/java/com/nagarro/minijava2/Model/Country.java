package com.nagarro.minijava2.Model;



public class Country {
	
	private String country_id;
	public String getCountry_id() {
		return country_id;
	}

	public void setCountry_id(String country_id) {
		this.country_id = country_id;
	}

	public Country(String country_id) {
		super();
		this.country_id = country_id;
	}

	public Country() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Country [country_id=" + country_id + "]";
	}
	
	

}
