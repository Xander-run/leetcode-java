package org.example.bst;


import org.example.util.TreeNode;

import java.util.*;

/**
 * 103. Binary Tree Zigzag Level Order Traversal
 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
 */

public class BinaryTreeZigzagLevelOrderTraversal {

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ret = new LinkedList<>();

        if (root == null) return  ret;

        Deque<TreeNode> deque = new LinkedList<>();
        deque.addLast(root);
        boolean fromLeftToRight = true;

        // TODO this can be refactored with functional programming
        while(!deque.isEmpty()) {
            List<Integer> line = new LinkedList<>();
            int n = deque.size();
            if (fromLeftToRight) {
                for (int i = 0; i < n; i++) {
                    TreeNode theNode = deque.pollFirst();
                    if (theNode != null) {
                        line.add(theNode.val);
                        deque.addLast(theNode.left);
                        deque.addLast(theNode.right);
                    }
                }
            } else {
                for (int i = 0; i < n; i++) {
                    TreeNode theNode = deque.pollLast();
                    if (theNode != null) {
                        line.add(theNode.val);
                        deque.addFirst(theNode.right);
                        deque.addFirst(theNode.left);
                    }
                }
            }
            if (!line.isEmpty())
                ret.add(line);
            fromLeftToRight = !fromLeftToRight;
        }

        return ret;
    }
}
