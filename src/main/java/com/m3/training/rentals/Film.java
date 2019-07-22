package com.m3.training.rentals;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "FIRM")
public class Film {
	@Id
	@Column(name = "FILM_ID")
	private int filmID;
	@Column(name = "TITLE")
	private String title;
	@Column(name = "DESCRIPTION")
	private String description;
	@Column(name = "RELEASE_YEAR")
	private int releaseYear;
	@Column(name = "LANGUAGE_ID")
	private int languageID;
	@Column(name = "ORIGINAL_LANGUAGE_ID")
	private int originalLanguageID;
	@Column(name = "RENTAL_DURATION")
	private int rentalDuration;
	@Column(name = "RENTAL_RATE")
	private double rentalRate;
	@Column(name = "LENGTH")
	private int length;
	@Column(name = "REPLACEMENT_COST")
	private double replacementCost;
	@Column(name = "RATING")
	private String rating;
	@Column(name = "SPECIAL_FEATURES")
	private String specialFeatures;
	@Column(name = "LAST_UPDATE")
	private Date lastUpdate;
	
	public int getFilmID() {
		return filmID;
	}
	public void setFilmID(int filmID) {
		this.filmID = filmID;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getReleaseYear() {
		return releaseYear;
	}
	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}
	public int getLanguageID() {
		return languageID;
	}
	public void setLanguageID(int languageID) {
		this.languageID = languageID;
	}
	public int getOriginalLanguageID() {
		return originalLanguageID;
	}
	public void setOriginalLanguageID(int originalLanguageID) {
		this.originalLanguageID = originalLanguageID;
	}
	public int getRentalDuration() {
		return rentalDuration;
	}
	public void setRentalDuration(int rentalDuration) {
		this.rentalDuration = rentalDuration;
	}
	public double getRentalRate() {
		return rentalRate;
	}
	public void setRentalRate(double rentalRate) {
		this.rentalRate = rentalRate;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public double getReplacementCost() {
		return replacementCost;
	}
	public void setReplacementCost(double replacementCost) {
		this.replacementCost = replacementCost;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public String getSpecialFeatures() {
		return specialFeatures;
	}
	public void setSpecialFeatures(String specialFeatures) {
		this.specialFeatures = specialFeatures;
	}
	public Date getLastUpdate() {
		return lastUpdate;
	}
	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	
	public String toString() {
		return getFilmID() + " " +getTitle() +" " +getReleaseYear() +" " + getLanguageID()+" " +getOriginalLanguageID() +" " +getRentalDuration() +" " +
				getRentalRate()+" " +
				getLength()+" " +getReplacementCost() +" " + getRating()+" " + getSpecialFeatures()+" " + getLastUpdate();
	}
}
