package com.m3.training.rentals.UI;

import java.util.HashMap;
import java.util.Map;

public class UIDriver {
	
	public static void main (String[] args) {
		UIHelper helper= new UIHelper();
		IUserInterface currState =helper.initStates();
		while (currState!=null) {
			currState.execute();
			currState = currState.getNextState();
		}
		
	}
	
}
