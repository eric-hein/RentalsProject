package com.m3.training.rentals;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "STORE")
public class Store {

	@Id
	private int storeID;
	
	@Column(name = "MANAGER_STAFF_ID")
	private int managerStaffID;
	
	@Column(name = "ADDRESS_ID")
	private int addressID;
	
	@Column(name = "LAST_UPDATE")
	private Date lastUpdate;
	
	public int getStoreID() {
		return storeID;
	}
	public void setStoreID(int storeID) {
		this.storeID = storeID;
	}
	public int getManagerStaffID() {
		return managerStaffID;
	}
	public void setManagerStaffID(int managerStaffId) {
		this.managerStaffID = managerStaffId;
	}
	public int getAddressID() {
		return addressID;
	}
	
	public void setAddressID(int addressId) {
		this.addressID = addressId;
	}
	public Date getLastUpdate() {
		return lastUpdate;
	}
	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	
	public String toString() {
		return "ID: " + storeID + ", Manager Staff ID: " + managerStaffID + ", Address ID: " + addressID + ", Last Update " + lastUpdate.toString();
	}	
}
