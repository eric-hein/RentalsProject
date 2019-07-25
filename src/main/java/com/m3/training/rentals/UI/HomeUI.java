package com.m3.training.rentals.UI;
import java.util.Map;
import java.util.Scanner;

import com.m3.training.rentals.errorlogging.ErrorLogger;

public class HomeUI implements IUserInterface {

	private Map<String, IUserInterface> states;
	private UIHelper helper;
	private IUserInterface nextState = this;
	private ErrorLogger errorLogger;
	
	public HomeUI(Map<String, IUserInterface> states, UIHelper helper, ErrorLogger errorLogger) {
		this.states= states;
		this.helper = helper;
		this.errorLogger = errorLogger;
	}
	
	@Override
	public IUserInterface getNextState() {
		return nextState;
	}

	
	@Override
	public void execute()  throws IllegalStateException{
		System.out.println("Hello. Welcome to the Rental Database.");
		System.out.println("Please type the category you want to search: Customer, Film, Rentals");
		String input = helper.readInput();
		switch(input) {
			case "customer":
				this.changeNextState("customer");
				break;
			case "rentals":
				this.changeNextState("rental");
				break;
			case "film":
				this.changeNextState("film");
				break;
			case "home":
				this.changeNextState("home");
				break;
			case "back":
				System.out.println("This is already the home.");
				this.changeNextState("home");
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
