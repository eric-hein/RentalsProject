package com.m3.training.rentals;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "INVENTORY")
public class Inventory {
	@Id
	@Column(name = "INVENTORY_ID")
	private int inventoryID;
	@Column(name = "LAST_UPDATE")
	private Date lastUpdate;
	
	@ManyToOne
    @JoinColumn(name = "FILM_ID")
	private Film film;
	
	@ManyToOne
    @JoinColumn(name = "STORE_ID")
	private Store store;
	
	public int getInventoryID() {
		return inventoryID;
	}
	public void setInventoryID(int inventoryID) {
		this.inventoryID = inventoryID;
	}
	public Date getLastUpdate() {
		return lastUpdate;
	}
	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	
	
}
