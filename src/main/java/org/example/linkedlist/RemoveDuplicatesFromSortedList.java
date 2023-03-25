package org.example.linkedlist;

import org.example.util.ListNode;

/**
 * 83. Remove Duplicates from Sorted List
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list/
 */

public class RemoveDuplicatesFromSortedList {

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode ptr = head;

        while (ptr != null) {
            if (ptr.next != null) {
                if (ptr.next.val == ptr.val) {
                    ListNode newNext = ptr.next.next;
                    ptr.next.next = null;
                    ptr.next = newNext;
                    continue;
                }
            }
            ptr = ptr.next;
        }

        return head;
    }
}
