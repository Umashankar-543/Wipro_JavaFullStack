package Assesment_1;

public class Main {

	public static void main(String[] args) {
		BalancedBinaryTree tree = new BalancedBinaryTree();

		tree.insert(10);
		tree.insert(5);
		tree.insert(15);
		tree.insert(3);
		tree.insert(7);
		tree.insert(12);
		tree.insert(17);

		if (tree.isBalanced()) {
			System.out.println("The tree is balanced.");
		} else {
			System.out.println("The tree is not balanced.");
		}
	}
}
