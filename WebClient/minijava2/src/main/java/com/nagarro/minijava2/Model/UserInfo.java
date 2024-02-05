package com.nagarro.minijava2.Model;

import java.util.List;

public class UserInfo {
	private List<Results> results;

	public List<Results> getResults() {
		return results;
	}

	public UserInfo(List<Results> results) {
		super();
		this.results = results;
	}

	public void setResults(List<Results> results) {
		this.results = results;
	}

	public UserInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "UserDetailResponse [results=" + results + "]";
	}

}
