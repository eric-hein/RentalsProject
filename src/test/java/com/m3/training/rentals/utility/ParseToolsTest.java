package com.m3.training.rentals.utility;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

class ParseToolsTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test_ParseToolsTest_parseEmail() {
		String input= "AsDf.fff@fDsA.COm";
		String expected = "ASDF.FFF@fdsa.com";
		String result=ParseTools.caseEmail(input);
		String msg = "Should have returned : " + expected;
		assertEquals(expected, result, msg);
	}

}
