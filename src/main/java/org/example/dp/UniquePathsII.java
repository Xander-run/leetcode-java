package org.example.dp;

import java.util.Arrays;

public class UniquePathsII {

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        final int m = obstacleGrid.length;
        final int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], 0);
        }

        for (int i = 0; i < n; i++) {
            if (obstacleGrid[0][i] == 1)
                break;
            dp[0][i] = 1;
        }

        for (int j = 0; j < m; j++) {
            if (obstacleGrid[j][0] == 1)
                break;
            dp[j][0] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] != 1)
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int[][] grid = new int[2][2];
        grid[0] = new int[]{0, 1};
        grid[1] = new int[]{0, 0};
        System.out.println(uniquePathsWithObstacles(grid));
    }
}
