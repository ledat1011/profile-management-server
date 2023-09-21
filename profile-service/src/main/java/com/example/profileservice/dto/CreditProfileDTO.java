package com.example.profileservice.dto;

import java.math.BigDecimal;
import java.sql.Date;

public class CreditProfileDTO {
	private Integer profileID;
	private String fullName;
	private Date dateOfBirth;
	private String identityNumber;
	private String permanentAddress;
	private String phoneNumber;
	private String email;
	private BigDecimal monthlyIncome;
	private String incomeSource;
	private BigDecimal totalAssets;
	private BigDecimal totalLiabilities;
	private Integer currentCreditCardsOrLoans;
	private String companyName;
	private String occupation;
	private String jobPosition;
	private Integer jobDurationInMonths;
	private String guarantorName;
	private String guarantorRelationship;
	private String guarantorPhone;
	private String guarantorEmail;

	public Integer getProfileID() {
		return profileID;
	}

	public void setProfileID(Integer profileID) {
		this.profileID = profileID;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getIdentityNumber() {
		return identityNumber;
	}

	public void setIdentityNumber(String identityNumber) {
		this.identityNumber = identityNumber;
	}

	public String getPermanentAddress() {
		return permanentAddress;
	}

	public void setPermanentAddress(String permanentAddress) {
		this.permanentAddress = permanentAddress;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public BigDecimal getMonthlyIncome() {
		return monthlyIncome;
	}

	public void setMonthlyIncome(BigDecimal monthlyIncome) {
		this.monthlyIncome = monthlyIncome;
	}

	public String getIncomeSource() {
		return incomeSource;
	}

	public void setIncomeSource(String incomeSource) {
		this.incomeSource = incomeSource;
	}

	public BigDecimal getTotalAssets() {
		return totalAssets;
	}

	public void setTotalAssets(BigDecimal totalAssets) {
		this.totalAssets = totalAssets;
	}

	public BigDecimal getTotalLiabilities() {
		return totalLiabilities;
	}

	public void setTotalLiabilities(BigDecimal totalLiabilities) {
		this.totalLiabilities = totalLiabilities;
	}

	public Integer getCurrentCreditCardsOrLoans() {
		return currentCreditCardsOrLoans;
	}

	public void setCurrentCreditCardsOrLoans(Integer currentCreditCardsOrLoans) {
		this.currentCreditCardsOrLoans = currentCreditCardsOrLoans;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getJobPosition() {
		return jobPosition;
	}

	public void setJobPosition(String jobPosition) {
		this.jobPosition = jobPosition;
	}

	public Integer getJobDurationInMonths() {
		return jobDurationInMonths;
	}

	public void setJobDurationInMonths(Integer jobDurationInMonths) {
		this.jobDurationInMonths = jobDurationInMonths;
	}

	public String getGuarantorName() {
		return guarantorName;
	}

	public void setGuarantorName(String guarantorName) {
		this.guarantorName = guarantorName;
	}

	public String getGuarantorRelationship() {
		return guarantorRelationship;
	}

	public void setGuarantorRelationship(String guarantorRelationship) {
		this.guarantorRelationship = guarantorRelationship;
	}

	public String getGuarantorPhone() {
		return guarantorPhone;
	}

	public void setGuarantorPhone(String guarantorPhone) {
		this.guarantorPhone = guarantorPhone;
	}

	public String getGuarantorEmail() {
		return guarantorEmail;
	}

	public void setGuarantorEmail(String guarantorEmail) {
		this.guarantorEmail = guarantorEmail;
	}

}
