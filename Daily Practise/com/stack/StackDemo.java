package com.stack;

public class StackDemo {

	public static void main(String[] args) {
		
		StackUsingArrays s1 = new StackUsingArrays();
		s1.push('a');
		s1.push('b');
		s1.push('c');
		s1.push('d');
		s1.push('e');
		s1.push('f');
		s1.push('g');
		s1.push('h');
		s1.push('i');
		s1.push('j');
		s1.push('k');
		System.out.println(s1.pop());
		System.out.println(s1.peek());
		System.out.println(s1.pop());
		System.out.println(s1.isEmpty());		
		
	}
	
}
