package org.example.linkedlist;

import org.example.util.ListNode;

/**
 * 86. Partition List
 * https://leetcode.com/problems/partition-list/
 */

public class PartitionList {

    public static ListNode partition(ListNode head, int x) {
        ListNode lPtr, lDummy, rPtr, rDummy;
        lPtr = lDummy = new ListNode(0);
        rPtr = rDummy = new ListNode(0);
        ListNode ptr = head;

        while (ptr != null) {
            ListNode tmp = ptr.next;
            if (ptr.val < x) {
                lPtr.next = ptr;
                lPtr = lPtr.next;
            } else {
                rPtr.next = ptr;
                rPtr = rPtr.next;
            }
            ptr.next = null;
            ptr = tmp;
        }

        lPtr.next =  rDummy.next;
        return lDummy.next;
    }
}
