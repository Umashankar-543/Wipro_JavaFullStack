package com.functionalProgramming;

@FunctionalInterface
interface Adder {
	int add(int a, int b);
}

public class AdditionPrinter {
	public static void main(String[] args) {
		Adder adder = new Adder() {
			@Override
			public int add(int a, int b) {
				int sum = a + b;
				System.out.println("Sum: " + sum);
				return sum;
			}
		};
		adder.add(5, 3);
		Adder lambdaAdder = (a, b) -> {
			int sum = a + b;
			System.out.println("Sum: " + sum);
			return sum;
		};
		lambdaAdder.add(5, 3);
	}
}