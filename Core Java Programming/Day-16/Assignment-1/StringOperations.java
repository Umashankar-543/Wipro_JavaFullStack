package Asignment_1;

public class StringOperations {
	public static String concatenateReverseAndExtract(String str1, String str2, int length) {
		String concatenated = str1 + str2;
		if (concatenated.isEmpty()) {
			return "";
		}
		String reversed = new StringBuilder(concatenated).reverse().toString();
		int totalLength = reversed.length();
		if (length >= totalLength) {
			return reversed;
		}
		int startIndex = (totalLength - length) / 2;
		return reversed.substring(startIndex, startIndex + length);
	}
}