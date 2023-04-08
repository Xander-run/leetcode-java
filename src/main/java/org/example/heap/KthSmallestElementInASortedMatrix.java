package org.example.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSmallestElementInASortedMatrix {
    public static int kthSmallest(int[][] matrix, int k) {

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;

        int n = matrix.length;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));

        for (int i = 0; i < Math.min(n, k); i++) {
            pq.add(new int[]{matrix[i][0], i, 0});
        }

        for (int i = 0; i < k - 1; i++) {
            int[] top = pq.poll();
            int r = top[1];
            int c = top[2];
            if (c < n - 1) {
                pq.add(new int[]{matrix[r][c + 1], r, c + 1});
            }
        }

        return pq.peek()[0];
    }
}
