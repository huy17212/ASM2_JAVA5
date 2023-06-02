package com.HTT.company.enumeration;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public enum Coupon {
	
	Counpon1500("Counpon for 1500$", "1500$", 30),
	Counpon1000("Counpon for 1000$", "1000$", 19),
	Counpon500("Counpon for 500$", "500$", 9),
	Counpon300("Counpon for 300$", "300$", 4);
	
	private String counponName;
	
	private String counponAccepted;
	
	private Integer counponDiscound;

	public String getCounponName() {
		return counponName;
	}

	public String getCounponAccepted() {
		return counponAccepted;
	}

	public void setCounponName(String counponName) {
		this.counponName = counponName;
	}

	public void setCounponAccepted(String counponAccepted) {
		this.counponAccepted = counponAccepted;
	}

	public Integer getCounponDiscound() {
		return counponDiscound;
	}

	public void setCounponDiscound(Integer counponDiscound) {
		this.counponDiscound = counponDiscound;
	}

}
