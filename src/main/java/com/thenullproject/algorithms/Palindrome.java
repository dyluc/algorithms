package com.thenullproject.algorithms;

// Palindrome problems
public class Palindrome {

    public static void main(String[] args) {
        Palindrome solution = new Palindrome();
        String p = "anna";
        System.out.println(solution.countSubstrings(p));
    }


    public int countSubstrings(String s) {
        // implement
        return 0;
    }

    private boolean isPalindrome(String s, int p1, int p2) { // 0, s.length() - 1

        if(p1 == p2) // one character
            return true;

        char c1 = s.charAt(p1);
        char c2 = s.charAt(p2);

        if(p2 - p1 == 1) // two characters
            return c1 == c2;

        if(c1 != c2) // no need to check enclosing palindrome if these characters differ
            return false;

        return isPalindrome(s, p1 + 1, p2 - 1);

    }

    // Brute Force:

//    public int countSubstrings(String s) {
//        // abc
//
//        String sub;
//        boolean isPal;
//        int length = s.length();
//        int count = 0;
//
//        for(int i = 0; i < length; i++) {
//            for(int j = i; j < length; j++) {
//                sub = s.substring(i, j + 1);
//                isPal = isPalindrome(sub);
//                System.out.println(sub + " is " + (isPal ? "a" : "not a") + " palindrome");
//                if(isPal)
//                    count++;
//            }
//        }
//
//        return count;
//    }

//    private boolean isPalindrome(String s) {
//        int length = s.length();
//        if(length == 1)
//            return true;
//
//        int p1 = 0, p2 = length - 1;
//        char c1, c2;
//
//        while(p1 < p2) {
//            c1 = s.charAt(p1++);
//            c2 = s.charAt(p2--);
//            if(c1 != c2)
//                return false;
//        }
//        return true;
//    }
}
