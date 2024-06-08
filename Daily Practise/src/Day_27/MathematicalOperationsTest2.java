package Day_27;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MathematicalOperationsTest2 {
	private static MathematicalOperations mathOps;

	@BeforeAll
	public static void setupBeforeClass() {
		System.out.println("Setting up before all tests");
		mathOps = new MathematicalOperations();
	}

	@AfterAll
	public static void teardownAfterClass() {
		System.out.println("Tearing down after all tests");
		mathOps = null;
	}

	@BeforeEach
	public void setupBeforeEach() {
		System.out.println("Setting up before each test");
	}

	@AfterEach
	public void teardownAfterEach() {
		System.out.println("Tearing down after each test");
	}

	@Test
	public void testAdd() {
		assertEquals(5, mathOps.add(2, 3), "2 + 3 should equal 5");
		assertEquals(-1, mathOps.add(-2, 1), "-2 + 1 should equal -1");
		assertEquals(0, mathOps.add(0, 0), "0 + 0 should equal 0");
	}

	@Test
	public void testSubtract() {
		assertEquals(1, mathOps.subtract(3, 2), "3 - 2 should equal 1");
		assertEquals(-3, mathOps.subtract(-2, 1), "-2 - 1 should equal -3");
		assertEquals(0, mathOps.subtract(0, 0), "0 - 0 should equal 0");
	}

	@Test
	public void testMultiply() {
		assertEquals(6, mathOps.multiply(2, 3), "2 * 3 should equal 6");
		assertEquals(-2, mathOps.multiply(-2, 1), "-2 * 1 should equal -2");
		assertEquals(0, mathOps.multiply(0, 5), "0 * 5 should equal 0");
	}

	@Test
	public void testDivide() {
		assertEquals(2, mathOps.divide(6, 3), "6 / 3 should equal 2");
		assertEquals(-2, mathOps.divide(-4, 2), "-4 / 2 should equal -2");
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			mathOps.divide(1, 0);
		});
		assertEquals("Cannot divide by zero.", exception.getMessage());
	}
}