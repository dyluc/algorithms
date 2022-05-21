package com.thenullproject.algorithms;

public class SlidingWindow {

    public static void main(String[] args) {

        // n = number of items
        // k = window size

        int[] arr = new int[] { 5, 7, 1, 6, 4, 3, 6 };
        int k = 3;
        int largestSum = findLargestSumOfKConsecutiveElements(arr, k);
        System.out.println("Largest sum is " + largestSum);

    }

    private static int findLargestSumOfKConsecutiveElements(int[] arr, int k) {

        int n = arr.length;
        int rollingSum = 0;
        int max = 0;

        // take first sum
        for(int i = 0; i < k; i++)
            rollingSum += arr[i];

        for(int i = 0; i < n - k; i++) {
            int sub = arr[i];
            int add = arr[i + k];
            rollingSum -= sub;
            rollingSum += add;
            max = Math.max(max, rollingSum);
        }

        return max;

    }

}