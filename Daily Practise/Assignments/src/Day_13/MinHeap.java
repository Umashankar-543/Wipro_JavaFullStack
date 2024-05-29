package Day_13;

import java.util.ArrayList;
import java.util.List;

public class MinHeap {
	private List<Integer> heap;

	public MinHeap() {
		heap = new ArrayList<>();
	}

	private int parent(int index) {
		return (index - 1) / 2;
	}

	private int leftChild(int index) {
		return 2 * index + 1;
	}

	private int rightChild(int index) {
		return 2 * index + 2;
	}

	private void swap(int i, int j) {
		int temp = heap.get(i);
		heap.set(i, heap.get(j));
		heap.set(j, temp);
	}

	public void insert(int value) {
		heap.add(value);
		heapifyUp(heap.size() - 1);
	}

	private void heapifyUp(int index) {
		while (index > 0 && heap.get(index) < heap.get(parent(index))) {
			swap(index, parent(index));
			index = parent(index);
		}
	}

	public int deleteMin() {
		if (heap.isEmpty()) {
			throw new IllegalStateException("Heap is empty");
		}
		int min = heap.get(0);
		int lastElement = heap.remove(heap.size() - 1);
		if (!heap.isEmpty()) {
			heap.set(0, lastElement);
			heapifyDown(0);
		}
		return min;
	}

	private void heapifyDown(int index) {
		int smallest = index;
		int left = leftChild(index);
		int right = rightChild(index);
		if (left < heap.size() && heap.get(left) < heap.get(smallest)) {
			smallest = left;
		}
		if (right < heap.size() && heap.get(right) < heap.get(smallest)) {
			smallest = right;
		}
		if (smallest != index) {
			swap(index, smallest);
			heapifyDown(smallest);
		}
	}

	public int getMin() {
		if (heap.isEmpty()) {
			throw new IllegalStateException("Heap is empty");
		}
		return heap.get(0);
	}

	public void printHeap() {
		System.out.println(heap);
	}

	public static void main(String[] args) {
		MinHeap minHeap = new MinHeap();
		minHeap.insert(3);
		minHeap.insert(1);
		minHeap.insert(6);
		minHeap.insert(5);
		minHeap.insert(2);
		minHeap.insert(4);
		minHeap.printHeap();
		System.out.println("Min element: " + minHeap.getMin());
		System.out.println("Deleted min element: " + minHeap.deleteMin());
		minHeap.printHeap();
		System.out.println("New min element: " + minHeap.getMin());
	}
}
