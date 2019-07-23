package com.m3.training.rentals;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Driver {

	private static EntityManagerFactory factory;
	
	public static void main (String[] args) {
		
		System.out.println("what it do baybeee");
		factory = Persistence.createEntityManagerFactory("rentalsJPA");
		EntityManager em = factory.createEntityManager();
		
		em.getTransaction().begin();
		City city = em.find(City.class, 3);
		System.out.println(city);
		Country country = em.find(Country.class, 3);
		System.out.println(country.listOfCities());
	}
}
