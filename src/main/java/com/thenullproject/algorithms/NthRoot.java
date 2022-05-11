package com.thenullproject.algorithms;

// A class to calculate the nth root of a number using a binary search (running in O(log n))
public class NthRoot {

    public static void main(String[] args) {
        System.out.println(root(3, 7)); // cubed root of 7
    }

    public static double root(int n, double a) { // x^n = a

        double start = 0, end = a;
        double x; // number we are looking for
        double res = 0; // result of calculation (should converge towards a)

        do {
            x = (start + end) / 2.0f;
            res = Math.pow(x, n);

            if(res >= a) {
                end = x;
            } else { // res < a
                start = x;
            }

        } while(Math.abs(a - res) >= .001);

        return x;

    }
}
