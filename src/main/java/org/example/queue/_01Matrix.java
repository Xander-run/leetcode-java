package org.example.queue;

import java.util.LinkedList;
import java.util.Queue;

public class _01Matrix {

    private static final int[] dirs = {0, 1, 0, -1, 0};
    private static final int dirNum = 4;

    public static int[][] updateMatrix(int[][] mat) {
        if (mat == null || mat.length == 0 || mat[0].length == 0) return mat;

        int m = mat.length, n = mat[0].length;
        int[][] ret = new int[m][n];

        Queue<int[]> queue = new LinkedList<>();

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (mat[r][c] == 0) {
                    ret[r][c] = 0;
                    queue.offer(new int[]{r, c});
                } else {
                    ret[r][c] = -1;
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] pair = queue.poll();
            int r = pair[0], c = pair[1];
            for (int i = 0; i < dirNum; i++) {
                int nr = r + dirs[i], nc = c + dirs[i + 1];
                if (nc < 0 || nc == n || nr < 0 || nr == m || ret[nr][nc] != -1) continue;
                ret[nr][nc] = ret[r][c] + 1;
                queue.offer(new int[]{nr, nc});
            }
        }

        return ret;
    }

    public static void main(String[] args) {
        int[][] mat = new int[10][10];
        mat[0] = new int[]{1,0,1,1,0,0,1,0,0,1};
        mat[1] = new int[]{0,1,1,0,1,0,1,0,1,1};
        mat[2] = new int[]{0,0,1,0,1,0,0,1,0,0};
        mat[3] = new int[]{1,0,1,0,1,1,1,1,1,1};
        mat[4] = new int[]{0,1,0,1,1,0,0,0,0,1};
        mat[5] = new int[]{0,0,1,0,1,1,1,0,1,0};
        mat[6] = new int[]{0,1,0,1,0,1,0,0,1,1};
        mat[7] = new int[]{1,0,0,0,1,1,1,1,0,1};
        mat[8] = new int[]{1,1,1,1,1,1,1,0,1,0};
        mat[9] = new int[]{1,1,1,1,0,1,0,0,1,1};
        int[][] ret = updateMatrix(mat);
    }
}
