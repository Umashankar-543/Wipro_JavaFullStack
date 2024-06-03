package com.thread;

class MyThread extends Thread {
	public void run() {
		for (int i = 1; i <= 3; i++) {
			System.out.println("child Thread " + i);
		}
		for (int i = 1; i <= 2; i++) {
			System.out.println("inner child Thread " + i);
		}
	}

	public void test() {
		for (int i = 1; i <= 3; i++) {
			System.out.println("Welcome" + i);
		}
	}
}

public class ThreadDemo {
	public static void main(String[] args) {
		MyThread t = new MyThread();
		t.start();
		for (int i = 1; i <= 3; i++) {
			System.out.println("Main Thread " + i);
		}
		t.test();
		for (int i = 1; i <= 3; i++) {
			System.out.println("random Thread " + i);
		}
	}
}