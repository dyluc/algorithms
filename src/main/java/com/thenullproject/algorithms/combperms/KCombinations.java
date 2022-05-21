package com.thenullproject.algorithms.combperms;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Combinations and permutations are common problems that require generating various sequences based
 * on a set of rules.
 *
 * Problem definition:
 * Given two integers n and k, return all possible combinations of k numbers for the range 1 through n.
 *
 * Input: n = 4, k = 2
 * Output:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 *
 * This is a type of backtracking problem, which means it will involve a type of recursive algorithm that builds a solution
 * incrementally, whilst removing parts of the solution that fail to satisfy the problem constraints.
 *
 */
public class KCombinations {

    public static void main(String[] args) {

        int n = 5, k = 4;
        List<LinkedList<Integer>> combinations = new ArrayList<>();

        // Formula to calculate combinations (n = number of objects in set, k = number of choosing objects from set)
        //     n!
        // ----------
        //  k!(n-k)!

        // An array of items [1, ..., n] find combinations of length k
        // e.g. [1, 2, 3, 4] n = 4, k = 2, combs = 4! / 4 = 6

        backtrack(new LinkedList<>(), combinations, 1, n, k);
        System.out.println("Number of Combinations: " + combinations.size());
        combinations.forEach(System.out::println);

    }

    private static void backtrack(LinkedList<Integer> comb, List<LinkedList<Integer>> combinations, int start, int n, int k) {

        // base case
        if(comb.size() == k) {
            combinations.add(new LinkedList<>(comb));
            return;
        }

        // build combination
        for(int i = start; i <= n; i++) {
            comb.add(i);
//            backtrack(comb, combinations, start + 1, n, k); // including repeats
            backtrack(comb, combinations, i + 1, n, k); // excluding repeats
            comb.removeLast();
        }
    }


}
