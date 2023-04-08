package org.example.heap;

import java.util.PriorityQueue;

public class KthLargestElementInAStream {

    public class KthLargest {

        private PriorityQueue<Integer> pq;

        private int size;

        public KthLargest(int k, int[] nums) {
            pq = new PriorityQueue<>();
            size = k;
            for (int num : nums) {
                add(num);
            }
        }

        public int add(int val) {
            if (pq.size() < size) {
                pq.add(val);
            } else if (val > pq.peek()) {
                pq.poll();
                pq.add(val);
            }
            return pq.peek();
        }
    }
}
