package com.nagarro.minijava2.Model;



public class DOB {
	private String date;
	private Integer age;
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "DOB [date=" + date + ", age=" + age + "]";
	}
	public DOB(String date, Integer age) {
		super();
		this.date = date;
		this.age = age;
	}
	public DOB() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
