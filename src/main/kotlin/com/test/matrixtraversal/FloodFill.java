package com.test.matrixtraversal;

public class FloodFill {

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        boolean[][] visited = new boolean[image.length][image[0].length];
        int prevColor = image[sr][sc];
        return floodFill(image, sr, sc, color, visited,prevColor);

    }

    private int[][] floodFill(int[][] image, int sr, int sc, int color, boolean[][] visited,int prevColor) {
        if (sr < 0 || sc < 0
                || sr >= image.length || sc >= image[0].length
                || (image[sr][sc] == 0 && prevColor != 0)) {
            return image;
        }

        if (visited[sr][sc]) {
            return image;
        }

        if (image[sr][sc] != color) {
            visited[sr][sc] = true;
            image[sr][sc] = color;
            floodFill(image, sr - 1, sc, color, visited,prevColor);
            floodFill(image, sr + 1, sc, color, visited,prevColor);
            floodFill(image, sr, sc - 1, color, visited,prevColor);
            floodFill(image, sr, sc + 1, color, visited,prevColor);
        }

        return image;
    }

    public static void main(String[] args) {
        int[][] input = new int[][]{
                {1, 1, 1},
                {1, 1, 0},
                {1, 0, 1}
        };

        int[][] output = new FloodFill().floodFill(input, 1, 1, 2);
        for (int row = 0; row < output.length; row++) {
            for (int col = 0; col < output[0].length; col++) {
                System.out.printf("%2d ", output[row][col]);
            }
            System.out.println();
        }
    }
}
