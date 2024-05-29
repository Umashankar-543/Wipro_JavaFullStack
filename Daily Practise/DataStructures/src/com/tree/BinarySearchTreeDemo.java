package com.tree;

public class BinarySearchTreeDemo {

	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		// Insert nodes
		bst.insert(50);
		bst.insert(20);
		bst.insert(70);
		bst.insert(10);
		bst.insert(25);
		bst.insert(60);
		bst.insert(90);
		bst.insert(80);
		bst.insert(75);
		// In-order traversal
		System.out.print("In-order traversal: ");
		bst.inOrder();
		// Search for a value
		if (bst.search(70)) {
			System.out.println("Value 70 found");
		} else {
			System.out.println("Value 70 not found");
		}
		// Delete a node
		bst.delete(70);
		System.out.print("In-order traversal after deleting 70: ");
		bst.inOrder();
	}

}
