package org.example.util;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode() {}
    public ListNode(int val) { this.val = val; }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    /**
     * "[1,2,3,3,4,4,5]"
     */
    public static ListNode constructLinkedList(String stringFormat) {
        String[] nums = stringFormat.substring(1, stringFormat.length() - 1).split(",");
        ListNode head = new ListNode(Integer.parseInt(nums[0]));
        ListNode ptr = head;
        for (int i = 1; i < nums.length; i++) {
            ptr.next = new ListNode(Integer.parseInt(nums[i]));
            ptr = ptr.next;
        }
        return head;
    }
}
