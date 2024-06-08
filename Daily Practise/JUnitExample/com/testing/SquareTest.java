package com.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SquareTest {

	@Test
	void test() {
		JUnitTesting test = new JUnitTesting();
		int output = test.square(5);
		assertEquals(25, output);
		// assertNotEquals(26, output);
	}
}