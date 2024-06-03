package Day_23;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumer {
	public static void main(String[] args) {
		Queue<Integer> queue = new LinkedList<>();
		int capacity = 5;
		int maxProduceConsumeCycles = 10;
		Thread producer = new Thread(() -> {
			int value = 0;
			for (int i = 0; i < maxProduceConsumeCycles; i++) {
				synchronized (queue) {
					while (queue.size() == capacity) {
						try {
							queue.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					queue.add(++value);
					System.out.println("Produced: " + value);
					queue.notify();
				}
			}
		});
		Thread consumer = new Thread(() -> {
			for (int i = 0; i < maxProduceConsumeCycles; i++) {
				synchronized (queue) {
					while (queue.isEmpty()) {
						try {
							queue.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					int value = queue.poll();
					System.out.println("Consumed: " + value);
					queue.notify();
				}
			}
		});
		producer.start();
		consumer.start();
	}
}