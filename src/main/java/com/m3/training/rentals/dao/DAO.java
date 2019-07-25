package com.m3.training.rentals.dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.m3.training.rentals.Customer;

public abstract class DAO<T> implements ICRUD<T> {
	 
	private EntityManager em;
	private EntityManagerFactory factory;
	
	public abstract Object read(int id);
	
	
} 