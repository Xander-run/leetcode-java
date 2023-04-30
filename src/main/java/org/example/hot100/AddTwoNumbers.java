package org.example.hot100;

import org.example.util.ListNode;

public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        boolean carryOver = false;
        ListNode ptr1 = l1, ptr2 = l2;
        ListNode dummy = new ListNode();
        ListNode ptr3 = dummy;
        while (ptr1 != null || ptr2 != null) {
            int num1 = 0, num2 = 0;
            if (ptr1 != null) {
                num1 = ptr1.val;
                ptr1 = ptr1.next;
            }
            if (ptr2 != null) {
                num2 = ptr2.val;
                ptr2 = ptr2.next;
            }
            int sum = num1 + num2 + (carryOver ? 1 : 0);
            if (sum >= 10) {
                sum = sum % 10;
                carryOver = true;
            } else {
                carryOver = false;
            }
            ptr3.next = new ListNode(sum, null);
            ptr3 = ptr3.next;
        }
        if (carryOver) {
            ptr3.next = new ListNode(1, null);
        }
        return dummy.next;
    }
}

