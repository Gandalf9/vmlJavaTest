package com.vml.test;

import java.util.Date;

public class CustomerBean {

	private String customerNo;
	private String firstName;
	private String lastName;
	private Date birthDate;
	private String mailingAddress;
	private Boolean married;
	private Integer numberOfKids;
	private String favouriteQuote;
	private String email;
	private Long loyaltyPoints;
	
	
	public String getCustomerNo() {
		return customerNo;
	}
	public void setCustomerNo(String customerNo) {
		this.customerNo = customerNo;
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
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public String getMailingAddress() {
		return mailingAddress;
	}
	public void setMailingAddress(String mailingAddress) {
		this.mailingAddress = mailingAddress;
	}
	public Boolean getMarried() {
		return married;
	}
	public void setMarried(Boolean married) {
		this.married = married;
	}
	public Integer getNumberOfKids() {
		return numberOfKids;
	}
	public void setNumberOfKids(Integer numberOfKids) {
		this.numberOfKids = numberOfKids;
	}
	public String getFavouriteQuote() {
		return favouriteQuote;
	}
	public void setFavouriteQuote(String favouriteQuote) {
		this.favouriteQuote = favouriteQuote;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getLoyaltyPoints() {
		return loyaltyPoints;
	}
	public void setLoyaltyPoints(Long loyaltyPoints) {
		this.loyaltyPoints = loyaltyPoints;
	}
	@Override
	public String toString() {
		return "CustomerBean [customerNo=" + customerNo + ", firstName="
				+ firstName + ", lastName=" + lastName + ", birthDate="
				+ birthDate + ", mailingAddress=" + mailingAddress
				+ ", married=" + married + ", numberOfKids=" + numberOfKids
				+ ", favouriteQuote=" + favouriteQuote + ", email=" + email
				+ ", loyaltyPoints=" + loyaltyPoints + "]";
	}
}
