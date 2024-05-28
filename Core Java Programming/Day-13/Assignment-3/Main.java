package Assesment_3;

public class Main {
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
