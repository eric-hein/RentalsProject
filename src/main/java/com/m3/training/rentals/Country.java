package com.m3.training.rentals;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Country")
public class Country {

	@Id
	@Column(name = "COUNTRY_ID")
	private int countryID;
	@Column(name = "COUNTRY")
	private String country;
	@Column(name = "LAST_UPDATE")
	private Date lastUpdate;
	
	@OneToMany(mappedBy = "country")
	private List<City> cityList = new ArrayList<>();
	
	public int getCountryID() {
		return countryID;
	}
	public void setCountryID(int countryID) {
		this.countryID = countryID;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Date getLastUpdate() {
		return lastUpdate;
	}
	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}		
	public List<City> getCityList() {
		return cityList;
	}
	
	public String listOfCities() {
		String retString = "";
		for (City city : cityList) {
			retString += city.getCity() + " ";
		}
		return retString;
	}
}
