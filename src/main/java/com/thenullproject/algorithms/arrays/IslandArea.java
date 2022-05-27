package com.thenullproject.algorithms.arrays;

// Find the max area of an island in a 2D grid. Problem 695
public class IslandArea {

    public static void main(String[] args) {

        int[][] grid = new int[][] {
                {0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}
        };

        System.out.println(maxAreaOfIsland(grid));
    }

    private static int maxAreaOfIsland(int[][] grid) {

        int currentMaxArea = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {

                if(grid[i][j] == 1)
                    currentMaxArea = Math.max(currentMaxArea, findArea(grid, i, j));
            }
        }

        return currentMaxArea;
    }


    private static int findArea(int[][] grid, int r, int c) {

        int area = 1;
        grid[r][c] = -1;

        if(r - 1 >= 0 && grid[r - 1][c] == 1)
            area += findArea(grid, r - 1, c);

        if(r + 1 < grid.length && grid[r + 1][c] == 1)
            area += findArea(grid, r + 1, c);

        // check row
        if(c - 1 >= 0 && grid[r][c - 1] == 1)
            area += findArea(grid, r, c - 1);

        if(c + 1 < grid[0].length && grid[r][c + 1] == 1)
            area += findArea(grid, r, c + 1);

        return area;

    }


}
