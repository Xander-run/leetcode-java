package org.example.sort;

import java.util.Arrays;

public class SortAnArray {

    public int[] sortArray(int[] nums) {
        return sort(nums);
    }

    public int[] sort(int[] input) {
        if (input.length <= 1) {
            return input;
        }
        int mid = input.length / 2;
        int[] left = sort(Arrays.copyOfRange(input, 0 , mid));
        int[] right = sort(Arrays.copyOfRange(input, mid, input.length));
        return merge(left, right, input);
    }

    private int[] merge(int[] left, int[] right, int[] input) {
        int indexL = 0, indexR = 0, indexI = 0;
        while (indexL < left.length || indexR < right.length) {
            if (indexL >= left.length) {
                input[indexI] = right[indexR];
                indexR++;
            } else if (indexR >= right.length) {
                input[indexI] = left[indexL];
                indexL++;
            } else {
                if (left[indexL] < right[indexR]) {
                    input[indexI] = left[indexL];
                    indexL++;
                } else {
                    input[indexI] = right[indexR];
                    indexR++;
                }
            }
            indexI++;
        }
        return input;
    }
}
