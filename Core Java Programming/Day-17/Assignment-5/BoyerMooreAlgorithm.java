package Assignment_5;

public class BoyerMooreAlgorithm {
	private static final int alphabet_size = 256;

	public static int lastOccurrence(String text, String pattern) {
		int m = pattern.length();
		int n = text.length();
		int[] badChar = new int[alphabet_size];
		for (int i = 0; i < alphabet_size; i++) {
			badChar[i] = -1;
		}
		for (int i = 0; i < m; i++) {
			badChar[(int) pattern.charAt(i)] = i;
		}
		int shift = 0;
		int lastIndex = -1;
		while (shift <= (n - m)) {
			int j = m - 1;
			while (j >= 0 && pattern.charAt(j) == text.charAt(shift + j)) {
				j--;
			}
			if (j < 0) {
				lastIndex = shift;
				shift += (shift + m < n) ? m - badChar[text.charAt(shift + m)] : 1;
			} else {
				shift += Math.max(1, j - badChar[text.charAt(shift + j)]);
			}
		}
		return lastIndex;
	}
}