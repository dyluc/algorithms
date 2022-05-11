package com.thenullproject.algorithms.combperms;

import java.util.HashSet;
import java.util.Set;

/**
 *
 */
public class SimpleStringPermutations {

    public static void main(String[] args) {

        Set<String> permutations = new HashSet<>();
        findStringPermutations("", "Hello", permutations);
        permutations.forEach(System.out::println);

    }

    private static void findStringPermutations(String prefix, String s, Set<String> permutations) {
        // get string length
        int length = s.length();

        // base case
        if(length == 0) {
            permutations.add(prefix);
            return;
        }

        for(int i = 0; i < length; i++) {
            findStringPermutations(
                    prefix + s.charAt(i),
                    s.substring(0, i) + s.substring(i + 1),
                    permutations);
        }
    }

}
