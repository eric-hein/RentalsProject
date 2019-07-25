package com.m3.training.rentals.UI;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;

import com.m3.training.rentals.Customer;
import com.m3.training.rentals.dao.CustomerDAO;
import com.m3.training.rentals.errorlogging.ErrorLogger;
import com.m3.training.rentals.utility.ParseTools;

public class CustomerUI implements IUserInterface {

	private Map<String, IUserInterface> states;
	private UIHelper helper;
	private IUserInterface nextState = this;
	private ErrorLogger errorLogger;
	CustomerDAO dao;
	
	public CustomerUI(Map<String, IUserInterface> states, UIHelper helper, ErrorLogger errorLogger, CustomerDAO dao) {
		this.states= states;
		this.helper = helper;
		this.errorLogger = errorLogger;
		this.dao = dao;
	}
	
	@Override
	public IUserInterface getNextState() {
		return nextState;
	}

	Optional<List<Customer>> executeQuery(String query){
		if (query==null || query.equals("")) return null;
		int index=0;
		Map<String, String> queryParts = new HashMap<String,String>();
		queryParts.put("-fname", null);
		queryParts.put("-lname", null);
		queryParts.put("-email", null);
		String[] queryPortions= query.split("\\s+");
		if (queryPortions.length==0) return null;
		if (!(queryParts.containsKey(queryPortions[0]))) {
			throw new IllegalArgumentException("Does not have a proper flag");
		}
		String currPart= queryPortions[0];
		StringBuilder sb = new StringBuilder();
		while (index<queryPortions.length) {
			if (queryParts.containsKey(queryPortions[index])) {
				queryParts.put(currPart, sb.toString());
				sb = new StringBuilder();
				currPart = queryPortions[index];
			}else {
				sb.append(queryPortions[index]);
			}
			index++;
		}
		queryParts.put(currPart, sb.toString());
		return dao.readByPartialInfo(queryParts.get("-fname"), queryParts.get("-lname"), ParseTools.caseEmail(queryParts.get("-email"))) ;
	}
	
	private void printResult (Optional<List<Customer>> result) {
		List<Customer> resultList = result.get();
		for (Customer customer: resultList) {
			System.out.println("First Name: " + customer.getFirstName() + "Last Name: " + customer.getLastName() + "Email: " + customer.getEmail() );
		}
	}
	
	@Override
	public void execute() throws IllegalStateException {
		System.out.println("This is the customer search. What would you like to search?");
		System.out.println("Query results using the flag before each field (-fname, -lname, -email). Enter nothing if you want all customers");
		String input = helper.readInput();
		switch(input) {
			case "home":
				this.changeNextState("home");
				break;
			case "back":
				this.changeNextState("home");
				break;
			case "exit":
				this.setNextState(null);
				break;
			default:
				this.setNextState(this);
				Optional<List<Customer>> result =executeQuery(input);
				if (result.isPresent()) {
					printResult(result);
				}else {
				System.out.println("That was not a valid option. Please try again.");
				}
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
