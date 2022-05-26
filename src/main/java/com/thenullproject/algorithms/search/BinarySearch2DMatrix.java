package com.thenullproject.algorithms.search;

// Binary search on an ordered 2D array
public class BinarySearch2DMatrix {

    public static void main(String[] args) {

        /*

        [[1,  3,  5,  7],
         [10, 11, 16, 20],
         [23, 30, 34, 60]]

         [1, 10, 23]

         */

        int[][] matrix = new int[][] {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target = 3;

        System.out.println(searchMatrix(matrix, target));

    }

    private static boolean searchMatrix(int[][] matrix, int target) {

        // vars
        int m = matrix.length;
        int n = matrix[0].length;

        // find row
        int start = 0, end = m - 1;
        int i;

        do {
            i = start + (end - start) / 2;
            if(target >= matrix[i][0] && target <= matrix[i][n - 1]) {
                return exists(matrix[i], target);
            } else if(matrix[i][0] > target) {
                end = i - 1;
            } else {
                start = i + 1;
            }
        } while(start <= end);

        return false;
    }

    private static boolean exists(int[] arr, int find) {

        int start = 0, end = arr.length-1;
        int i;

        do {
            i = start + (end - start) / 2;
            if (arr[i] == find) {
                return true;
            } else if(arr[i] > find) {
                end = i - 1;
            } else { // arr[i] < find
                start = i + 1;
            }
        } while(start <= end);

        return false;
    }


}
