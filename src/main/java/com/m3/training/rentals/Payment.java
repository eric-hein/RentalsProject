package com.m3.training.rentals;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PAYMENT")
public class Payment {

	@Id
	@Column(name = "PAYMENT_ID")
	private int paymentID;
	@Column(name = "AMOUNT")
	private int amount;
	@Column(name = "PAYMENT_DATE")
	private Date paymentDate;
	@Column(name = "LAST_UPDATE")
	private Date lastUpdate;

	@ManyToOne
	@JoinColumn(name = "STAFF_ID")	
	private Staff staff;
	
	@ManyToOne
	@JoinColumn(name = "RENTAL_ID")
	private Rental rental;
	
	@ManyToOne
	@JoinColumn(name = "CUSTOMER_ID")
	private Customer customer;

	public int getPaymentID() {
		return paymentID;
	}
	
	public void setPaymentID(int paymentIsD) {
		this.paymentID = paymentIsD;
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
	public Staff getStaff() {
		return staff;
	}

	public Rental getRental() {
		return rental;
	}

	public Customer getCustomer() {
		return customer;
	}

	public String toString() {
		return "\nID: " + paymentID + ", Amount: " + 
				amount + ", Payment Date: " + paymentDate + ", " + "Last Update: " + lastUpdate;

	}	
}