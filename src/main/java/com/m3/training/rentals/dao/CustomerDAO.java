package com.m3.training.rentals.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.m3.training.rentals.Customer;
import com.m3.training.rentals.utility.ParseTools;

public class CustomerDAO extends DAO<Customer> {
	
	private final String WILDCARD_EXP = "%";

	private EntityManagerFactory factory;
	private EntityManager em;

	public CustomerDAO() throws SQLException {
		factory = Persistence.createEntityManagerFactory("rentalsJPA");
		em = factory.createEntityManager();
	}

	@Override
	public Optional<Customer> read(int id) {
		Customer customer = em.find(Customer.class, id);
		return Optional.ofNullable(customer);
	}

	public Optional<List<Customer>> readByPartialInfo(String fNameInput, String lNameInput, String emailInput) {
		
		String fName = fNameInput;
		String lName = lNameInput;
		String email = ParseTools.caseEmail(emailInput);
		
		if(!isValidExpression(fName)) {
			fName = WILDCARD_EXP;
		}
		if(!isValidExpression(lName)) {
			lName = WILDCARD_EXP;
		}
		if(!isValidExpression(email)) {
			email = WILDCARD_EXP;
		}		

		TypedQuery<Customer> query = em.createQuery("SELECT c FROM Customer c WHERE c.firstName LIKE ?0 AND c.lastName LIKE ?1 AND c.email LIKE ?2", Customer.class);
		
		query.setParameter(0, fName.toUpperCase());
		query.setParameter(1, lName.toUpperCase());
		query.setParameter(2, email.toUpperCase());
		
		List<Customer> customerList = query.getResultList();
		
		return Optional.ofNullable(customerList);
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

