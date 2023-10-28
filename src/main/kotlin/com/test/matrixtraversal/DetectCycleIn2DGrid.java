package com.test.matrixtraversal;

// https://leetcode.com/problems/detect-cycles-in-2d-grid/
public class DetectCycleIn2DGrid {
    public boolean containsCycle(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        boolean containsCycle = false;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (visited[row][col])
                    continue;
                containsCycle = containsCycle(grid, visited, row, col, grid[row][col], 0);
                if (containsCycle)
                    return true;
            }
        }
        return containsCycle;
    }

    // prev Dir 0 - start, 1 - up, 2 - down, 3 - left, 4 - right
    private boolean containsCycle(char[][] grid, boolean[][] visited, int row, int col, char origChar, int prevDir) {

        //                {'a', 'a', 'a', 'a'},
        //                {'a', 'b', 'b', 'a'},
        //                {'a', 'b', 'b', 'a'},
        //                {'a', 'a', 'a', 'a'}

        //                {'a', 'b', 'b'},
        //                {'b', 'z', 'b'},
        //                {'b', 'b', 'a'}
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] != origChar) {
            return false;
        }
        if (visited[row][col]){
            return true;
        }
        visited[row][col] = true;
        boolean containsCycle = prevDir != 4 && containsCycle(grid, visited, row - 1, col, origChar, 3);
        if (containsCycle)
            return true;
        containsCycle = prevDir!=3 && containsCycle(grid, visited, row + 1, col, origChar,4);
        if (containsCycle)
            return true;
        containsCycle = prevDir!=1 && containsCycle(grid, visited, row, col - 1, origChar, 2);
        if (containsCycle)
            return true;
        containsCycle = prevDir!=2 && containsCycle(grid, visited, row, col + 1, origChar, 1);
        return containsCycle;
    }

    public static void main(String[] args) {
        char[][] input = new char[][]{
                {'a', 'a', 'a', 'a'},
                {'a', 'b', 'b', 'a'},
                {'a', 'b', 'b', 'a'},
                {'a', 'a', 'a', 'a'}
        };

        System.out.println("Contains cycle: " + new DetectCycleIn2DGrid().containsCycle(input));

        input = new char[][]{
                {'c', 'c', 'c', 'a'},
                {'c', 'd', 'c', 'c'},
                {'c', 'c', 'e', 'c'},
                {'f', 'c', 'c', 'c'}
        };
        System.out.println("Contains cycle: " + new DetectCycleIn2DGrid().containsCycle(input));

        //[["a","b","b"],["b","z","b"],["b","b","a"]]
        input = new char[][]{
                {'a', 'b', 'b'},
                {'b', 'z', 'b'},
                {'b', 'b', 'a'}
        };
        System.out.println("Contains cycle: " + new DetectCycleIn2DGrid().containsCycle(input));
    }
}
