package com.m3.training.rentals.utility;

public class ParseTools {

	public static String caseEmail(String email) {
		if (email==null) return null;
		StringBuilder sb = new StringBuilder();
		int indexOfAt = email.indexOf('@');
		sb.append(email.substring(0, indexOfAt).toUpperCase());
		sb.append("@");
		sb.append(email.substring(indexOfAt+1, email.length()).toLowerCase());
		return sb.toString();
	}
}
