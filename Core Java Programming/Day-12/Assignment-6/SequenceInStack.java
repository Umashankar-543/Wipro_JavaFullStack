package Assignment_6;

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
}
