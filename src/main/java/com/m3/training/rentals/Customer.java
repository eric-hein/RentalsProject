package com.m3.training.rentals;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "CUSTOMER")
public class Customer {
	@Id
	@Column(name = "CUSTOMER_ID")
	private int customerID;
	@Column(name = "FIRST_NAME")
	private String firstName;
	@Column(name = "LAST_NAME")
	private String lastName;
	@Column(name = "EMAIL")
	private String email;
	@Column(name = "ACTIVE")
	private int active;
	@Column(name = "CREATE_DATE")
	private Date createDate;
	@Column(name = "LAST_UPDATE")
	private Date lastUpdate;
	
	@ManyToOne
    @JoinColumn(name = "STORE_ID")
	private Store store;
	@ManyToOne
    @JoinColumn(name = "ADDRESS_ID")
	private Address address;
	@OneToMany
	private List<Rental> rentalsMade = new ArrayList<>();
	@OneToMany
	private List<Payment> paymentsMade = new ArrayList<>();
	
	public int getCustomerID() {
		return customerID;
	}
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getActive() {
		return active;
	}
	public void setActive(int active) {
		this.active = active;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getLastUpdate() {
		return lastUpdate;
	}
	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}	
	public Store getStore() {
		return store;
	}
	public Address getAddress() {
		return address;
	}
	public List<Rental> getRentalsMade() {
		return rentalsMade;
	}
	public List<Payment> getPaymentsMade() {
		return paymentsMade;
	}
	
	public String toString(){
		return getCustomerID() +" " + getFirstName() +" " + getLastName()
			+" " + getEmail() +" " + getActive() +" " + getCreateDate()+
			" " +getLastName();
	}
}
