package com.list;

public class DemoList {
	public static void main(String[] args) {
		
		LinkedList<Integer> list=new LinkedList<Integer>(); 
		list.insertAtBeginning(1); 
		list.insertAtBeginning(2); 
		list.display(); 
		System.out.println(""); 
		list.insertAtPos(1, 3); 
		list.display();
		
	} 
}
