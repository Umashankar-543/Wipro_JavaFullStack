package Assignment_4;

public class Main {
	public static void main(String[] args) {
		String text = "AABBCABBAACAABCCCBBAA";
		String pattern = "ABC";
		RabinKarpAlgorithm.search(pattern, text);
	}
}
