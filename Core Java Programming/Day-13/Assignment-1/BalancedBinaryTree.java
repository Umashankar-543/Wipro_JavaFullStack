package Assesment_1;

public class BalancedBinaryTree {
	private TreeNode root; 
    private class TreeNode { 
        int key; 
        TreeNode left, right; 
        TreeNode(int key) { 
            this.key = key; 
        } 
    } 

    public void insert(int key) { 
        root = insertRecursive(root, key); 
    } 
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

    public boolean isBalanced() { 
        return checkBalance(root) != -1; 
    } 

    private int checkBalance(TreeNode node) { 
        if (node == null) { 
            return 0; 
        } 
        int leftHeight = checkBalance(node.left); 
        if (leftHeight == -1) return -1;
        int rightHeight = checkBalance(node.right); 
        if (rightHeight == -1) return -1; 
        if (Math.abs(leftHeight - rightHeight) > 1) { 
            return -1;
        } 
        return Math.max(leftHeight, rightHeight) + 1;
    } 
}
