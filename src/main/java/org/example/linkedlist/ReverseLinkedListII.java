package org.example.linkedlist;

import org.example.util.ListNode;

/**
 * 92. Reverse Linked List II
 * https://leetcode.com/problems/reverse-linked-list-ii/
 */

public class ReverseLinkedListII {

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0, head);
        ListNode nodeBeforeHead = dummy;

        for (int i = 0; i < left - 1; i++) {
            nodeBeforeHead = nodeBeforeHead.next;
        }

        ListNode rTail = nodeBeforeHead.next;
        for (int i = 0; i < right - left; i++) {
            ListNode newHead = rTail.next;
            ListNode prevHead = nodeBeforeHead.next;
            rTail.next = rTail.next.next;
            nodeBeforeHead.next = newHead;
            newHead.next = prevHead;
        }

        return dummy.next;
    }
}
