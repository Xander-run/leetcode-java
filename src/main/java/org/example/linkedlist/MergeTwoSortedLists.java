package org.example.linkedlist;

import org.example.util.ListNode;

import java.util.Objects;

/**
 * 21. Merge Two Sorted Lists
 * https://leetcode.com/problems/merge-two-sorted-lists/
 */
public class MergeTwoSortedLists {

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        ListNode ptr1 = list1, ptr2 = list2;
        ListNode tmp = null;

        while (ptr1 != null && ptr2 != null) {
            if (ptr1.val < ptr2.val) {
                tmp = ptr1;
                ptr1 = ptr1.next;

            } else {
                tmp = ptr2;
                ptr2 = ptr2.next;
            }
            tmp.next = null;
            tail.next = tmp;
            tail = tail.next;
        }

        if (ptr1 == null && ptr2 == null)
            return dummy.next;
        else
            tail.next = Objects.requireNonNullElse(ptr1, ptr2);

        return dummy.next;
    }
}
