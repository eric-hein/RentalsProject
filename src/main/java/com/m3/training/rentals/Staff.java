package com.m3.training.rentals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "STAFF")
public class Staff {

	@Id
	@Column(name = "STAFF_ID")
	private int staffId;	
	@Column(name = "FIRST_NAME")
	private String firstName;	
	@Column(name = "LAST_NAME")
	private String lastName;	
	@Column(name = "ADDRESS_ID")
	private int addressID;		
	@Column(name = "EMAIL")
	private String email;	
	@Column(name = "ACTIVE")
	private int active;	
	@Column(name = "USERNAME")
	private String username;
	@Column(name = "PASSWORD")
	private String password;
	@Column(name = "LAST_UPDATE")
	private Date lastUpdate;
	
	@ManyToOne
    @JoinColumn(name = "STORE_ID")
	private Store store;
	@OneToMany(mappedBy = "staff")
	private List<Store> storeList = new ArrayList<>();
	@OneToMany(mappedBy = "staff")
	private List<Payment> paymentList = new ArrayList<>();
	@OneToMany(mappedBy = "staff")
	private List<Rental> rentalList = new ArrayList<>();
	
	public int getStaffId() {
		return staffId;
	}
	public void setStaffId(int staffId) {
		this.staffId = staffId;
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
	public int getAddressID() {
		return addressID;
	}
	public void setAddressID(int addressID) {
		this.addressID = addressID;
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
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	public List<Store> getStoreList() {
		return storeList;
	}
	public List<Payment> getPaymentList() {
		return paymentList;
	}
	public List<Rental> getRentalList() {
		return rentalList;
	}
	public String toString() {
		return "ID: " + staffId + ", Name: " + firstName + " " + lastName + ", Address ID: " + addressID + ",\n E-Mail: "
				+ email + ", Active: " + active + ", Username: " + username + ", Password:\n " +
				password + ", Last Updated: " + lastUpdate;
	}	
	
}
