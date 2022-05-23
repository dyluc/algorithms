package com.thenullproject.algorithms.arrays;

// find the max profit of an array of numbers representing stock prices (best time to buy and sell, problem 121).
public class MaxProfit {

    public static void main(String[] args) {
        int[] prices = new int[] {7,6,4,3,1};
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {

        // what is the max profit if this is the selling point?

        // O(n) in time complexity, only need to pass through the array once
        // O(1) in space complexity

        int min = -1;
        int maxProfit = 0;

        for (int price : prices) {
            min = min == -1 ? price : Math.min(min, price);

            // calculate profit
            if (price > min)
                maxProfit = Math.max(maxProfit, price - min);
        }

        return maxProfit;
    }

}
