package com.thenullproject.algorithms;

import java.util.Arrays;

// problem 242. Is t and anagram of s.
public class AnagramCheck {

    public boolean isAnagram(String s, String t) {

        int[] o1 = new int[26];
        int[] o2 = new int[26];

        for(int i = 0; i < s.length(); i++)
            o1[s.charAt(i) - 'a']++;

        for(int i = 0; i < t.length(); i++)
            o2[t.charAt(i) - 'a']++;

        return Arrays.equals(o1, o2);

    }
}
