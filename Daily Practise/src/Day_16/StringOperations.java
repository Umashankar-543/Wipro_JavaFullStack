package Day_16;

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

	public static void main(String[] args) {
		System.out.println(StringOperations.concatenateReverseAndExtract("hello", "world", 5));
		System.out.println(StringOperations.concatenateReverseAndExtract("abc", "def", 3));
		System.out.println(StringOperations.concatenateReverseAndExtract("", "", 2));
		System.out.println(StringOperations.concatenateReverseAndExtract("a", "b", 10));
		System.out.println(StringOperations.concatenateReverseAndExtract("123", "456", 4));
	}
}