package com.m3.training.rentals;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PAYMENT")
public class Payment {
	
	@Id
	private int paymentID;
	
	@Column(name = "CUSTOMER_ID")
	private int customerID;

	@Column(name = "STAFF_ID")
	private int staffID;

	@Column(name = "RENTAL_ID")
	private int rentalID;

	@Column(name = "AMOUNT")
	private int amount;

	@Column(name = "PAYMENT_DATE")
	private Date paymentDate;

	@Column(name = "LAST_UPDATE")
	private Date lastUpdate;

	public int getPaymentID() {
		return paymentID;
	}
	public void setPaymentIsD(int paymentIsD) {
		this.paymentID = paymentIsD;
	}
	public int getCustomerID() {
		return customerID;
	}
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	public int getStaffID() {
		return staffID;
	}
	public void setStaffID(int staffID) {
		this.staffID = staffID;
	}
	public int getRentalID() {
		return rentalID;
	}
	public void setRentalID(int rentalID) {
		this.rentalID = rentalID;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public Date getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}
	public Date getLastUpdate() {
		return lastUpdate;
	}
	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	
	public String toString() {
		return "ID: " + paymentID + ", Customer ID: " + customerID + ", Staff ID: " + staffID + ",\n"
				+ " Rental ID " + rentalID + ", Amount: " + amount + ", Payment Date: " + paymentDate + ", "
						+ "Last Update: " + lastUpdate;
	
	}	
}
