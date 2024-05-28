package Assignment_3;

public class KMPalgorithm {

	public static void KMPSearch(String pattern, String text) {
		int m = pattern.length();
		int n = text.length();
		int[] lps = new int[m];
		computeLPSArray(pattern, m, lps);
		int i = 0;
		int j = 0;
		while (i < n) {
			if (pattern.charAt(j) == text.charAt(i)) {
				i++;
				j++;
			}
			if (j == m) {
				System.out.println("Pattern found at index " + (i - j));
				j = lps[j - 1];
			} else if (i < n && pattern.charAt(j) != text.charAt(i)) {
				if (j != 0) {
					j = lps[j - 1];
				} else {
					i++;
				}
			}
		}
	}

	private static void computeLPSArray(String pattern, int m, int[] lps) {
		int length = 0;
		int i = 1;
		lps[0] = 0;
		while (i < m) {
			if (pattern.charAt(i) == pattern.charAt(length)) {
				length++;
				lps[i] = length;
				i++;
			} else {
				if (length != 0) {
					length = lps[length - 1];
				} else {
					lps[i] = 0;
					i++;
				}
			}
		}
	}
}