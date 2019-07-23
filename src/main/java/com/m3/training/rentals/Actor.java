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
@Table(name="Actor")
public class Actor {

	@Id
	@Column(name = "ACTOR_ID")
	private int actorID;
	@Column(name = "FIRST_NAME")
	private String firstName;
	@Column(name = "LAST_NAME")
	private String lastName;
	@Column(name = "LAST_UPDATE")
	private Date lastUpdate;
	
	@ManyToMany
	@JoinTable(name = "film_actor",
		joinColumns = @JoinColumn(name = "actor_id"),
		inverseJoinColumns = @JoinColumn(name = "film_id")
	)
	private Set<Film> filmList = new HashSet<>();
	
	public int getActorID() {
		return actorID;
	}
	public void setActorID(int actorID) {
		this.actorID = actorID;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getLastUpdate() {
		return lastUpdate;
	}
	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	
	public String getListOfFilms() {
		String retString = "";
		for (Film film : filmList) {
			retString += film.getTitle() + ". ";
		}
		return retString;
	}
}
