package com.m3.training.rentals.dao;

import java.sql.SQLException;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.m3.training.rentals.Customer;

public class CustomerDAO extends DAO<Customer> {	

	private EntityManagerFactory factory;
	private EntityManager em;

	public CustomerDAO() throws SQLException {
		factory = Persistence.createEntityManagerFactory("rentalsJPA");
		em = factory.createEntityManager();
	}

	@Override
	public void create() {
		// TODO Auto-generated method stub

	}

	@Override
	public Optional<Customer> read(int id) {
		Customer customer = em.find(Customer.class, id);
		return Optional.ofNullable(customer);
	}

	public Optional<Customer> readByName(String fName, String lName) {
		TypedQuery<Customer> query = em.createQuery("SELECT c FROM Customer c WHERE c.firstName = ?0 AND c.lastName = ?1", Customer.class);
		query.setParameter(0, fName);
		query.setParameter(1, lName);
		Customer customer = query.getSingleResult();
		return Optional.ofNullable(customer);
	}

	public Optional<Customer> readByEmail(String email) {
		TypedQuery<Customer> query = em.createQuery("SELECT c FROM Customer c WHERE c.email = ?0", Customer.class);
		query.setParameter(0, email);
		Customer customer = query.getSingleResult();
		return Optional.ofNullable(customer);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub

	}
}
