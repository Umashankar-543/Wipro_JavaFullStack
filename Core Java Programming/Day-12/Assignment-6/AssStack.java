package Assignment_6;

import java.util.Stack;

public class AssStack {
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		stack.push(4);
		stack.push(5);
		stack.push(3);
		stack.push(2);
		stack.push(1);
		int[] sequence1 = { 3, 2, 1 };
		int[] sequence2 = { 5, 4, 3 };
		System.out.println("Sequence 1 present in stack: " + SequenceInStack.isSequencePresent(stack, sequence1));
		System.out.println("Sequence 2 present in stack: " + SequenceInStack.isSequencePresent(stack, sequence2));
	}
}
