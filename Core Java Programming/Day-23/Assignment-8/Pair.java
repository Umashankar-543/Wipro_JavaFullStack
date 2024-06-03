package Day_23;

public class Pair<T, U> {
	private final T first;
	private final U second;

	public Pair(T first, U second) {
		this.first = first;
		this.second = second;
	}

	public T getFirst() {
		return first;
	}

	public U getSecond() {
		return second;
	}

	public Pair<U, T> reverse() {
		return new Pair<>(second, first);
	}

	public static void main(String[] args) {
		Pair<String, Integer> pair = new Pair<>("Hello", 42);
		System.out.println("Original Pair: (" + pair.getFirst() + ", " + pair.getSecond() + ")");
		Pair<Integer, String> reversedPair = pair.reverse();
		System.out.println("Reversed Pair: (" + reversedPair.getFirst() + ", " + reversedPair.getSecond() + ")");
	}
}