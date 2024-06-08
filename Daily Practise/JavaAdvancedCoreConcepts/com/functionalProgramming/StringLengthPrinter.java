package com.functionalProgramming;

@FunctionalInterface
interface StringLength {
	int getLength(String s);
}

public class StringLengthPrinter {
	public static void main(String[] args) {
		StringLength lengthCalculator = new StringLength() {

			@Override
			public int getLength(String s) {
				int length = s.length();
				System.out.println("Length: " + length);
				return length;
			}
		};
		lengthCalculator.getLength("Hello");
		StringLength lambdaLengthCalculator = (s) -> {
			int length = s.length();
			System.out.println("Length: " + length);
			return length;
		};
		lambdaLengthCalculator.getLength("Hello");
	}
}