package org.example.stack;

import java.util.Stack;

public class LargestRectangleInHistogram {

    public static int largestRectangleArea(int[] heights) {
        int maxArea = 0;

        if (heights == null) return 0;

        Stack<Integer> incrBarIndex = new Stack<>();
        int i = 0;
        while (i < heights.length) {
            if (incrBarIndex.isEmpty() || heights[incrBarIndex.peek()] <= heights[i]) {
                incrBarIndex.push(i);
                i++;
            } else {
                int minBarIndex = incrBarIndex.pop();
                int width = incrBarIndex.isEmpty()? i : i - incrBarIndex.peek() - 1;
                int height = heights[minBarIndex];
                maxArea = Math.max(maxArea, width * height);
            }
        }

        while (!incrBarIndex.isEmpty()) {
            int minBarIndex = incrBarIndex.pop();
            int width = incrBarIndex.isEmpty() ? heights.length : heights.length - incrBarIndex.peek() - 1;
            int height = heights[minBarIndex];
            maxArea = Math.max(maxArea, width * height);
        }

        return maxArea;
    }

    public static void main(String[] args) {
        int[] heights = {2, 1, 5 ,6, 2, 4};
        System.out.println(largestRectangleArea(heights));
    }
}
