package org.example.bst;

import org.example.util.TreeNode;

/**
 * 236. Lowest Common Ancestor of a Binary Tree
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
 */

public class LowestCommonAncestorOfBinaryTree {

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return lowestNodeContainsAny(root, p, q);
    }

    private static TreeNode lowestNodeContainsAny(TreeNode root, TreeNode p, TreeNode q) {
        assert p != null && q != null;

        if (root == null) return null;

        if (root == p || root == q) return root;

        TreeNode leftLNCA = lowestNodeContainsAny(root.left, p, q);
        TreeNode rightLNCA = lowestNodeContainsAny(root.right, p, q);

        if (leftLNCA != null && rightLNCA != null)
            return root;
        else if (leftLNCA != null)
            return leftLNCA;
        else if (rightLNCA != null)
            return rightLNCA;
        else
            return null;
    }
}
