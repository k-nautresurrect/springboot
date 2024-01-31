package com.nagarro.trainning.CustomerMangement.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String accountnumber;//use camel case
	private String ifsccode;//use routingNumber
	private String accounttype;//not use class accounttype
	private String branch;//no use

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "account")
	private Set<AccountType> accountTypes = new HashSet<>();

	@ManyToOne
	private Customer customer;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAccountnumber() {
		return accountnumber;
	}

	public void setAccountnumber(String accountnumber) {
		this.accountnumber = accountnumber;
	}

	public String getIfsccode() {
		return ifsccode;
	}

	public void setIfsccode(String ifsccode) {
		this.ifsccode = ifsccode;
	}

	public String getAccounttype() {
		return accounttype;
	}

	public void setAccounttype(String accounttype) {
		this.accounttype = accounttype;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public Set<AccountType> getAccountTypes() {
		return accountTypes;
	}

	public void setAccountTypes(Set<AccountType> accountTypes) {
		this.accountTypes = accountTypes;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", accountnumber=" + accountnumber + ", ifsccode=" + ifsccode + ", accounttype="
				+ accounttype + ", branch=" + branch + "]";
	}

}
