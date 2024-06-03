package Day_23;

public class ThreadStateSimulator {
	public static void main(String[] args) {
		Thread thread = new Thread(() -> {
			try {
				synchronized (ThreadStateSimulator.class) {
					ThreadStateSimulator.class.wait(2000);
				}
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		System.out.println("State after creation: " + thread.getState());
		thread.start();
		System.out.println("State after start: " + thread.getState());
		try {
			Thread.sleep(100);
			System.out.println("State after short sleep: " + thread.getState());
			synchronized (ThreadStateSimulator.class) {
				ThreadStateSimulator.class.notify();
			}
			thread.join();
			System.out.println("State after join: " + thread.getState());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}