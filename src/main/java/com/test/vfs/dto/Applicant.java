package com.test.vfs.dto;

public class Applicant {

	private String name;
	private String passportNo;
	private String dob;
	private String issueDate;
	private String expireDate;
	private boolean saved;
	
	public Applicant() {};
	
	public Applicant(String name, String passportNo, String dob, String issueDate, String expireDate, boolean saved) {
		super();
		this.name = name;
		this.passportNo = passportNo;
		this.dob = dob;
		this.issueDate = issueDate;
		this.expireDate = expireDate;
		this.saved = saved;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassportNo() {
		return passportNo;
	}
	public void setPassportNo(String passportNo) {
		this.passportNo = passportNo;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getIssueDate() {
		return issueDate;
	}
	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
	}
	public String getExpireDate() {
		return expireDate;
	}
	public void setExpireDate(String expireDate) {
		this.expireDate = expireDate;
	}
	public boolean isSaved() {
		return saved;
	}
	public void setSaved(boolean saved) {
		this.saved = saved;
	}

	@Override
	public String toString() {
		return "Applicant [name=" + name + ", passportNo=" + passportNo + ", dob=" + dob + ", issueDate=" + issueDate
				+ ", expireDate=" + expireDate + ", saved=" + saved + "]";
	}
	
	
}
