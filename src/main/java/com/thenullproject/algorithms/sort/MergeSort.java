package com.thenullproject.algorithms.sort;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        // [7, 2, 3, 5, 6, 1, 4] -> [1, 2, 3, 4, 5, 6, 7]
        int[] sorted = new MergeSort().sort(new int[]{7, 2, 3, 5, 6, 1, 4});
        System.out.println(Arrays.toString(sorted));
    }

    private int[] sort(int[] arr) {
        int l = arr.length;

        if(l == 1)
            return arr;

        // split
        int[] left = sort(Arrays.copyOfRange(arr, 0, l/2));
        int[] right = sort(Arrays.copyOfRange(arr, l/2, l));

        return merge(left, right);

    }

    private int[] merge(int[] left, int[] right) {

        System.out.println("Left array: " + Arrays.toString(left));
        System.out.println("Right array: " + Arrays.toString(right));

        int p1 = 0, p2 = 0;
        int m = left.length, n = right.length;
        int[] merged = new int[m + n];

        for(int i = 0; i < m + n; i++) {
            if(p1 >= m) { // add all remaining in right
                merged[i] = right[p2++];
            } else if(p2 >= n) { // add all remaining in left
                merged[i] = left[p1++];
            } else if(left[p1] < right[p2]) { // add left
                merged[i] = left[p1++];
            } else {
                merged[i] = right[p2++]; // add right
            }
        }

        return merged;
    }



}
