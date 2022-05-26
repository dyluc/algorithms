package com.thenullproject.algorithms.arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class SudokuValidator {

    public static void main(String[] args) {

        char[][] sudoku1 = new char[][] {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        
        char[][] sudoku2 = new char[][] {
                {'8','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };

        System.out.println(isValidSudoku(sudoku1));
        System.out.println(isValidSudoku(sudoku2));

    }



    private static boolean isValidSudoku(char[][] board) {

        // This is an easy solve if we use the intuition that every cell value must be unique to the current row, the
        // current column as well as the current sub box. So, all we need to do is generate unique values for those
        // three for each iteration, and add them to a single set to check if they are unique.

        Set<String> set = new HashSet<>();

        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                char c = board[i][j];
                if(c != '.') {
                    if(
                        !set.add(c + " found in row " + i) ||
                        !set.add(c + " found in column " + j) ||
                        !set.add(c + " found in sub box " + i/3 + ", " + j/3)
                    )
                        return false;
                }
            }
        }

        return true;

    }
}
