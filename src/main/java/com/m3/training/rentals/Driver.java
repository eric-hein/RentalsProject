package com.m3.training.rentals;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.m3.training.rentals.dao.CustomerDAO;
import com.m3.training.rentals.dao.FilmDAO;
import com.m3.training.rentals.dao.InventoryDAO;
import com.m3.training.rentals.dao.RentalDAO;

public class Driver {


	public static void main (String[] args) {

		System.out.println("what it do baybeee");
		try {
			CustomerDAO customerDAO = new CustomerDAO();
			RentalDAO rentalDAO = new RentalDAO();
			InventoryDAO inventoryDAO = new InventoryDAO();
			FilmDAO filmDAO = new FilmDAO();
			System.out.println(filmDAO.readByPartialInfo("BEETHOVEN", ""));
		} catch (SQLException e) {
			String msg = "Could not instantiate DAO Objects!";
			System.err.println(msg + " " + e.getMessage());
		}

	}
}
