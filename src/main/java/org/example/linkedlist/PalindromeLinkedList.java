package org.example.linkedlist;

import org.example.util.ListNode;

import java.util.Stack;

public class PalindromeLinkedList {

    public static boolean isPalindrome(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode fast = head, slow = head;

        while (fast != null && fast.next != null) {
            stack.push(slow.val);
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast != null) slow = slow.next;

        while (slow != null) {
            if (stack.pop() != slow.val) return false;
            slow = slow.next;
        }

        return true;
    }
}
