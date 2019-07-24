package com.m3.training.rentals;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Category")
public class Category {
	
	@Id
	@Column(name = "CATEGORY_ID")
	private int categoryID;
	@Column(name = "NAME")
	private String name;
	@Column(name = "LAST_UPDATE")
	private Date lastUpdate;
	
	@ManyToMany
	@JoinTable(name = "film_category",
			joinColumns = @JoinColumn(name = "category_id"),
			inverseJoinColumns = @JoinColumn(name = "film_id")
	)
	private Set<Film> filmList = new HashSet<>();	

	public int getCategoryID() {
		return categoryID;
	}
	public void setCategoryID(int categoryID) {
		this.categoryID = categoryID;
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
	public Set<Film> getFilmList() {
		return filmList;
	}
}
