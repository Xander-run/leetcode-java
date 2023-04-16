package org.example.disjointset;

import java.util.Arrays;

public class UnionFind {

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
        // 1. make the tree flat
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
            // 2. find&make the tree flat
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