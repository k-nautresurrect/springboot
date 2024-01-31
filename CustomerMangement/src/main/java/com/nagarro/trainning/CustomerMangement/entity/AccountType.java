package com.nagarro.trainning.CustomerMangement.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class AccountType {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String typename;

	@ManyToOne
	private Account account;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public String getTypename() {
		return typename;
	}

	public void setTypename(String typename) {
		this.typename = typename;
	}

}
