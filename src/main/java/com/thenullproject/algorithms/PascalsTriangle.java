package com.thenullproject.algorithms;

import java.util.ArrayList;
import java.util.List;

// Pascals Triangle, problem 118.
public class PascalsTriangle {

    public static void main(String[] args) {
/*
            1
           1 1
          1 2 1
         1 3 3 1
        1 4 6 4 1

        numRows = 5
 */
        System.out.println(generate(5));
    }


    private static List<List<Integer>> generate(int current) { // list, 5

        // create current row
        List<Integer> l = new ArrayList<>();

        // base case
        if(current == 1) {
            List<List<Integer>> ll = new ArrayList<>();
            l.add(1);
            ll.add(l);
            return ll;
        }

        // populate previous row
        List<List<Integer>> ll = generate(current - 1);
        List<Integer> prev = ll.get(current - 2);

        // populate current row
        l.add(1);
        for(int i = 1; i < current - 1; i++) {
            int sum = prev.get(i - 1) + prev.get(i);
            l.add(sum);
        }
        l.add(1);

        ll.add(l);

        return ll;

    }
}
