package Assignment_4;

import java.util.Stack;

public class StackSorting {

	public static void main(String[] args) {
		Stack<Integer> stack =  new Stack<>();
		stack.push(5);
		stack.push(3);
		stack.push(7);
		stack.push(1);
		System.out.println("Original Stack: " + stack);
		StackSorter.sortStack(stack);
		System.out.println("Sorted Stack: " + stack);
	}

}
