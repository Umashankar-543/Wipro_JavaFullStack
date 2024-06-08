package com.functionalProgramming;

@FunctionalInterface
interface MessagePrinter {
	void printMessage();
}

public class HelloWorldPrinter {
	public static void main(String[] args) {
		MessagePrinter printer = new MessagePrinter() {
			@Override
			public void printMessage() {
				System.out.println("Hello World");
			}
		};
		printer.printMessage();
		MessagePrinter lambdaPrinter = () -> System.out.println("Hello World");
		lambdaPrinter.printMessage();
	}
}