package com.thenullproject.algorithms.arrays;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// Reshape an array. Problem 566
public class ReshapeArray {

    public static void main(String[] args) {
        int[][] intMatrix = new int[][] {{3, 5, 3}, {3, 4, 10}};
        int[][] reshaped = matrixReshape(intMatrix, 3, 2);

        System.out.println("[" + Arrays.stream(reshaped).map(Arrays::toString).collect(Collectors.joining(", ")) + "]");
    }

    public static int[][] matrixReshape(int[][] mat, int r, int c) {

        int m = mat.length;
        int n = mat[0].length;

        if((r * c) != (m * n) || (r == m && c == n))
            return mat;

        int[][] result = new int[r][c];

        int insertI = 0;
        int insertJ = 0;
        for (int[] ints : mat) {
            for (int j = 0; j < n; j++) {
                result[insertI][insertJ] = ints[j];
                if (++insertJ == c) {
                    insertJ = 0;
                    insertI++;
                }
            }
        }

        return result;
    }
}
