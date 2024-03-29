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
@Table(name = "Address")
public class Address {

	@Id
	@Column(name = "ADDRESS_ID")
	private int addressID;
	@Column(name = "ADDRESS")
	private String address;
	@Column(name = "ADDRESS2")
	private String address2;
	@Column(name = "DISTRICT")
	private String district;
	@Column(name = "CITY_ID")
	private int cityID;
	@Column(name = "POSTAL_CODE")
	private	String postalCode;
	@Column(name = "PHONE")
	private String phone;
	@Column(name = "LAST_UPDATE")
	private Date lastUpdate;
	
	@OneToMany(mappedBy = "address")
	private List<Customer> customerList = new ArrayList<>();
	
	@OneToMany(mappedBy = "address")
	private List<Store> storeList = new ArrayList<>();
	
	@ManyToOne
	@JoinColumn(name = "city_ID")
	private City city;
	
	public int getAddressID() {
		return addressID;
	}
	public void setAddressID(int addressID) {
		this.addressID = addressID;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public int getCityID() {
		return cityID;
	}
	public void setCityID(int cityID) {
		this.cityID = cityID;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Date getLastUpdate() {
		return lastUpdate;
	}
	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	public List<Customer> getCustomerList() {
		return customerList;
	}
	public List<Store> getStoreList() {
		return storeList;
	}
	public City getCity() {
		return city;
	}
	
	public String toString() {
		return getAddressID() + ": " + getAddress() + ", " + getCityID() + ": " + city.getCity()
			+ ", " + getPostalCode() + ". Phone: " + getPhone() + ". " + getLastUpdate();
	}
}
