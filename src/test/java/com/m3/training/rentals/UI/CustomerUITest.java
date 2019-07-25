package com.m3.training.rentals.UI;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import com.m3.training.rentals.dao.CustomerDAO;
import com.m3.training.rentals.errorlogging.ErrorLogger;

import static org.mockito.Mockito.*;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

class CustomerUITest {
	
	private CustomerUI objectUnderTest;
	private CustomerDAO dao;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		Map<String, IUserInterface> states = new HashMap<>();
		ErrorLogger errorLogger= new ErrorLogger();
		dao = mock(CustomerDAO.class);
		objectUnderTest = new CustomerUI(states, new UIHelper(errorLogger), errorLogger, dao);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test_CustomerUITest_parseExecuteOnFull() throws SQLException {
		String query = "-fname MARY -lname SMITH -email MARY.SMITH@sakilacustomer.org";
		objectUnderTest.executeQuery(query);
		verify(dao).readByPartialInfo("MARY", "SMITH", "MARY.SMITH@sakilacustomer.org");
	}
	
	@Test
	void test_CustomerUITest_parseExecuteOnPartial() throws SQLException {
		String query = "-fname MARY -lname SMITH";
		objectUnderTest.executeQuery(query);
		verify(dao).readByPartialInfo("MARY", "SMITH", null);
	}
	
	@Test
	void test_CustomerUITest_parseExecuteOnNull() throws SQLException {
		String query = null;
		String msg = "should return null";
		assertNull(objectUnderTest.executeQuery(query), msg);
	}
	
	@Test
	void test_CustomerUITest_parseExecuteOnEmpty() throws SQLException {
		String query = "";
		String msg = "should return null";
		assertNull(objectUnderTest.executeQuery(query), msg);
	}
	@Test
	void test_CustomerUITest_parseExecuteOnSpaces() throws SQLException {
		String query = "   ";
		String msg = "should return null";
		assertNull(objectUnderTest.executeQuery(query), msg);
	}

}
