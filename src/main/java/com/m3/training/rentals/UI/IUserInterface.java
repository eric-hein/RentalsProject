package com.m3.training.rentals.UI;

public interface IUserInterface {
	
	public void execute()  throws IllegalStateException;
	public IUserInterface getNextState();

}
