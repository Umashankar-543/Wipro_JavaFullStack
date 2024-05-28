package Assignment_4;

import java.util.Stack;

public class StackSorter {
	public static void sortStack(Stack<Integer> stack) {
		Stack<Integer> tempStack = new Stack<>();
		while(!stack.isEmpty()) {
			int temp =  stack.pop();
			while(!tempStack.isEmpty() && tempStack.peek()>temp) {
				stack.push(tempStack.pop());
			}
			tempStack.push(temp);
		}
		while(!tempStack.isEmpty()) {
			stack.push(tempStack.pop());
		}
	}

}
