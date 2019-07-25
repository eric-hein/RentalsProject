package com.m3.training.rentals.UI;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.m3.training.rentals.errorlogging.ErrorLogger;

public class UIDriver {
	
	public static void main (String[] args) {
		ErrorLogger errorLogger= new ErrorLogger();
		UIHelper helper= new UIHelper(errorLogger);
		IUserInterface currState;
		try {
			currState = helper.initStates();
			while (currState!=null) {
				currState.execute();
				currState = currState.getNextState();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			errorLogger.fatal("Failed to init states", e);
		}
	}
	
}
