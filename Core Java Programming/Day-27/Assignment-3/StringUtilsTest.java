package Day_27;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class StringUtilsTest {

	@Test
	public void testIsEmpty() {
		assertTrue(StringUtils.isEmpty(""), "Empty string should be considered empty");
		assertTrue(StringUtils.isEmpty(null), "Null string should be considered empty");
		assertFalse(StringUtils.isEmpty("abc"), "Non-empty string should not be considered empty");
	}

	@Test
	public void testReverse() {
		assertEquals("cba", StringUtils.reverse("abc"), "Reversed string of 'abc' should be 'cba'");
		assertEquals("", StringUtils.reverse(""), "Reversed string of empty string should be empty string");
		assertNull(StringUtils.reverse(null), "Reversing null should return null");
	}

	@Test
	public void testIsPalindrome() {
		assertTrue(StringUtils.isPalindrome("maam"), "'maam' should be considered a palindrome");
		assertTrue(StringUtils.isPalindrome(""), "Empty string should be considered a palindrome");
		assertFalse(StringUtils.isPalindrome("abc"), "'abc' should not be considered a palindrome");
		assertFalse(StringUtils.isPalindrome(null), "Null should not be considered a palindrome");
	}
}