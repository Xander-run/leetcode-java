package org.example.linkedlist;

import org.example.util.ListNode;

/**
 * 143. Reorder List
 * https://leetcode.com/problems/reorder-list/
 */
public class ReorderList {

    public static void reorderList(ListNode head) {
        if (head == null) return;

        ListNode mid = findMid(head);
        ListNode nextHalf = mid.next;
        mid.next = null;
        combineList(head, reverseList(nextHalf));
    }

    public static ListNode findMid(ListNode head) {
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    public static ListNode reverseList(ListNode head) {
        ListNode prev = null, ptr = head;

        while (ptr != null) {
            ListNode tmp = ptr.next;
            ptr.next = prev;
            prev = ptr;
            ptr = tmp;
        }

        return prev;
    }

    public static void combineList(ListNode left, ListNode right) {
        if (left == null || right == null) return;

        while (left != null && right != null) {
            ListNode tmp = right.next;
            right.next = left.next;
            left.next = right;
            left = left.next.next;
            right = tmp;
        }
    }
}
