package org.example.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class IPO {

    private static final int PROFIT = 0;
    private static final int CAPITAL = 1;

    public static int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        int[][] projects = new int[n][2];
        for (int i = 0; i < n; i++) {
            projects[i][PROFIT] = profits[i];
            projects[i][CAPITAL] = capital[i];
        }
        PriorityQueue<int[]> capitalPQ = new PriorityQueue<>((a, b) -> a[CAPITAL] - b[CAPITAL]);
        PriorityQueue<int[]> profitPQ = new PriorityQueue<>((a, b) -> b[PROFIT] - a[PROFIT]);

        capitalPQ.addAll(Arrays.asList(projects));

        int currentCapital = w;
        for (int i = 0; i < k; i++) {
            while (!capitalPQ.isEmpty() && capitalPQ.peek()[CAPITAL] <= currentCapital) {
                profitPQ.add(capitalPQ.poll());
            }
            if (!profitPQ.isEmpty()) {
                currentCapital += profitPQ.poll()[PROFIT];
            } else {
                break;
            }
        }
        return currentCapital;
    }

    public static void main(String[] args) {
        int k = 2, w = 0;
        int[] profits = new int[]{1,2,3}, capital = new int[]{0,1,1};
        System.out.println(findMaximizedCapital(k, w, profits, capital));
    }
}
