package Day_23;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {
	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(5);
		for (int i = 0; i < 10; i++) {
			int taskId = i;
			executor.submit(() -> {
				System.out.println("Task " + taskId + " is running on " + Thread.currentThread().getName());
				try {
					Thread.sleep((long) (Math.random() * 1000));
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Task " + taskId + " is completed on " + Thread.currentThread().getName());
			});
		}

		executor.shutdown();
	}
}