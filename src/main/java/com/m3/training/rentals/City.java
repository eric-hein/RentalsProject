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
@Table(name = "City")
public class City {

	@Id
	@Column(name = "city_ID")
	private int cityID;
	@Column(name = "city")
	private String city;
	@Column(name = "country_id")
	private int countryID;
	@Column(name = "LAST_UPDATE")
	private Date lastUpdate;
	
	@ManyToOne
	@JoinColumn(name = "country_ID")
	private Country country;
	
	@OneToMany(mappedBy = "city")
	private List<Address> addressList = new ArrayList<>();
	
	public int getCityID() {
		return cityID;
	}
	public void setCityID(int cityID) {
		this.cityID = cityID;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getCountryID() {
		return countryID;
	}
	public void setCountryID(int countryID) {
		this.countryID = countryID;
	}
	public Date getLastUpdate() {
		return lastUpdate;
	}
	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}	
	public Country getCountry() {
		return country;
	}
	public List<Address> getAddressList() {
		return addressList;
	}
	
	public String toString() {
		return cityID + ": " + getCity() + ", " + getCountryID() + ": " + country.getCountry() + ". " + getLastUpdate();
	}
	
	public String listOfAddresses() {
		String retString = "";
		for (Address address : addressList) {
			retString += address.getAddress() + "\n";
		}
		return retString;
	}
}
