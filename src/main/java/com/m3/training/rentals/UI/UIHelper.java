package com.m3.training.rentals.UI;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.m3.training.rentals.dao.CustomerDAO;
import com.m3.training.rentals.errorlogging.ErrorLogger;

public class UIHelper {
	
	private Scanner scanner;
	
	public UIHelper() {
		scanner = new Scanner(System.in);
	}
	
	public String readInput() {
		String input = scanner.nextLine(); 
		input=input.toLowerCase();
		input=input.trim();
		return input;
	}
	
	public IUserInterface initStates() throws SQLException{
		Map<String, IUserInterface> states = new HashMap<>();
		ErrorLogger errorLogger= new ErrorLogger();
		states.put("home", new HomeUI(states, this, errorLogger));
		states.put("customer", new CustomerUI(states, this, errorLogger, new CustomerDAO()));
		states.put("film", new FilmUI(states, this, errorLogger));
		states.put("rental", new RentalUI(states, this, errorLogger));
		
		return states.get("home");
	}
	
}
