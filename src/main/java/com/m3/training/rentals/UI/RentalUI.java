package com.m3.training.rentals.UI;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;

import com.m3.training.rentals.Customer;
import com.m3.training.rentals.Rental;
import com.m3.training.rentals.dao.CustomerDAO;
import com.m3.training.rentals.dao.RentalDAO;
import com.m3.training.rentals.errorlogging.ErrorLogger;
import com.m3.training.rentals.utility.ParseTools;

public class RentalUI implements IUserInterface {

	private Map<String, IUserInterface> states;
	private UIHelper helper;
	private IUserInterface nextState = this;
	private ErrorLogger errorLogger;
	RentalDAO dao;
	
	public RentalUI(Map<String, IUserInterface> states, UIHelper helper, ErrorLogger errorLogger, RentalDAO dao) {
		this.states= states;
		this.helper = helper;
		this.errorLogger = errorLogger;
		this.dao = dao;
	}
	
	@Override
	public IUserInterface getNextState() {
		return nextState;
	}

	
	private void printResult (Optional<List<Rental>> result) {
		List<Rental> resultList = result.get();
		for (Rental rental: resultList) {
			System.out.println(" Renter's name: " + rental.getCustomer().getFirstName() + " " + rental.getCustomer().getLastName() + " Title: " + rental.getInventory().getFilm().getTitle() + " Date Rented " + rental.getRentalDate() );
		}
	}
	
	private void printResultBest (List<Object[]> resultList) {
		for (Object[] object: resultList) {
			System.out.println("Title: " + object[0] + " Times Rented: " + object[1] + " Rental Price: " + object[2]+ " Gross Profit: " + object[3] );
		}
	}
	
	@Override
	public void execute() throws IllegalStateException {
		System.out.println("This is the rental search. What would you like to look at?");
		System.out.println("Please use the proper command: (outstanding, bestselling)");
		String input = helper.readInput();
		switch(input) {
			case "home":
				this.changeNextState("home");
				break;
			case "back":
				this.changeNextState("home");
				break;
			case "outstanding":
				Optional<List<Rental>> result = dao.getActiveRentals();
				printResult(result);
				break;
			case "bestselling":
				List<Object[]> result2 = dao.getRentalActivity();
				printResultBest(result2);
				break;
			case "exit":
				this.setNextState(null);
				break;
			default:
				this.setNextState(this);
				System.out.println("That was not a valid option. Please try again.");
		}
	}
	
	private void changeNextState(String nextStateChoice) {
		if (states.containsKey(nextStateChoice)) {
			this.setNextState(states.get(nextStateChoice));
		}else {
			throw new IllegalStateException("State: " + nextStateChoice + " is not an available option within given states");
		}
	}

	private Map<String, IUserInterface> getStates() {
		return states;
	}

	private void setStates(Map<String, IUserInterface> states) {
		this.states = states;
	}

	private UIHelper getHelper() {
		return helper;
	}

	private void setHelper(UIHelper helper) {
		this.helper = helper;
	}

	private void setNextState(IUserInterface nextState) {
		this.nextState = nextState;
	}
	
	
}
