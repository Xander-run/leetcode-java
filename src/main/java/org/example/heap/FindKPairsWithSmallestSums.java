package org.example.heap;

import java.util.*;

public class FindKPairsWithSmallestSums {
    public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int len1 = nums1.length, len2 = nums2.length;
        List<List<Integer>> ret = new LinkedList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[0] + o[1]));

        for (int i = 0, round = Math.min(len1, k); i < round; i++) {
            pq.add(new int[]{nums1[i], nums2[0], i, 0});
        }

        for (int i = 0; i < k; i++) {
            if (pq.isEmpty()) break;
            int[] top = pq.poll();
            ret.add(Arrays.asList(top[0], top[1]));
            int r = top[2], c = top[3];
            if (c < len2 - 1) {
                pq.add(new int[]{nums1[r], nums2[c + 1], r, c + 1});
            }
        }

        return ret;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,1,2};
        int[] nums2 = {1,2,3};
        int k = 10;
        List<List<Integer>> ret = kSmallestPairs(nums1, nums2, k);
    }
}
