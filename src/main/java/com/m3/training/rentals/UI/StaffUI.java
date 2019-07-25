package com.m3.training.rentals.UI;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.m3.training.rentals.Staff;
import com.m3.training.rentals.dao.StaffDAO;
import com.m3.training.rentals.errorlogging.ErrorLogger;

public class StaffUI implements IUserInterface {

	private Map<String, IUserInterface> states;
	private UIHelper helper;
	private IUserInterface nextState = this;
	StaffDAO dao;
	
	public StaffUI(Map<String, IUserInterface> states, UIHelper helper, StaffDAO dao) {
		this.states= states;
		this.helper = helper;
		this.dao = dao;
	}
	
	@Override
	public IUserInterface getNextState() {
		return nextState;
	}

	
	private void printResult (Optional<List<Staff>> result) {
		List<Staff> resultList = result.get();
		for (Staff staff: resultList) {
			System.out.println(" Staff's name: " + staff.getFirstName() + " " + staff.getLastName() + " Email: " + staff.getEmail() + " Employee ID " + staff.getStaffId() );
		}
	}
	
	
	@Override
	public void execute() throws IllegalStateException {
		System.out.println("This is the staff database!");
		System.out.println("Please input \"Get Staff\" to get staff");
		String input = helper.readInput();
		switch(input) {
			case "home":
				this.changeNextState("home");
				break;
			case "back":
				this.changeNextState("home");
				break;
			case "get staff":
				Optional<List<Staff>> result = dao.getStaff();
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
