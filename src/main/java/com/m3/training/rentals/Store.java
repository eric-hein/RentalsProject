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
@Table(name = "STORE")
public class Store {

	@Id
	@Column(name = "STORE_ID")
	private int storeID;
	
	@Column(name = "MANAGER_STAFF_ID")
	private int managerStaffID;
	
	@Column(name = "LAST_UPDATE")
	private Date lastUpdate;
	
	@ManyToOne
    @JoinColumn(name = "ADDRESS_ID")
	private Address address;
	
	@OneToMany(mappedBy = "store")
	private List<Customer> customerList = new ArrayList<>();
	
	@OneToMany(mappedBy = "store")
	private List<Inventory> inventoryList = new ArrayList<>();
	
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
	public Date getLastUpdate() {
		return lastUpdate;
	}
	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	
	public String toString() {
		return "ID: " + storeID + ", Manager Staff ID: " + managerStaffID + ", Address ID: " + address.getAddressID() + ", Last Update " + lastUpdate.toString();
	}	
}
