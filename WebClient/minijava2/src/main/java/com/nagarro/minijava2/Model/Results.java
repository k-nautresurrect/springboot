package com.nagarro.minijava2.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Results {

	private String gender;
	private Name name;
	private Location location;
	private String nat;
	private DOB dob;

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public String getNat() {
		return nat;
	}

	public void setNat(String nat) {
		this.nat = nat;
	}

	public DOB getDob() {
		return dob;
	}

	public void setDob(DOB dob) {
		this.dob = dob;
	}

	public Results(String gender, Name name, Location location, String nat, DOB dob) {
		super();
		this.gender = gender;
		this.name = name;
		this.location = location;
		this.nat = nat;
		this.dob = dob;
	}

	public Results() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Results [gender=" + gender + ", name=" + name + ", location=" + location + ", nat=" + nat + ", dob="
				+ dob + "]";
	}

}
