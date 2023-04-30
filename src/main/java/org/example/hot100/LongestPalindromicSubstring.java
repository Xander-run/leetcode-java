package org.example.hot100;

public class LongestPalindromicSubstring {


    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
    }

    public static String longestPalindrome(String s) {
        int n = s.length();
        int maxLen = 0;
        int maxLeft = 0, maxRight = 0;
        boolean[][] dp = new boolean[n][n];
        for (int row = n - 1; row >= 0; row--) {
            for (int col = n - 1; col >= row; col--) {
                boolean isPalindrome = isPalindrome(row, col, s, dp);
                dp[row][col] = isPalindrome;
                if (isPalindrome) {
                    if (col - row + 1 > maxLen) {
                        maxLeft = row;
                        maxRight = col;
                        maxLen = col - row + 1;
                    }
                }
            }
        }
        return s.substring(maxLeft, maxRight + 1);
    }

    private static boolean isPalindrome(int left, int right, String s, boolean[][]dp) {
        if (left == right) {
            return true;
        } else {
            boolean leftEqualsRight = s.charAt(left) == s.charAt(right);
            if (right - left <= 2) {
                return leftEqualsRight;
            } else {
                return leftEqualsRight && dp[left + 1][right - 1];
            }
        }
    }
}
