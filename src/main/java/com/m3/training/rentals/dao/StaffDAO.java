package com.m3.training.rentals.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import javax.persistence.TypedQuery;

import com.m3.training.rentals.Customer;
import com.m3.training.rentals.Rental;
import com.m3.training.rentals.Staff;

public class StaffDAO extends DAO<Staff> {

	public StaffDAO() throws SQLException {
		super();
	}

	@Override
	public Optional<Staff> read(int id) {
		Staff staff = em.find(Staff.class, id);
		return Optional.ofNullable(staff);
	}
	
	public Optional<List<Rental>> getStaff() {

		TypedQuery<Rental> query = em.createQuery("SELECT s FROM Staff s ORDER BY s.name", Rental.class);

		List<Rental> rentalsList = query.getResultList();
		return Optional.ofNullable(rentalsList);
	}

}
