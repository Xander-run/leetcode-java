package org.example.dp;

public class PalindromePartitioningII {

    public static int minCut(String s) {
        char[] chars = s.toCharArray();
        boolean[][] isPal = new boolean[chars.length][chars.length];
        int[] minCutStartAt = new int[chars.length];
        for (int i = chars.length - 1; i >= 0; i--) {
            minCutStartAt[i] = chars.length - i - 1;
            for (int j = i; j < chars.length; j++) {
                if (chars[i] == chars[j] && (j - i <= 2 || isPal[i + 1][j - 1])) {
                    isPal[i][j] = true;
                    if (j == chars.length - 1)
                        minCutStartAt[i] = 0;
                    else
                        minCutStartAt[i] = Math.min(minCutStartAt[i], minCutStartAt[j + 1] + 1);
                }
            }
        }
        return minCutStartAt[0];
    }

    public static void main(String[] args) {
        System.out.println(minCut("aab"));
    }
}
