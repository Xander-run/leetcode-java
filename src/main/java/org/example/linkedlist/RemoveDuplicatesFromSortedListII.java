package org.example.linkedlist;

import org.example.util.ListNode;
import org.example.util.TreeNode;

/**
 * 82. Remove Duplicates from Sorted List II
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
 */

public class RemoveDuplicatesFromSortedListII {

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1, head);
        ListNode ptr = dummy;

        while (ptr != null) {
            if (ptr.next != null && ptr.next.next != null) {
                if (ptr.next.val == ptr.next.next.val) {
                    int val = ptr.next.val;
                    ListNode tempPtr = ptr.next;
                    while (tempPtr != null && tempPtr.val == val) {
                        tempPtr = tempPtr.next;
                    }
                    ptr.next = tempPtr;
                    continue;
                }
            }
            ptr = ptr.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        deleteDuplicates(ListNode.constructLinkedList("[1,2,3,3,4,4,5]"));
    }
}
