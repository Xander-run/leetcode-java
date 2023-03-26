package org.example.linkedlist;

import org.example.util.ListNode;

/**
 * 148. Sort List
 * https://leetcode.com/problems/sort-list/
 */
public class SortList {

    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        } else {
            ListNode midNode = findMidNode(head);
            ListNode leftHead = head, rightHead = midNode.next;
            midNode.next = null;
            return merge(sortList(leftHead), sortList(rightHead));
        }
    }

    public static ListNode findMidNode(ListNode head) {
        ListNode ptr = head;
        int n = 0;
        while (ptr != null) {
            n++;
            ptr = ptr.next;
        }
        ptr = head;
        for (int i = 0; i < (n - 1) / 2 /* return the n/2 - 1 th item if n is even*/ ; i++) {
            ptr = ptr.next;
        }
        return  ptr;
    }

    public static ListNode merge(ListNode left, ListNode right) {
        if (left == null) return right;
        if (right == null) return  left;

        ListNode dummy = new ListNode(), lPtr = left, rPtr = right, tail = dummy;

        while (lPtr != null && rPtr != null) {
            if (lPtr.val < rPtr.val) {
                tail.next = lPtr;
                lPtr = lPtr.next;
            } else {
                tail.next = rPtr;
                rPtr = rPtr.next;
            }
            tail = tail.next;
        }

        if (lPtr != null) {
            tail.next = lPtr;
        } else {
            tail.next = rPtr;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        sortList(ListNode.constructLinkedList("[4,2,1,3]"));
    }
}
