package Day_23;

public class ArrayUtils {
	public static <T> void swap(T[] array, int index1, int index2) {
		T temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
	}

	public static void main(String[] args) {
		Integer[] intArray = { 1, 2, 3, 4, 5 };
		String[] strArray = { "one", "two", "three", "four" };
		System.out.println("Original intArray: ");
		for (int i : intArray) {
			System.out.print(i + " ");
		}
		System.out.println();
		swap(intArray, 1, 3);
		System.out.println("Swapped intArray: ");
		for (int i : intArray) {
			System.out.print(i + " ");
		}
		System.out.println();
		System.out.println("Original strArray: ");
		for (String s : strArray) {
			System.out.print(s + " ");
		}
		System.out.println();
		swap(strArray, 0, 2);
		System.out.println("Swapped strArray: ");
		for (String s : strArray) {
			System.out.print(s + " ");
		}
		System.out.println();
	}
}