package org.example.dp;

import java.util.Arrays;
import java.util.List;

public class Triangle {

    public static int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.get(triangle.size() - 1).size();
        int[][] memo = new int[n][n];
        memo[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0)
                    memo[i][0] = memo[i - 1][0];
                else if (j == i)
                    memo[i][j] = memo[i - 1][j - 1];
                else
                    memo[i][j] = Math.min(memo[i - 1][j - 1], memo[i - 1][j]);
                memo[i][j] += triangle.get(i).get(j);
            }
        }
        return Arrays.stream(memo[n - 1]).min().getAsInt();
    }
}
