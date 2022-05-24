package com.thenullproject.algorithms;

import java.util.ArrayList;
import java.util.List;

// Reverse words in a String. Problem 557
public class StringWordReversal {

    public static void main(String[] args) {
        System.out.println(reverseWords("Let's take LeetCode contest"));
    }

    public static String reverseWords(String s) {

        int i = s.length() - 1;

        StringBuilder temp = new StringBuilder();
        StringBuilder res = new StringBuilder();

        while(i >= 0) {
            if(s.charAt(i) == ' ') {
                res.insert(0, " " + temp);
                temp = new StringBuilder();
            } else
                temp.append(s.charAt(i));

            i--;
        }

        return temp.append(res).toString();
    }


}
