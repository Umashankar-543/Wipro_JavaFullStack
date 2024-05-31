package com.patternsearching;

public class BoyerMooreAlgorithm {
	private static final int ALPHABET_SIZE = 256;

	public static int lastOccurrence(String text, String pattern) {
		int m = pattern.length();
		int n = text.length();
		int[] badChar = new int[ALPHABET_SIZE];
		for (int i = 0; i < ALPHABET_SIZE; i++) {
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

	public static void main(String[] args) {
		String text = "ABCMNOPQRWXYZABCDEFGHNOPQRSTUVWXYZ";
		String pattern = "XYZ";
		int lastIndex = lastOccurrence(text, pattern);
		System.out.println("Last occurrence of pattern is at index: " + lastIndex);
	}
}