package com.tree;

public class BinarySearchTree {
	private TreeNode root;

	// Node class representing each node in the binary search tree
	private class TreeNode {
		int key;
		TreeNode left, right;

		TreeNode(int key) {
			this.key = key;
		}
	}

	// Method to insert a value in the tree
	public void insert(int key) {
		root = insertRecursive(root, key);
	}

	// Recursive method to insert a value in the tree
	private TreeNode insertRecursive(TreeNode node, int key) {
		if (node == null) {
			return new TreeNode(key);
		}
		if (key < node.key) {
			node.left = insertRecursive(node.left, key);
		} else if (key > node.key) {
			node.right = insertRecursive(node.right, key);
		}
		return node;
	}

	// Method to perform in-order traversal of the tree
	public void inOrder() {
		inOrderRecursive(root);
		System.out.println(); // for better formatting
	}

	// Recursive method to perform in-order traversal
	private void inOrderRecursive(TreeNode node) {
		if (node != null) {
			inOrderRecursive(node.left);
			System.out.print(node.key + " ");
			inOrderRecursive(node.right);
		}
	}

	// Method to search for a value in the tree
	public boolean search(int key) {
		return searchRecursive(root, key) != null;
	}

	// Recursive method to search for a value in the tree
	private TreeNode searchRecursive(TreeNode node, int key) {
		if (node == null || node.key == key) {
			return node;
		}
		if (key < node.key) {
			return searchRecursive(node.left, key);
		} else {
			return searchRecursive(node.right, key);
		}
	}

	// Method to delete a value from the tree
	public void delete(int key) {
		root = deleteRecursive(root, key);
	}

	// Recursive method to delete a value from the tree
	private TreeNode deleteRecursive(TreeNode node, int key) {
		if (node == null) {
			return null;
		}
		if (key < node.key) {
			node.left = deleteRecursive(node.left, key);
		} else if (key > node.key) {
			node.right = deleteRecursive(node.right, key);
		} else {
			if (node.left == null) {
				return node.right;
			} else if (node.right == null) {
				return node.left;
			}
			node.key = findMin(node.right).key;
			node.right = deleteRecursive(node.right, node.key);
		}
		return node;
	}

	// Method to find the minimum value in a subtree
	private TreeNode findMin(TreeNode node) {
		while (node.left != null) {
			node = node.left;
		}
		return node;
	}
}
