package com.m3.training.rentals.UI;
import java.util.Map;
import java.util.Scanner;

public class CustomerUI implements IUserInterface {

	private Map<String, IUserInterface> states;
	private UIHelper helper;
	private IUserInterface nextState = this;
	
	public CustomerUI(Map<String, IUserInterface> states, UIHelper helper) {
		this.states= states;
		this.helper = helper;
	}
	
	@Override
	public IUserInterface getNextState() {
		return nextState;
	}

	
	@Override
	public void execute() throws IllegalStateException {
		System.out.println("This is the customer search. What would you like to search?");
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
