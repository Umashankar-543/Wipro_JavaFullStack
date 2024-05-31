package com.queue;

public class QueueDemo {
	public static void main(String[] args) { 

		QueueUsingLinkedList obj=new QueueUsingLinkedList(); 
		obj.enqueue(1); 
		obj.enqueue(2); 
		obj.enqueue(3); 
		System.out.println("dequeued "+obj.dequeue() ); 
		System.out.println("dequeued "+obj.dequeue() ); 
		System.out.println("dequeued "+obj.dequeue() ); 
		obj.enqueue(4); 
		obj.enqueue(5); 
		System.out.println("dequeued "+obj.dequeue() ); 
		System.out.println("dequeued "+obj.dequeue() ); 
		System.out.println("dequeued "+obj.dequeue() ); 
	} 
}
