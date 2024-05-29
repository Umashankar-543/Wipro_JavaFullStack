package com.queue;

public class QueueUsingLinkedList {
	
	class Node{ 
		int data; 
		Node next; 
		Node(int ele){ 
			data = ele; 
			next = null; 
		} 
	} 

	Node front,rear; 
	QueueUsingLinkedList(){ 
		front = null; 
		rear = null; 
	} 

	public void enqueue(int ele) { //O(1) 
		Node newNode = new Node(ele); 
		if(front==null) {
			front = newNode;
		}
		else {
			rear.next = newNode	;//6 null 
		}
		    rear = newNode; 
	} 

	public int dequeue() { 
		if(front==null)  //no node in Q queue is empty 
			throw new IndexOutOfBoundsException("Queue is Empty"); 
		int temp = front.data; 
		front = front.next; 
		if(front==null) { //deleted last node and now Q is empty 
			rear=null; 
		}
		return temp; 
	} 

	public boolean isEmpty() { 
		return front==null; 
	} 


	public int elementAtFront() { 
		if(front==null)  //no node in Q 
			throw new IndexOutOfBoundsException("Queue is Empty"); 
		return front.data; 
	} 
}
