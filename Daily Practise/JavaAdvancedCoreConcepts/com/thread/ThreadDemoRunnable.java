package com.thread;

class MyRunnable implements Runnable {
	@Override
	public void run() {
		for (int i = 1; i <= 3; i++) {
			System.out.println("child Thread " + i);
		}
	}

	public void test() {
		for (int i = 1; i <= 3; i++) {
			System.out.println("test Thread " + i);
		}
	}
}

public class ThreadDemoRunnable {
	public static void main(String[] args) {
		MyRunnable r = new MyRunnable();
		Thread t = new Thread(r);
		t.start();
		for (int i = 1; i <= 3; i++) {
			System.out.println("main Thread " + i);
		}
		r.test();
	}
}