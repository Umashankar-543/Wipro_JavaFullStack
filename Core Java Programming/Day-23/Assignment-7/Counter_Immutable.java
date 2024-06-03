package Day_23;

public class Counter_Immutable {

	public static void main(String[] args) {
		// Demonstrating the usage of Counter class
		Counter counter = new Counter();
		Runnable incrementTask = () -> {
			for (int i = 0; i < 1000; i++) {
				counter.increment();
			}
			System.out.println(Thread.currentThread().getName() + " finished incrementing.");
		};
		Runnable decrementTask = () -> {
			for (int i = 0; i < 1000; i++) {
				counter.decrement();
			}
			System.out.println(Thread.currentThread().getName() + " finished decrementing.");
		};
		Thread thread1 = new Thread(incrementTask, "Thread-1");
		Thread thread2 = new Thread(decrementTask, "Thread-2");
		Thread thread3 = new Thread(incrementTask, "Thread-3");
		Thread thread4 = new Thread(decrementTask, "Thread-4");
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
		try {
			thread1.join();
			thread2.join();
			thread3.join();
			thread4.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Final count: " + counter.getCount());

		// Demonstrating the usage of ImmutableData class
		ImmutableData data = new ImmutableData("example", 42);
		Runnable printTask = () -> {
			for (int i = 0; i < 10; i++) {
				System.out.println("Data: " + data.getName() + ", Value: " + data.getValue());
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println(Thread.currentThread().getName() + " finished printing.");
		};
		Thread thread5 = new Thread(printTask, "Thread-5");
		Thread thread6 = new Thread(printTask, "Thread-6");
		thread5.start();
		thread6.start();
		try {
			thread5.join();
			thread6.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	static class Counter {
		private int count = 0;

		public synchronized void increment() {
			count++;
		}

		public synchronized void decrement() {
			count--;
		}

		public synchronized int getCount() {
			return count;
		}
	}

	final static class ImmutableData {
		private final String name;
		private final int value;

		public ImmutableData(String name, int value) {
			this.name = name;
			this.value = value;
		}

		public String getName() {
			return name;
		}

		public int getValue() {
			return value;
		}
	}
}