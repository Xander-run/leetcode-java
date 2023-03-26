package org.example.linkedlist;

import org.example.util.ListNode;

/**
 * 142. Linked List Cycle II
 * https://leetcode.com/problems/linked-list-cycle-ii/
 *
 * 2(F + A) = F + A + B + A
 * F = B
 */
public class LinkedListCycleII {

    public static ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }
}
