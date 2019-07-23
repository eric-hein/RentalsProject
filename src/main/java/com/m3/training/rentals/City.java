package com.m3.training.rentals;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "City")
public class City {

	@Id
	@Column(name = "city_ID")
	private int cityID;
	@Column(name = "city")
	private String city;
	@Column(name = "LAST_UPDATE")
	private Date lastUpdate;
	
	@ManyToOne
	@JoinColumn(name = "country_ID")
	private Country country;
	
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
	public Date getLastUpdate() {
		return lastUpdate;
	}
	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	
	public String toString() {
		return cityID + ": " + getCity() + ", " + country.getCountryID() + ": " + country.getCountry() + ". " + getLastUpdate();
	}
}
