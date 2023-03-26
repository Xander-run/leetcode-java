package org.example.linkedlist;

import org.example.util.ListNode;

/**
 * 82. Remove Duplicates from Sorted List II
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
 */

public class ReverseLinkedList {

    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode ptr = head;
        while (ptr != null) {
            ListNode temp = ptr.next;
            ptr.next = prev;
            prev = ptr;
            ptr = temp;
        }
        return prev;
    }
}
