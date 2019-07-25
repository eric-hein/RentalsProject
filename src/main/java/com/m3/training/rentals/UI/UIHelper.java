package com.m3.training.rentals.UI;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.m3.training.rentals.dao.CustomerDAO;
import com.m3.training.rentals.dao.FilmDAO;
import com.m3.training.rentals.dao.InventoryDAO;
import com.m3.training.rentals.dao.RentalDAO;
import com.m3.training.rentals.dao.StaffDAO;
import com.m3.training.rentals.errorlogging.ErrorLogger;

public class UIHelper {
	
	private Scanner scanner;
	ErrorLogger errorLogger;
	
	public UIHelper(ErrorLogger errorLogger) {
		scanner = new Scanner(System.in);
		this.errorLogger = errorLogger;
	}
	
	public String readInput() {
		String input = scanner.nextLine(); 
		input=input.toLowerCase();
		input=input.trim();
		return input;
	}
	
	public IUserInterface initStates() throws SQLException{
		Map<String, IUserInterface> states = new HashMap<>();
		states.put("home", new HomeUI(states, this));
		states.put("customer", new CustomerUI(states, this, new CustomerDAO()));
		states.put("film", new FilmUI(states, this, new FilmDAO()));
		states.put("rental", new RentalUI(states, this, new RentalDAO()));
		states.put("staff", new StaffUI(states, this, new StaffDAO()));
		states.put("inventory", new InventoryUI(states, this, new InventoryDAO()));
		
		return states.get("home");
	}
	
}
