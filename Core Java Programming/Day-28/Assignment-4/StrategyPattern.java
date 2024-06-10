package Day_28;

interface SortingStrategy {
	void sort(int[] numbers);
}

class BubbleSortStrategy implements SortingStrategy {

	@Override
	public void sort(int[] numbers) {
		int n = numbers.length;
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n - 1 - i; j++) {
				if (numbers[j] > numbers[j + 1]) {
					int temp = numbers[j];
					numbers[j] = numbers[j + 1];
					numbers[j + 1] = temp;
				}
			}
		}
		System.out.println("Sorted using Bubble Sort");
	}
}

class QuickSortStrategy implements SortingStrategy {

	@Override
	public void sort(int[] numbers) {
		quickSort(numbers, 0, numbers.length - 1);
		System.out.println("Sorted using Quick Sort");
	}

	private void quickSort(int[] array, int low, int high) {
		if (low < high) {
			int pi = partition(array, low, high);
			quickSort(array, low, pi - 1);
			quickSort(array, pi + 1, high);
		}
	}

	private int partition(int[] array, int low, int high) {
		int pivot = array[high];
		int i = (low - 1);
		for (int j = low; j < high; j++) {
			if (array[j] < pivot) {
				i++;
				int temp = array[i];
				array[i] = array[j];
				array[j] = temp;
			}
		}

		int temp = array[i + 1];
		array[i + 1] = array[high];
		array[high] = temp;
		return i + 1;
	}
}

class Context {
	private SortingStrategy strategy;

	public void setStrategy(SortingStrategy strategy) {
		this.strategy = strategy;
	}

	public void executeStrategy(int[] numbers) {
		strategy.sort(numbers);
	}
}

public class StrategyPattern {
	public static void main(String[] args) {
		Context context = new Context();
		int[] numbers = { 64, 34, 25, 12, 22, 11, 90 };

		// Use Bubble Sort
		context.setStrategy(new BubbleSortStrategy());
		context.executeStrategy(numbers);
		System.out.println("Sorted array: " + java.util.Arrays.toString(numbers));

		// Reset the array
		int[] numbers2 = { 64, 34, 25, 12, 22, 11, 90 };

		// Use Quick Sort
		context.setStrategy(new QuickSortStrategy());
		context.executeStrategy(numbers2);
		System.out.println("Sorted array: " + java.util.Arrays.toString(numbers2));
	}
}