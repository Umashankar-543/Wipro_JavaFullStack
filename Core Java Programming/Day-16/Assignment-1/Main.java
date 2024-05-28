package Asignment_1;

public class Main {
	public static void main(String[] args) {
		System.out.println(StringOperations.concatenateReverseAndExtract("hello", "world", 5));
		System.out.println(StringOperations.concatenateReverseAndExtract("abc", "def", 3));
		System.out.println(StringOperations.concatenateReverseAndExtract("", "", 2));
		System.out.println(StringOperations.concatenateReverseAndExtract("a", "b", 10));
		System.out.println(StringOperations.concatenateReverseAndExtract("123", "456", 4));
	}
}