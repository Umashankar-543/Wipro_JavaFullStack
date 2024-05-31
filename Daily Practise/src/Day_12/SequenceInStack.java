package Day_12;

import java.util.Stack;

public class SequenceInStack {

	public static boolean isSequencePresent(Stack<Integer> stack, int[] sequence) {

		if (stack.isEmpty() || sequence.length == 0) {
			return false;
		}
		int sequenceIndex = 0;
		for (int element : stack) {
			if (element == sequence[sequenceIndex]) {
				sequenceIndex++;
			}
			if (sequenceIndex == sequence.length) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		stack.push(4);
		stack.push(5);
		stack.push(3);
		stack.push(2);
		stack.push(1);
		int[] sequence1 = { 3, 2, 1 };
		int[] sequence2 = { 5, 4, 3 };
		System.out.println("Sequence 1 present in stack: " + SequenceInStack.isSequencePresent(stack, sequence1)); // true
		System.out.println("Sequence 2 present in stack: " + SequenceInStack.isSequencePresent(stack, sequence2)); // false
	}
}
