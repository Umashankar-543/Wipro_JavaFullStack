package com.javareflectionapi;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionExample {

	public static void main(String[] args) {

		try {
			Class<Person> personClass = Person.class;
			System.out.println("Fields:");
			Field[] fields = personClass.getDeclaredFields();
			for (Field field : fields) {
				System.out.println(field);
			}
			System.out.println("\nConstructors:");
			Constructor<?>[] constructors = personClass.getDeclaredConstructors();
			for (Constructor<?> constructor : constructors) {
				System.out.println(constructor);
			}
			System.out.println("\nMethods:");
			Method[] methods = personClass.getDeclaredMethods();
			for (Method method : methods) {
				System.out.println(method);
			}
			System.out.println("\nPublic Methods:");
			Method[] publicMethods = personClass.getMethods();
			for (Method method : publicMethods) {
				System.out.println(method);
			}
			Person person = personClass.getDeclaredConstructor().newInstance();
			Field nameField = personClass.getDeclaredField("name");
			nameField.setAccessible(true);
			nameField.set(person, "John Doe");

			Field ageField = personClass.getDeclaredField("age");
			ageField.setAccessible(true);
			ageField.set(person, 30);

			Field addressField = personClass.getDeclaredField("address");
			addressField.setAccessible(true);
			addressField.set(person, "123 Main St");

			Field emailField = personClass.getDeclaredField("email");
			emailField.setAccessible(true);
			emailField.set(person, "john.doe@example.com");

			System.out.println("\nModified Person: " + person);

			Method setNameMethod = personClass.getDeclaredMethod("setName", String.class);
			setNameMethod.setAccessible(true);
			setNameMethod.invoke(person, "Jane Doe");

			Method setAgeMethod = personClass.getDeclaredMethod("setAge", int.class);
			setAgeMethod.setAccessible(true);
			setAgeMethod.invoke(person, 25);

			Method setAddressMethod = personClass.getDeclaredMethod("setAddress", String.class);
			setAddressMethod.setAccessible(true);
			setAddressMethod.invoke(person, "456 Elm St");

			Method setEmailMethod = personClass.getDeclaredMethod("setEmail", String.class);
			setEmailMethod.setAccessible(true);
			setEmailMethod.invoke(person, "jane.doe@example.com");

			System.out.println("Modified Person Again: " + person);

			Method getNameMethod = personClass.getMethod("getName");
			String name = (String) getNameMethod.invoke(person);
			System.out.println("Name via getName(): " + name);
			System.out.println("\nAnnotations:");
			if (personClass.getAnnotations().length == 0) {
				System.out.println("No annotations present.");
			} else {
				for (Annotation annotation : personClass.getAnnotations()) {
					System.out.println(annotation);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}