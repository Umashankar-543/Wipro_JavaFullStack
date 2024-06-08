package Day_24;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class PersonOperations {
	public static void main(String[] args) {
		Person person = new Person("Alice", 30, "123 Main St", "alice@example.com");
		operateOnPerson(p -> p.getAge() > 18, p -> "Name: " + p.getName() + ", Age: " + p.getAge(),
				p -> p.setAddress("456 Elm St"),
				() -> new Person("Default", 0, "Default Address", "default@example.com"), person);
	}

	public static void operateOnPerson(Predicate<Person> predicate, Function<Person, String> function,
			Consumer<Person> consumer, Supplier<Person> supplier, Person person) {
		if (predicate.test(person)) {
			System.out.println(function.apply(person));
		}
		consumer.accept(person);
		System.out.println("After Consumer: " + person);
		Person newPerson = supplier.get();
		System.out.println("Supplied Person: " + newPerson);
	}
}
