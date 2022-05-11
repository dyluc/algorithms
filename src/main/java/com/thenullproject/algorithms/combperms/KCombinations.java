package com.thenullproject.algorithms.combperms;

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
 * (See resources/diagrams/KCombinations.png)
 */
public class KCombinations {

    public static void main(String[] args) {

        combine(5, 3);
    }

    private static List<List<Integer>> combine(int n, int k) {

        List<List<Integer>> all = new LinkedList<>();

        backtrack(1, new LinkedList<>(), all, n, k);

        System.out.println("Number of Combinations: " + all.size());

        for (List<Integer> list : all) {
            System.out.println(list);
        }

        return all;

    }

    private static void backtrack(int begin, LinkedList<Integer> comb, List<List<Integer>> all, int n, int k) {
        if(comb.size() == k) {
            all.add(new LinkedList<>(comb));
            return;
        }

        for (int i = begin; i <= n; i++) {
            comb.add(i);
            backtrack(i+1, comb, all, n, k);
            comb.removeLast();
        }
    }


}
