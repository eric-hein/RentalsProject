package com.m3.training.rentals;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "LANGUAGE")
public class Language {
	
	@Id
	private int languageID;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "LAST_UPDATE")
	private Date lastUpdate;
	
	@ManyToMany
    private Set<Customer> products = new HashSet<Customer>();
	
	public int getLanguageID() {
		return languageID;
	}
	public void setLanguageID(int languageID) {
		this.languageID = languageID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getLastUpdate() {
		return lastUpdate;
	}
	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	
	
	public String toString() {
		return "ID: " + languageID + ", Name: " + name + ", Last Updated: " + lastUpdate;
	}
	

}
