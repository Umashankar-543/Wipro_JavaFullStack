package Day_25;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeserializeExample {
	public static void main(String[] args) {
		Person person = null;
		try (FileInputStream fileIn = new FileInputStream("person.ser");
				ObjectInputStream in = new ObjectInputStream(fileIn)) {
			person = (Person) in.readObject();
		} catch (IOException i) {
			i.printStackTrace();
			return;
		} catch (ClassNotFoundException c) {
			System.out.println("Person class not found");
			c.printStackTrace();
			return;
		}
		System.out.println("Deserialized Person...");
		System.out.println("Name: " + person.getName());
		System.out.println("Age: " + person.getAge());
		System.out.println("Address: " + person.getAddress());
	}
}