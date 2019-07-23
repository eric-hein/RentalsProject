package com.m3.training.rentals;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "RENTAL")
public class Rental {

	@Id
	@Column(name = "RENTAL_ID")
	private int rentalID;

	@Column(name = "RENTAL_DATE")
	private Date rentalDate;

	@Column(name = "INVENTORY_ID")
	private int inventoryID;

	@Column(name = "CUSTOMER_ID")
	private int customerID;

	@Column(name = "RETURN_DATE")
	private Date returnDate;

	@Column(name = "LAST_UPDATE")
	private Date lastUpdate;

	@ManyToOne
	@JoinColumn(name = "STAFF_ID")	
	private Staff rentalRenter;

	public int getRentalID() {
		return rentalID;
	}
	public void setRentalID(int rentalID) {
		this.rentalID = rentalID;
	}
	public Date getRentalDate() {
		return rentalDate;
	}
	public void setRentalDate(Date rentalDate) {
		this.rentalDate = rentalDate;
	}
	public int getInventoryID() {
		return inventoryID;
	}
	public void setInventoryID(int inventoryID) {
		this.inventoryID = inventoryID;
	}
	public int getCustomerID() {
		return customerID;
	}
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	public Date getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	public Date getLastUpdate() {
		return lastUpdate;
	}
	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public void setRenter(Staff renter) {
		this.rentalRenter = renter;
		if (!renter.getRentals().contains(this)) {
			renter.getRentals().add(this);
		}
	}

	public Staff getRenter() {
		return rentalRenter;
	}


	public String toString() {
		return "ID: " + rentalID + ", Inventory ID: " + inventoryID + ", Customer ID: " + customerID + ",\n"
				+ "Return Date: " + returnDate + ", Last Update: " + lastUpdate;
	}


}
