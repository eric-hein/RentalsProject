package com.m3.training.rentals;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class DAO implements AutoCloseable{

	private final String PROPERTIES_PATH = "src/main/resources/queries.properties";
	private static EntityManagerFactory factory;
	private EntityManager em;

	Connection dbConnection;
	
	public static void main(String[] args) {
		System.out.println("Hi");
	}
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
		factory = Persistence.createEntityManagerFactory("cityJPADemo");
		em = factory.createEntityManager();
	}
	@Override
	public void close() throws Exception {
		em.close();
		
	}

}
