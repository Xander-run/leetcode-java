package org.example.dp;

public class JumpGame {

    public boolean canJump(int[] nums) {
        int leastIndex = nums.length - 1;
        for (int index = leastIndex - 1; index >= 0; index--) {
            if ((nums[index] + index) >= leastIndex)
                leastIndex = index;
        }
        return leastIndex == 0;
    }
}
