package org.example.bst;

/**
 * 110. Balanced Binary Tree
 * https://leetcode.com/problems/balanced-binary-tree/
 */
public class BalancedBinaryTree {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static int dfsDepth(TreeNode root) {
        int ld, rd;
        if (root == null)
            return 0;
        else if ((ld = dfsDepth(root.left)) == -1)
            return -1;
        else if ((rd = dfsDepth(root.right)) == -1)
            return -1;
        else if (Math.abs(ld - rd) > 1)
            return -1;
        else
            return Math.max(ld, rd) + 1;
    }

    public static boolean isBalanced(TreeNode root) {
        return dfsDepth(root) != -1;
    }
}
