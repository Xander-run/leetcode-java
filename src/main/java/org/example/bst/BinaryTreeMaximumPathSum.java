package org.example.bst;

import org.example.bst.util.TreeNode;

import java.util.stream.Stream;

/**
 * 124. Binary Tree Maximum Path Sum
 * https://leetcode.com/problems/binary-tree-maximum-path-sum/
 */

public class BinaryTreeMaximumPathSum {

    private static int maxSum;
    public static int maxPathSum(TreeNode root) {
        maxSum = root.val;
        maxPathEndsAt(root);
        return maxSum;
    }

    private static int maxPathEndsAt(TreeNode root) {
        if (root == null) return 0;
        int leftMax = maxPathEndsAt(root.left);
        int rightMax = maxPathEndsAt(root.right);
        int ret = Stream.of(root.val, leftMax + root.val, rightMax + root.val).max(Integer::compare).get();
        maxSum = Math.max(Math.max(maxSum, ret), leftMax + root.val + rightMax);
        return ret;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        assert maxPathSum(root) == 6;
    }
}
