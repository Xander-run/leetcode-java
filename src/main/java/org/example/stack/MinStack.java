package org.example.stack;

import java.util.Map;

public class MinStack {

    private static class Node {

        int val;
        int currentMin;
        Node next;

        public Node(int val, int currentMin, Node next) {
            this.val = val;
            this.currentMin = currentMin;
            this.next = next;
        }
    }

    Node head = null;

    public MinStack() {

    }

    public void push(int val) {
        if (head == null)
            head = new Node(val, val, null);
        else
            head = new Node(val, Math.min(head.currentMin, val), head);
    }

    public void pop() {
        if (head == null)
            return;
        else
            head = head.next;
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return head.currentMin;
    }
}
