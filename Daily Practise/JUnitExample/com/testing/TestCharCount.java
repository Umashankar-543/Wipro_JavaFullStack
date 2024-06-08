package com.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class TestCharCount {

	@Test
	void test() {
		JUnitTesting test = new JUnitTesting();

		int output = test.countA("shankar");

		assertEquals(2, output);
	}

}
