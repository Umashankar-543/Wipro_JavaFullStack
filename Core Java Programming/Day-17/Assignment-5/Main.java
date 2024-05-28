package Assignment_5;

public class Main {
	public static void main(String[] args) {
		String text = "ABCDEFGHIJKLMNOPQRSTUVWXYZRSTUVWXYZ";
		String pattern = "XYZ";
		int lastIndex = BoyerMooreAlgorithm.lastOccurrence(text, pattern);
		System.out.println("Last occurrence of pattern is at index: " + lastIndex);
	}
}