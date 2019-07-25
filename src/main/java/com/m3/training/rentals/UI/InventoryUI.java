package com.m3.training.rentals.UI;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.m3.training.rentals.Inventory;
import com.m3.training.rentals.dao.InventoryDAO;
import com.m3.training.rentals.errorlogging.ErrorLogger;

public class InventoryUI implements IUserInterface {

	private Map<String, IUserInterface> states;
	private UIHelper helper;
	private IUserInterface nextState = this;
	InventoryDAO dao;
	
	public InventoryUI(Map<String, IUserInterface> states, UIHelper helper,  InventoryDAO dao) {
		this.states= states;
		this.helper = helper;
		this.dao = dao;
	}
	
	@Override
	public IUserInterface getNextState() {
		return nextState;
	}

	
	private void printResult (Optional<List<Inventory>> result) {
		List<Inventory> resultList = result.get();
		for (Inventory inventory: resultList) {
			System.out.println("Title: " + inventory.getFilm().getTitle() + " Store: " + inventory.getStore() + " InventoryID: " + inventory.getInventoryID() );
		}
	}
	
	
	@Override
	public void execute() throws IllegalStateException {
		System.out.println("This is the inventory database");
		System.out.println("Please input \"Inventory\" to get inventory");
		String input = helper.readInput();
		switch(input) {
			case "home":
				this.changeNextState("home");
				break;
			case "back":
				this.changeNextState("home");
				break;
			case "inventory":
				Optional<List<Inventory>> result = dao.read();
				printResult(result);
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
