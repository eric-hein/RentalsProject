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
	
	@Column(name = "LAST_UPDATE")
	private Date lastUpdate;
	
	@ManyToOne
    @JoinColumn(name = "ADDRESS_ID")
	private Address address;
	
	@OneToMany(mappedBy = "store")
	private List<Customer> customerList = new ArrayList<>();
	
	@OneToMany(mappedBy = "store")
	private List<Inventory> inventoryList = new ArrayList<>();
	
	// 1 Store has multiple employees
	@OneToMany(mappedBy = "store")
	private List<Staff> staffList = new ArrayList<>();
	
	// 1 employee can work at multiple stores
	@ManyToOne
	@JoinColumn(name = "manager_staff_id")
	private Staff staff;
	
	public int getStoreID() {
		return storeID;
	}
	public void setStoreID(int storeID) {
		this.storeID = storeID;
	}
	public Date getLastUpdate() {
		return lastUpdate;
	}
	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	
	public Address getAddress() {
		return address;
	}
	public List<Customer> getCustomerList() {
		return customerList;
	}
	public List<Inventory> getInventoryList() {
		return inventoryList;
	}
	public List<Staff> getStaffList() {
		return staffList;
	}
	public Staff getStaff() {
		return staff;
	}
	public String toString() {
		return "ID: " + storeID + ", Address ID: " + address.getAddressID() + ", Last Update " + lastUpdate.toString();
	}	
}
