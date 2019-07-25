package com.m3.training.rentals.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.m3.training.rentals.Inventory;
import com.m3.training.rentals.Rental;

public class InventoryDAO extends DAO {

	private EntityManagerFactory factory;
	private EntityManager em;

	public InventoryDAO() throws SQLException {
		factory = Persistence.createEntityManagerFactory("rentalsJPA");
		em = factory.createEntityManager();
	}

	public List<Inventory> read() {
		TypedQuery<Inventory> query = em.createQuery("SELECT i FROM Inventory i", Inventory.class);
	    List<Inventory> inventoryList = query.getResultList();
	    return inventoryList;
	}
	
	@Override
	public Object read(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Map<String, Integer> getRentalActivity() {
		
		List<Inventory> inventoryList = this.read();
		Map<String, Integer> totalActivity = new HashMap<>();
		
		for(Inventory inventory : inventoryList) {
			String title = inventory.getFilm().getTitle();
			int timesRented = inventory.getRentalList().size();
			
			if(totalActivity.containsKey(title)) {
				int currentValue = totalActivity.get(title);
				totalActivity.put(title, timesRented + currentValue);
			}
			else {
				totalActivity.put(title, timesRented);
			}
		}
        
		return totalActivity;
		
		
	
	}

}
