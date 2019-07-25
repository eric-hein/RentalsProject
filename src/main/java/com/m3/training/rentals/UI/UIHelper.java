package com.m3.training.rentals.UI;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

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
	
	public IUserInterface initStates(){
		Map<String, IUserInterface> states = new HashMap<>();
		states.put("home", new HomeUI(states, this));
		states.put("customer", new CustomerUI(states, this));
		states.put("film", new FilmUI(states, this));
		states.put("rental", new RentalUI(states, this));
		
		return states.get("home");
	}
	
}
