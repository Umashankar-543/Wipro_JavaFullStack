package Assignment_2;

public class Main {

	public static void main(String[] args) {
		String text = "AABAACAADAABAAABAA";
		String pattern = "AABA";
		searchPattern(text, pattern);
	}

	public static void searchPattern(String text, String pattern) {
		NaivePatternSearch.searchPattern(text, pattern);
	}
}
