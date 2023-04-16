package org.example.sort;

import java.util.Arrays;

public class MergeSort implements Sorter{

    @Override
    public <T extends Comparable<T>> T[] sort(T[] input) {
        if (input.length <= 1) {
            return input;
        }
        int mid = input.length / 2;
        T[] left = sort(Arrays.copyOfRange(input, 0 , mid));
        T[] right = sort(Arrays.copyOfRange(input, mid, input.length));
        return merge(left, right, input);
    }

    private <T extends Comparable<T>> T[] merge(T[] left, T[] right, T[] input) {
        int indexL = 0, indexR = 0, indexI = 0;
        while (indexL < left.length || indexR < right.length) {
            if (indexL >= left.length) {
                input[indexI] = right[indexR];
                indexR++;
            } else if (indexR >= right.length) {
                input[indexI] = left[indexL];
                indexL++;
            } else {
                if (left[indexL].compareTo(right[indexR]) < 0) {
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
