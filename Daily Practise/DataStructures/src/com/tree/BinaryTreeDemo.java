package com.tree;

public class BinaryTreeDemo {
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree(8);
		tree.insertLeft(tree.root, 1);
		tree.insertRight(tree.root, 9);
		tree.insertLeft(tree.root.left, 5);
		tree.insertRight(tree.root.left, 15);
		tree.insertLeft(tree.root.right, 10);
// Traversal Techniques 
		BinaryTree.preOrder(tree.root);
		System.out.println();
		BinaryTree.inOrder(tree.root);
		System.out.println();
		BinaryTree.postOrder(tree.root);

	}
}
