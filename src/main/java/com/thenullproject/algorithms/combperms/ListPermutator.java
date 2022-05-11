package com.thenullproject.algorithms.combperms;

public class ListPermutator {

    public static void main(String[] args) {
        new ListPermutator().computePermutations();
    }

    public void computePermutations() {
        char a[] = "hil".toCharArray();
        permutations(a, 0, a.length);
    }

    private void permutations(char[] a, int start, int end) {

        // base case
        if(start == end) {
            System.out.println(a);
            return;
        }

        // swap items
        for(int x = start; x < end; x++) {
            swap(a, start, x);
            permutations(a, start + 1, end);
            swap(a, start, x);
        }
    }

    private void swap(char[] a, int i, int x) {
        char t = a[i];
        a[i] = a[x];
        a[x] = t;
    }
}
