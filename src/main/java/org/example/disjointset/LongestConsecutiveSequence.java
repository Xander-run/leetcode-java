package org.example.disjointset;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestConsecutiveSequence {

    public static int longestConsecutive(int[] nums) {
        Map<Integer, Integer> num2Index = new HashMap<>();
        UnionFind uf = new UnionFind(nums.length);

//        for (int i = 0; i < nums.length; i++) {
//            num2Index.put(nums[i], i);
//        }

//        for (int i : num2Index.keySet()) {
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num2Index.containsKey(num)) {
                continue;
            }

            if (num2Index.containsKey(num - 1)) {
                uf.union(i, num2Index.get(num - 1));
            }

            if (num2Index.containsKey(num + 1)) {
                uf.union(i, num2Index.get(num + 1));
            }

            num2Index.put(num, i);
        }

        return uf.getMaxRootSize();
    }

    private static class UnionFind {

        private int size;

        private int[] parentArray;

        private int[] rootSizeArray;

        private int[] rootRankArray;

        public UnionFind(int n) {
            size = n;
            parentArray = new int[n];
            rootSizeArray = new int[n];
            rootRankArray = new int[n];
            for (int i = 0; i < n; i++) {
                parentArray[i] = i;
            }
            Arrays.fill(rootSizeArray, 1);
            Arrays.fill(rootRankArray, 0);
        }

        public void union(int index0, int index1) {
            int root0 = find(index0);
            int root1 = find(index1);
            if (root1 != root0) {
                if (rootRankArray[root0] > rootRankArray[root1]) {
                    parentArray[root1] = root0;
                    rootRankArray[root0]++;
                    rootSizeArray[root0] += rootSizeArray[root1];
                } else {
                    parentArray[root0] = root1;
                    rootRankArray[root1]++;
                    rootSizeArray[root1] += rootSizeArray[root0];
                }
            }
        }

        public int find(int index) {
            if (parentArray[index] == index) {
                return index;
            } else {
                return parentArray[index] = find(parentArray[index]);
            }
        }

        public int getMaxRootSize() {
            int ret = 0;
            for (int i = 0; i < size; i++) {
                if (parentArray[i] == i) {
                    ret = Math.max(ret, rootSizeArray[i]);
                }
            }
            return ret;
        }
    }

    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}));
    }
}
