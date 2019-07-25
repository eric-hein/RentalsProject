package com.m3.training.rentals.UI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.m3.training.rentals.Film;
import com.m3.training.rentals.dao.FilmDAO;

public class FilmUI implements IUserInterface {

	private Map<String, IUserInterface> states;
	private UIHelper helper;
	private IUserInterface nextState = this;
	FilmDAO dao;
	
	public FilmUI(Map<String, IUserInterface> states, UIHelper helper, FilmDAO dao) {
		this.states= states;
		this.helper = helper;
		this.dao = dao;
	}
	
	@Override
	public IUserInterface getNextState() {
		return nextState;
	}

	Optional<List<Film>> executeQuery(String query){
		if (query==null || query.equals("")) return null;
		int index=0;
		Map<String, String> queryParts = new HashMap<String,String>();
		queryParts.put("-title", null);
		queryParts.put("-description", null);
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
		return dao.readByPartialInfo(queryParts.get("-title"), queryParts.get("-description")) ;
	}
	
	private void printResult (Optional<List<Film>> result) {
		List<Film> resultList = result.get();
		for (Film film: resultList) {
			System.out.println("Title: " + film.getTitle() + " Description: " + film.getDescription());
		}
	}
	
	@Override
	public void execute() throws IllegalStateException {
		System.out.println("This is the film search. What would you like to search?");
		System.out.println("Query results using the flag before each field (-title, -description). Enter nothing if you want all customers");
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
				Optional<List<Film>> result =executeQuery(input);
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
