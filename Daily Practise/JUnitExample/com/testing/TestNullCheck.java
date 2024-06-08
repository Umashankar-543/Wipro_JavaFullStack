package com.testing;

import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class TestNullCheck {

	@SuppressWarnings("unused")
	@Test
	void test() {
		JUnitTesting test = new JUnitTesting();
		String nullString = null;
		String notNullString = "Uma";
		assertNull(nullString);
		// assertNotNull(notNullString);
	}

}
