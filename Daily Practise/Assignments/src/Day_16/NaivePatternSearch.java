package Day_16;

public class NaivePatternSearch {

	public static void searchPattern(String text, String pattern) {
		int m = pattern.length();
		int n = text.length();
		int comparisons = 0;
		for (int i = 0; i <= n - m; i++) {
			int j;
			for (j = 0; j < m; j++) {
				comparisons++;
				if (text.charAt(i + j) != pattern.charAt(j)) {
					break;
				}
			}
			if (j == m) {
				System.out.println("Pattern found at index " + i);
			}
		}
		System.out.println("Total comparisons: " + comparisons);
	}

	public static void main(String[] args) {
		String text = "AABAACAADAABAAABAA";
		String pattern = "AABA";
		searchPattern(text, pattern);
	}

}