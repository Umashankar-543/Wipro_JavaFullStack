package Day_24;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PersonSortExample {
	public static void main(String[] args) {
		List<Person> people = new ArrayList<>();
		people.add(new Person("Alice", 30, "123 Main St", "alice@example.com"));
		people.add(new Person("Bob", 25, "456 Elm St", "bob@example.com"));
		people.add(new Person("Charlie", 35, "789 Oak St", "charlie@example.com"));
		Collections.sort(people, (p1, p2) -> Integer.compare(p1.getAge(), p2.getAge()));
		System.out.println("Sorted by age:");
		for (Person person : people) {
			System.out.println(person);
		}
	}
}