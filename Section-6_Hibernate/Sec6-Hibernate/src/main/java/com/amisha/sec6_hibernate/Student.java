package com.amisha.sec6_hibernate;

import jakarta.persistence.Entity;	// JPA-previously Java Persistence API, now Jakarta Persistence API
import jakarta.persistence.Id;


@Entity		// this class needs to be represented in the DB and hibernate will take care of it
public class Student {
	
	@Id		// making rollNo field a primary key for the table, every table should have at least one primary key
	private int rollNo;
	private String sName;
	private int sAge;
	
	// getters and setters
	public int getRollNo() {
		return rollNo;
	}
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	public String getsName() {
		return sName;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
	public int getsAge() {
		return sAge;
	}
	public void setsAge(int sAge) {
		this.sAge = sAge;
	}
	@Override
	public String toString() {
		return "Student [rollNo=" + rollNo + ", sName=" + sName + ", sAge=" + sAge + "]";
	}
	
}
