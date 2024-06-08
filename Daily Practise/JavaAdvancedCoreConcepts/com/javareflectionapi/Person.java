package com.javareflectionapi;

public class Person {
	private String name;
	private int age;
	private String address;
	private String email;

	public Person() {
	}

	public Person(String name, int age, String address, String email) {
		this.name = name;
		this.age = age;
		this.address = address;
		this.email = email;
	}

	public String getName() {
		return name;
	}

	@SuppressWarnings("unused")
	private void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	@SuppressWarnings("unused")
	private void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	@SuppressWarnings("unused")
	private void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	@SuppressWarnings("unused")
	private void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Person{name='" + name + "', age=" + age + "', address='" + address + "', email='" + email + "'}";
	}
}