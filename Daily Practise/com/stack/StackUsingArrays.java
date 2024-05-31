package com.stack;

public class StackUsingArrays {
	
	char[] arr = new char[10];
	int topele;
	
	public StackUsingArrays() {
		topele = -1;
	}

	void push(char ele) {
		if(topele==9) {
			System.out.println("Stack over flow");
		}
		else {
			arr[++topele]= ele;
		}
		
	}
	
	char pop() {
		if(topele>-1) {
			return arr[topele--];
		}
		else {
			System.out.println("Stack is Empty");
			return '!';
		}
	}
	
	char peek() {
		if(topele<0) {
			System.out.println("Stack is empty");
		return '!';
		}
		else {
			return arr[topele];
		}
	}
	
	boolean isEmpty() {
		return topele==-1;
	}


}
