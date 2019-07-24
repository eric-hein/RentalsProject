package com.m3.training.rentals.dao;

import java.util.Optional;

import com.m3.training.rentals.Customer;

public interface ICRUD<T> {

	void create();
	Object read(int id);
	void update();
	void delete();

}