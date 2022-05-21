package com.thenullproject.algorithms;

// Finding the sub array with the largest sum
public class MaxSubArray {

    public static void main(String[] args) {
        int[] ints = {5,4,-1,7,8};
        System.out.println(maxSubArraySum(ints));
    }

    // returns the max sum
    public static int maxSubArraySum(int[] nums) {
        int prefix = nums[0]; // prefix sum
        int max = nums[0];
        int current;
        for(int i = 1; i < nums.length; i++) {
            current = nums[i];
            prefix = Math.max(prefix + current, current);
            max = Math.max(prefix, max);
        }
        return max;
    }

}
