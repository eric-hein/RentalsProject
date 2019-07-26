package com.m3.training.rentals.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import javax.persistence.TypedQuery;

import com.m3.training.rentals.Customer;
import com.m3.training.rentals.Film;

public class FilmDAO extends DAO<Film> {

	private final String WILDCARD_EXP = "%";

	public FilmDAO() throws SQLException {
		super();
	}

	@Override
	public Optional<Film> read(int id) {
		Film film = em.find(Film.class, id);
		return Optional.ofNullable(film);
	}
	
	public Optional<List<Film>> readByPartialInfo(String titleInput, String descInput) {
		
		String title = titleInput;
		String desc = descInput;

		if(!isValidExpression(titleInput)) {
			title = WILDCARD_EXP;
		}
		else {
			title = WILDCARD_EXP + title + WILDCARD_EXP;
		}
		
		if(!isValidExpression(descInput)) {
			desc = WILDCARD_EXP;
		}
		else {
			desc = WILDCARD_EXP + desc + WILDCARD_EXP;
		}
		
		TypedQuery<Film> query = em.createQuery("SELECT f FROM Film f WHERE f.title LIKE ?0 AND f.description LIKE ?1", Film.class);
		
		query.setParameter(0, title);
		query.setParameter(1, desc);
		
		List<Film> filmList = query.getResultList();
		
		return Optional.ofNullable(filmList);
	}
	
	private boolean isValidExpression(String str) {
		if(str == null) {
			return false;
		}
		else if(str.equals("")) {
			return false;
		}
		return true;
	}


}
