package com.nagarro.minijava2.Model;

import java.util.List;

public class Nationality {
	private String name;
	private List<Country> country;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Country> getCountry() {
		return country;
	}

	public void setCountry(List<Country> country) {
		this.country = country;
	}

	public Nationality(String name, List<Country> country) {
		super();
		this.name = name;
		this.country = country;
	}

	public Nationality() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Nationality [name=" + name + ", country=" + country + "]";
	}

}
