package org.example.heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MaximumPerformanceOfATeam {

    private static final long MOD = (int) (1e9 + 7);

    private static final int SPEED = 0;

    private static final int EFFICIENCY = 1;

    public static int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        // 1. 假如表现最高的team人数为i, i小于k，那么个人efficiency top-i 的人都会被选入队伍
        // 2. 否则从所有人数为k的team中选出表现最好的team
        int[][] sortedByEfficiencyEngineers = new int[n][2];
        for (int i = 0; i < n; i++) {
            sortedByEfficiencyEngineers[i][SPEED] = speed[i];
            sortedByEfficiencyEngineers[i][EFFICIENCY] = efficiency[i];
        }
        Arrays.sort(sortedByEfficiencyEngineers, (a, b) -> (b[EFFICIENCY] - a[EFFICIENCY]));
        PriorityQueue<int[]> minSpeedPq = new PriorityQueue<>(Comparator.comparingInt(o -> o[SPEED]));
        long ret = 0, speedSum = 0;
        for (int[] engineer : sortedByEfficiencyEngineers) {
            minSpeedPq.add(engineer);
            if (minSpeedPq.size() > k) {
                int[] polledEngineer = minSpeedPq.poll();
                speedSum -= polledEngineer[SPEED];
            }
            speedSum += engineer[SPEED];
            // 当前engineer为人数为k的team中efficiency最低的engineer时team最大的效率
            ret = Math.max(speedSum * engineer[EFFICIENCY], ret);
        }
        return (int) (ret % MOD);
    }

    public static void main(String[] args) {
        int n = 6;
        int[] speed = new int[]{2,10,3,1,5,8};
        int[] efficiency = new int[]{5,4,3,9,7,2};
        int k = 2;
        System.out.println(maxPerformance(6, speed, efficiency, k));
    }
}
