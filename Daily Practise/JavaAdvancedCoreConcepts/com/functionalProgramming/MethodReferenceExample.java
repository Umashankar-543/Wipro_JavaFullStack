package com.functionalProgramming;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class MethodReferenceExample {

	public static void main(String[] args) {
		Consumer<String> print = System.out::println;
		print.accept("Hello, World!");
		String str = "Hello, World!";
		Supplier<Integer> lengthSupplier = str::length;
		System.out.println(lengthSupplier.get());
		Function<String, Integer> lengthFunction = String::length;
		System.out.println(lengthFunction.apply("Hello"));
		Supplier<List<String>> listSupplier = ArrayList::new;
		@SuppressWarnings("unused")
		List<String> list = listSupplier.get();
	}
}