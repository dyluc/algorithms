package com.thenullproject.algorithms;

// Problem 567
public class PermutationInString {

    public static void main(String[] args) {

        System.out.println(checkInclusion("hello", "ooolleoooleh"));
//        System.out.println(checkInclusion("ab", "eidboaoo"));


    }

    private static boolean checkInclusion(String s1, String s2) {

        int k = s1.length();
        int n = s2.length();

        if(k > n)
            return false;

        // lowercase letters (use char index ascii character 97 - 122)
        // index is 'a' % 97
        int[] occurrences = new int[26];

        for(int i = 0; i < k; i++)
            occurrences[s1.charAt(i) - 97]++;

        for(int i = 0; i <= n - k; i++) {
            int[] temp = new int[26];

            for(int j = i; j < i + k; j++) // for k times
                temp[s2.charAt(j) - 97]++;

            if(match(occurrences, temp))
                return true;
        }

        return false;

    }

    private static boolean match(int[] occurrences, int[] checkAgainst) {
        for(int i = 0; i < occurrences.length; i++) {
            if(occurrences[i] != checkAgainst[i])
                return false;
        }
        return true;
    }
}
