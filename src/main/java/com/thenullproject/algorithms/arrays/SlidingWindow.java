package com.thenullproject.algorithms.arrays;

import java.util.ArrayList;
import java.util.List;

// Collections of sliding window problems
public class SlidingWindow {

    public static void main(String[] args) {

        // n = number of items
        // k = window size

        int[] arr = new int[] { 5, 7, 1, 6, 4, 3, 6 };
        int k = 3;
        int largestSum = findLargestSumOfKConsecutiveElements(arr, k);
        System.out.println("Largest sum is " + largestSum);

        String s = "hello world", t = "wld";
        System.out.println("Minimum substring is " + minWindow(s, t));

    }

    // problem 76
    // (Note that though this works, it actually exceeded the time limit on LeetCode. This implementation can be improved by using a HashMap containing a count for each letter occurrence inside the moving window).
    private static String minWindow(String s, String t) {
        int m = s.length(), n = t.length();
        if(n > m)
            return "";

        int p1 = 0, p2 = 0;

        String tt = t;
        List<Character> rl = new ArrayList<>(); // refactor to queue
        String ss = "";
        String ssTemp;

        while(p2 < m) {
            char c = s.charAt(p2);
            if(t.indexOf(c) != -1) { // character match
                rl.add(c);

                if(tt.indexOf(c) != -1)
                    tt = tt.replaceFirst(String.valueOf(c), "");

                if(tt.equals("")) {
                    // move p1 pointer up
                    do {
                        c = s.charAt(p1++);
                    } while(!rl.remove(Character.valueOf(c)) || listContainsAll(rl, t));

                    ssTemp = s.substring(p1 - 1, p2 + 1);
                    if(ss.equals("") || ssTemp.length() < ss.length())
                        ss = ssTemp;

                    tt = String.valueOf(s.charAt(p1 - 1));
                }
            }
            p2++;
        }

        return ss;
    }

    private static boolean listContainsAll(List<Character> l, String t) {
        for(char c : l) {
            t = t.replaceFirst(String.valueOf(c), "");
            if(t.equals(""))
                return true;
        }
        return false;
    }

    private static int findLargestSumOfKConsecutiveElements(int[] arr, int k) {

        int n = arr.length;
        int rollingSum = 0;
        int max = 0;

        // take first sum
        for(int i = 0; i < k; i++)
            rollingSum += arr[i];

        for(int i = 0; i < n - k; i++) {
            int sub = arr[i];
            int add = arr[i + k];
            rollingSum -= sub;
            rollingSum += add;
            max = Math.max(max, rollingSum);
        }

        return max;

    }

}