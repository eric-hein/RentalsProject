package com.m3.training.rentals.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import com.m3.training.rentals.Customer;
import com.m3.training.rentals.Payment;
import com.m3.training.rentals.Rental;
import com.m3.training.rentals.Staff;

public class StaffDAO extends DAO<Staff> {

	private final String queryString = "SELECT STAFF_ID, FIRST_NAME, LAST_NAME, GROSSREVENUE\r\n" + 
			"FROM STAFF INNER JOIN (\r\n" + 
			"SELECT PAYMENT.STAFF_ID AS STAFFIDS, SUM(AMOUNT) AS GROSSREVENUE FROM PAYMENT\r\n" + 
			"INNER JOIN STAFF ON\r\n" + 
			"PAYMENT.STAFF_ID = STAFF.STAFF_ID\r\n" + 
			"GROUP BY PAYMENT.STAFF_ID)\r\n" + 
			"ON STAFF.STAFF_ID = STAFFIDS ORDER BY GROSSREVENUE DESC";

	public StaffDAO() throws SQLException {
		super();
	}

	@Override
	public Optional<Staff> read(int id) {
		Staff staff = em.find(Staff.class, id);
		return Optional.ofNullable(staff);
	}

	public Optional<List<Staff>> getStaff() {

		TypedQuery<Staff> query = em.createQuery("SELECT s FROM Staff s ORDER BY s.name", Staff.class);

		List<Staff> staffList = query.getResultList();
		return Optional.ofNullable(staffList);
	}

	public List<Object[]> getHighestGrossingStaff() {

		Query query = em.createNativeQuery(queryString);
		List<Object[]> revenueList = query.getResultList();
		return revenueList;
	}
}