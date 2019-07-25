package com.m3.training.rentals.dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.m3.training.rentals.Customer;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class DAO<T> implements ICRUD<T>, AutoCloseable {

	private final String PROPERTIES_PATH = "src/main/resources/queries.properties";
	private static EntityManagerFactory factory;
	protected EntityManager em;

	Connection dbConnection;

	public void loadProperties() {
		File file = new File(PROPERTIES_PATH);
		Properties properties = new Properties();
		try {
			FileInputStream fis = new FileInputStream(file);
			properties.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public DAO() throws SQLException {
		loadProperties();
		factory = Persistence.createEntityManagerFactory("rentalsJPA");
		em = factory.createEntityManager();
	}
	
	@Override
	public void close() throws Exception {
		em.close();

	}


} 