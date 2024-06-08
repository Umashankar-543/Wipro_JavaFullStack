package Day_25;

import java.io.Serializable;

public class Person implements Serializable {
	private static final long serialVersionUID = 1L;
	private String name;
	private int age;
	private String address;

	public Person(String name, int age, String address) {
		this.setName(name);
		this.setAge(age);
		this.setAddress(address);
	}

	@Override
	public String toString() {
		return "Person{name='" + getName() + "', age=" + getAge() + ", address='" + getAddress() + "'}";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}