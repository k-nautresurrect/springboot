package com.nagarro.minijava2.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer userid;
	private String gender;
	private Integer age;
	private String firstName;
	private String lastName;
	private String nationality;
	private String varificationStatus;
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public String getVarificationStatus() {
		return varificationStatus;
	}
	public void setVarificationStatus(String varificationStatus) {
		this.varificationStatus = varificationStatus;
	}
	@Override
	public String toString() {
		return "UserEntity [userid=" + userid + ", gender=" + gender + ", age=" + age + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", nationality=" + nationality + ", varificationStatus="
				+ varificationStatus + "]";
	}
	public User(Integer userid, String gender, Integer age, String firstName, String lastName, String nationality,
			String varificationStatus) {
		super();
		this.userid = userid;
		this.gender = gender;
		this.age = age;
		this.firstName = firstName;
		this.lastName = lastName;
		this.nationality = nationality;
		this.varificationStatus = varificationStatus;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	


}
