package org.example.hot100;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> value2Index = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer index2 = value2Index.get(target - nums[i]);
            if (index2 != null) {
                return new int[]{i, index2};
            } else {
                value2Index.put(nums[i], i);
            }
        }
        return null;
    }
}
