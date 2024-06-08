package com.functionalProgramming;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class BuiltInFunctionalInterfaceEx {

	public static void main(String[] args) {
		Predicate<String> isLongerThan5 = str -> str.length() > 5;
		System.out.println(isLongerThan5.test("Hello"));
		System.out.println(isLongerThan5.test("Hello, World!"));
		Function<String, Integer> lengthFunction = str -> str.length();
		System.out.println(lengthFunction.apply("Hello"));
		Consumer<String> printConsumer = str -> System.out.println(str);

		printConsumer.accept("Hello, World!");
		Supplier<String> stringSupplier = () -> "Hello, World!";
		System.out.println(stringSupplier.get());
	}
}