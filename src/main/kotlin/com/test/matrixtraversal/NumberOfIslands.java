package com.test.matrixtraversal;

//https://leetcode.com/problems/number-of-islands/
public class NumberOfIslands {

    public int numIslands(char[][] grid) {

        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int count = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {

                if (visited[row][col])
                    continue;
                if ( grid[row][col] == '1') {
                    count++;
                    markVisited(grid, visited, row, col);
                }
            }
        }
        return count;
    }

    private void markVisited(char[][] grid, boolean[][] visited, int row, int col) {
        if(row < 0 || col < 0 || row >= grid.length || col >= grid[0].length){
            return;
        }
        if(visited[row][col] || grid[row][col] == '0'){
            return;
        }
        visited[row][col] = true;
        markVisited(grid, visited, row-1, col);
        markVisited(grid, visited, row+1, col);
        markVisited(grid, visited, row, col-1);
        markVisited(grid, visited, row, col+1);
    }

    public static void main(String[] args) {
        char[][] input = new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };

        System.out.println("Number of islands: " + new NumberOfIslands().numIslands(input));
    }
}
