package com.thenullproject.algorithms.combperms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListPermutator {

    public static void main(String[] args) {
        Integer[] arr = new Integer[] {1, 2, 3, 4, 5, 6};
        List<Integer[]> permutations = new ArrayList<>();

        // Formula to calculate permutations (n = number of objects, r = number of selected objects)
        //    n!
        // --------
        //  (n-r)!

        // e.g. [1, 4, 3, 5] n = 4, r = 4, perms = 4! = 24

        permutations(arr, permutations, 0, arr.length);
        System.out.println("Number of Permutations: " + permutations.size());
        permutations.forEach(p -> System.out.println(Arrays.toString(p)));

    }

    private static void permutations(Integer[] arr, List<Integer[]> permutations, int start, int end) {

        // base case
        if(start == end) {
            permutations.add(arr.clone());
            return;
        }

        // build permutation
        for(int i = start; i < end; i ++) {
            swap(arr, start, i);
            permutations(arr, permutations, start + 1, end);
            swap(arr, i, start);
        }
    }

    private static void swap(Integer[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
