package org.example.stack;

public class NumberOfIslands {

    private static int rowNum;
    private static int colNum;

    public static int numIslands(char[][] grid) {
        rowNum = grid.length;
        if (rowNum == 0) return 0;
        colNum = grid[0].length;
        if (colNum == 0) return 0;
        int count = 0;
        for (int i = 0; i < rowNum; i++) {
            for (int j = 0; j < colNum; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    bfsMark(grid, i ,j);
                }
            }
        }
        return count;
    }

    private static void bfsMark(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= rowNum || j >= colNum) return;
        if (grid[i][j] == '1') {
            grid[i][j] = '0';
            bfsMark(grid, i + 1, j);
            bfsMark(grid, i - 1, j);
            bfsMark(grid, i, j + 1);
            bfsMark(grid, i, j - 1);
        }
    }
}
