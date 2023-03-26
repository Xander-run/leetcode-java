package org.example.linkedlist;

import org.example.util.Node;

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer {

    public static Node copyRandomList0(Node head) {
        Node ptr = head;
        Node dummy = new Node(0);
        Node tail = dummy;
        Map<Node, Node> origin2copy = new HashMap<>();
        while (ptr != null) {
            tail.next = new Node(ptr.val);
            origin2copy.put(ptr, tail.next);
            tail = tail.next;
            ptr = ptr.next;
        }

        ptr = head;
        Node copyPtr = dummy.next;
        while (ptr != null) {
            copyPtr.random = origin2copy.get(ptr.random);
            copyPtr = copyPtr.next;
            ptr = ptr.next;
        }

        return dummy.next;
    }

    public static Node copyRandomList1(Node head) {

        if (head == null) return null;

        Node ptr = head;

        while (ptr != null) {
            Node tmp = ptr.next;
            ptr.next = new Node(ptr.val);
            ptr.next.next = tmp;
            ptr = tmp;
        }

        ptr = head;
        while (ptr != null && ptr.next != null) {
            if (ptr.random != null)
                ptr.next.random = ptr.random.next;
            ptr = ptr.next.next;
        }

        ptr = head;
        Node ret = ptr.next;
        Node newPtr = ptr.next;

        while (newPtr != null && newPtr.next != null) {
            ptr.next = ptr.next.next;
            newPtr.next = newPtr.next.next;
            ptr = ptr.next;
            newPtr = newPtr.next;
        }
        ptr.next = null;

        return ret;
    }
}
