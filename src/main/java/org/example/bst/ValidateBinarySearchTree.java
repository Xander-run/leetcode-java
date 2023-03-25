package org.example.bst;

import org.example.util.TreeNode;

import java.util.ArrayList;
import java.util.Objects;

/**
 * 98. Validate Binary Search Tree
 * https://leetcode.com/problems/validate-binary-search-tree/
 */

public class ValidateBinarySearchTree {

    public static boolean isValidBST(TreeNode root) {
        ArrayList<Integer> order = inOrderTraversal(root);
        for (int i = 1; i < order.size(); i++) {
            if (i == order.size() - 1)
                return order.get(i) > order.get(i - 1);

            if (order.get(i) <= order.get(i - 1) || order.get(i) >= order.get(i + 1))
                return false;
        }
        return true;
    }

    private static ArrayList<Integer> inOrderTraversal(TreeNode root) {
        ArrayList<Integer> ret = new ArrayList<>();
        inOrderTraversal(root, ret);
        return  ret;
    }

    private static void inOrderTraversal(TreeNode root, ArrayList<Integer> orderList) {
        if (root == null) return;

        inOrderTraversal(root.left, orderList);
        orderList.add(root.val);
        inOrderTraversal(root.right, orderList);
    }
}
