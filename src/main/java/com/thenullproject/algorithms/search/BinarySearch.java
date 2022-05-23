package com.thenullproject.algorithms.search;

// O (log n) but assumes the list of elements is sorted
public class BinarySearch {

    public static void main(String[] args) {

        // The number of comparisons can be estimated using:
        // [log2𝑛]+1
        // where 𝑛 is the number of elements in your search space.
        // e.g. n = 100, comparisons = log2(100) + 1 = ~7 (worst case)

        int[] arr = new int[] {51, 75, 99, 123, 147, 171, 195, 219, 243, 267};
        int i = indexOf(arr, 51);
        System.out.println("Index is " + i + ".");
    }

    private static int indexOf(int[] arr, int find) {

        int iter = 0;
        int start = 0;
        int end = arr.length-1;
        int i;

        do {
            iter++;
            i = start + (end - start) / 2;

            if (arr[i] == find) {
                System.out.println("Comparisons: " + iter);
                return i;
            } else if(arr[i] > find) {
                end = i - 1;
            } else { // arr[i] < find
                start = i + 1;
            }

        } while(start <= end);

        System.out.println("Comparisons: " + iter);
        return -1;
    }

    public static int searchInsert(int[] nums, int target) {

        int start = 0, end = nums.length - 1;
        int i;
        int val;

        do {
            i = start + (end - start) / 2;
            val = nums[i];

            if(val == target) {
                return i;
            } else if(val > target) {
                end = i - 1;
            } else { // val < target
                start = i + 1;
            }

        } while(start <= end);

        return start;

    }
}
