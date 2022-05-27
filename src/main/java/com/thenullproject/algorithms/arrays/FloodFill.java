package com.thenullproject.algorithms.arrays;

import java.util.Arrays;

// Problem 733
public class FloodFill {

    public static void main(String[] args) {

        int[][] image = new int[][] {{0, 0, 0}, {0, 1, 1}};
        int[][] filledImage = floodFill(image, 0, 0, 2);
        Arrays.stream(filledImage).forEach(row -> System.out.print(Arrays.toString(row)));

    }

    private static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

        int current = image[sr][sc];

        if(current != newColor) {
            image[sr][sc] = newColor;

            // check column
            if(sr - 1 >= 0 && image[sr - 1][sc] == current)
                floodFill(image, sr - 1, sc, newColor);

            if(sr + 1 < image.length && image[sr + 1][sc] == current)
                floodFill(image, sr + 1, sc, newColor);

            // check row
            if(sc - 1 >= 0 && image[sr][sc - 1] == current)
                floodFill(image, sr, sc - 1, newColor);

            if(sc + 1 < image[0].length && image[sr][sc + 1] == current)
                floodFill(image, sr, sc + 1, newColor);
        }

        return image;
    }

}
