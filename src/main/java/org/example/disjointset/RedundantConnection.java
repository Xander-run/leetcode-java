package org.example.disjointset;

import java.util.Arrays;

public class RedundantConnection {

    public static int[] findRedundantConnection(int[][] edges) {
        if (edges == null || edges.length == 0) return (new int[0]);

        int n = edges.length;
        int[] parent = new int[n + 1];
        Arrays.fill(parent, -1);
        int [] rank = new int[n + 1];
        Arrays.fill(rank, 0);

        for (int[] edge : edges) {
            if (union(edge[0], edge[1], parent, rank)) {
                return edge;
            }
        }
        return null;
    }

    private static boolean union(int x, int y, int[] parent, int[] rank) {
        int rootX = find(x, parent);
        int rootY = find(y, parent);
        if (rootX == rootY) {
            return true;
        } else {
            if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
                rank[rootX] = rank[rootX] + 1;
            } else {
                parent[rootX] = rootY;
                rank[rootY] = rank[rootY] + 1;
            }
            return false;
        }
    }

    private static int find(int x, int[] parent) {
        if (parent[x] == -1) {
            return x;
        } else {
            parent[x] = find(parent[x], parent);
            return parent[x];
        }
    }

    public static void main(String[] args) {
        int[][] edges = new int[5][2];
        edges[0] = new int[]{1,4};
        edges[1] = new int[]{3,4};
        edges[2] = new int[]{1,3};
        edges[3] = new int[]{1,2};
        edges[4] = new int[]{4,5};
        findRedundantConnection(edges);
    }
}
