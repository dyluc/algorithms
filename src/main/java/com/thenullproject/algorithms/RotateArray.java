package com.thenullproject.algorithms;

import java.util.Arrays;

// Rotate k items in an array using array reversal. Problem 189
public class RotateArray {

    public static void main(String[] args) {
        int[] nums = new int[] {1,2,3,4,5,6,7};
        new RotateArray().rotate(nums, 8);
        System.out.println(Arrays.toString(nums));

    }

    public void rotate(int[] nums, int k) {

        // if k exceeds nums length
        k = k % nums.length;

        flip(nums, 0, nums.length - 1);
        flip(nums, 0, k - 1);
        flip(nums, k, nums.length - 1);

    }

    private void flip(int[] arr, int start, int end) {
        int temp;
        while(start < end) {
            temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

}
