package Assignment_3;

public class Main {

	public static void main(String[] args) {
		String text = "ABABDABACDABABCABAB";
		String pattern = "ABABCABAB";
		KMPalgorithm.KMPSearch(pattern, text);
	}
}
