package com.m3.training.rentals.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.m3.training.rentals.Rental;

public class RentalDAO extends DAO<Rental> {

	private EntityManagerFactory factory;
	private EntityManager em;

	public RentalDAO() throws SQLException {
		factory = Persistence.createEntityManagerFactory("rentalsJPA");
		em = factory.createEntityManager();
	}

	@Override
	public Optional<Rental> read(int id) {
		Rental rental = em.find(Rental.class, id);
		return Optional.ofNullable(rental);
	}

	public Optional<List<Rental>> getActiveRentals() {

		TypedQuery<Rental> query = em.createQuery("SELECT r FROM Rental r WHERE r.returnDate IS NULL", Rental.class);

		List<Rental> rentalsList = query.getResultList();
		return Optional.ofNullable(rentalsList);
	}
}
