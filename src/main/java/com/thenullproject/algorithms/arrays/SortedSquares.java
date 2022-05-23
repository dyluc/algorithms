package com.thenullproject.algorithms.arrays;

import java.util.Arrays;

// Square and sort, problem 977
public class SortedSquares {

    public static void main(String[] args) {

        int[] nums = new int[]{-7, -5, -5, -5, -3, -2, 0, 0, 0, 1, 1, 2, 2, 2, 4, 7};

        int[] ints = sortedSquares(nums);
        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(ints));

    }

    public static int[] sortedSquares(int[] nums) {
        int[] res = new int[nums.length];

        int last = nums.length - 1;

        // find index of first positive and last negative
        int p1 = last, p2 = last + 1; // p1 is neg, p2 is pos
        for(int i = 0; i < nums.length; i++)
            if(nums[i] >= 0) {
                p2 = i;
                p1 = i - 1;
                break;
            }

        int i = 0; // stores next insert index
        int next; // stores next index of nums
        while(p1 >= 0 || p2 <= last) {

            if(p1 < 0) // the rest are pos
                next = p2++;
            else if(p2 > last) // the rest are neg
                next = p1--;
            else {
                if(Math.min(Math.abs(nums[p1]), nums[p2]) != nums[p2])
                    next = p1--; // next should be nums[p1]
                else
                    next = p2++; // next should be nums[p2]
            }

            // add number to list
            res[i] = (int) Math.pow(nums[next], 2);
            i++;
        }

        return res;
    }
}
