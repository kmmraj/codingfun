package com.test.matrixtraversal;
//Last night you partied a little too hard. Now there's a black and white photo of you that's about to go viral! You can't let this ruin your reputation, so you want to apply the box blur algorithm to the photo to hide its content.
//
//The pixels in the input image are represented as integers. The algorithm distorts the input image in the following way: Every pixel x in the output image has a value equal to the average value of the pixel values from the 3 × 3 square that has its center at x, including x itself. All the pixels on the border of x are then removed.
//
//Return the blurred image as an integer, with the fractions rounded down.
//
//Example
//
//For
//
//image = [[1, 1, 1],
//         [1, 7, 1],
//         [1, 1, 1]]
//the output should be solution(image) = [[1]].
//
//To get the value of the middle pixel in the input 3 × 3 square: (1 + 1 + 1 + 1 + 7 + 1 + 1 + 1 + 1) = 15 / 9 = 1.66666 = 1. The border pixels are cropped from the final result.
//
//For
//
//image = [[7, 4, 0, 1],
//         [5, 6, 2, 2],
//         [6, 10, 7, 8],
//         [1, 4, 2, 0]]
//the output should be
//
//solution(image) = [[5, 4],
//                   [4, 4]]
//There are four 3 × 3 squares in the input image, so there should be four integers in the blurred output. To get the first value: (7 + 4 + 0 + 5 + 6 + 2 + 6 + 10 + 7) = 47 / 9 = 5.2222 = 5. The other three integers are obtained the same way, then the surrounding integers are cropped from the final result.
//
//Input/Output
//
//[execution time limit] 3 seconds (java)
//
//[memory limit] 1 GB
//
//[input] array.array.integer image
//
//An image, stored as a rectangular matrix of non-negative integers.
//
//Guaranteed constraints:
//3 ≤ image.length ≤ 100,
//3 ≤ image[0].length ≤ 100,
//0 ≤ image[i][j] ≤ 255.
//
//[output] array.array.integer
//
//A blurred image represented as integers, obtained through the process in the description.
public class BoxBlur {

    int[][] solution(int[][] image) {
        int resultArrayRowLength = (image.length % 3 == 0 ? 1 : image.length % 3) + (image.length - 3);
        int resultArrayColLength = (image[0].length % 3 == 0 ? 1 : image[0].length % 3) + (image[0].length - 3);
        System.out.println("Result array is " + resultArrayRowLength + " * " + resultArrayColLength);
        int[][] result = new int[resultArrayRowLength][resultArrayColLength];
        // [[36,0,18,9],
        // [27,54,9,0],
        // [81,63,72,45]]

        for (int indexI = 0; indexI < resultArrayRowLength; indexI++) {
            for (int indexJ = 0; indexJ < resultArrayColLength; indexJ++) {
                int tempSum = 0;
                for (int idx = indexI; idx < indexI + 3; idx++) {
                    for (int jdx = indexJ; jdx < indexJ + 3; jdx++) {
                        tempSum = tempSum + image[idx][jdx];
                        System.out.println("tempSum is " + tempSum);
                    }
                }
                result[indexI][indexJ] = tempSum / 9;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        BoxBlur boxBlur = new BoxBlur();
        int[][] image = {{1, 1, 1},
                {1, 7, 1},
                {1, 1, 1}};
        int[][] result = boxBlur.solution(image);
        for (int indexI = 0; indexI < result.length; indexI++) {
            for (int indexJ = 0; indexJ < result[0].length; indexJ++) {
                System.out.print(result[indexI][indexJ] + " ");
            }
            System.out.println();
        }

        int[][] image2 = {{7, 4, 0, 1},
                {5, 6, 2, 2},
                {6, 10, 7, 8},
                {1, 4, 2, 0}};
        result = boxBlur.solution(image2);
        for (int indexI = 0; indexI < result.length; indexI++) {
            for (int indexJ = 0; indexJ < result[0].length; indexJ++) {
                System.out.print(result[indexI][indexJ] + " ");
            }
            System.out.println();
        }

        int[][] image3 = {{36,0,18,9},
                {27,54,9,0},
                {81,63,72,45}};
        result = boxBlur.solution(image3);
        for (int indexI = 0; indexI < result.length; indexI++) {
            for (int indexJ = 0; indexJ < result[0].length; indexJ++) {
                System.out.print(result[indexI][indexJ] + " ");
            }
            System.out.println();
        }

        int[][] image4 = {{36}};
        result = boxBlur.solution(image4);
        for (int indexI = 0; indexI < result.length; indexI++) {
            for (int indexJ = 0; indexJ < result[0].length; indexJ++) {
                System.out.print(result[indexI][indexJ] + " ");
            }
            System.out.println();
        }

        int[][] image5 = {{7, 4, 0, 1},
                {5, 6, 2, 2},
                {6, 10, 7, 8},
                {1, 4, 2, 0}};
        result = boxBlur.solution(image5);
        for (int indexI = 0; indexI < result.length; indexI++) {
            for (int indexJ = 0; indexJ < result[0].length; indexJ++) {
                System.out.print(result[indexI][indexJ] + " ");
            }
            System.out.println();
        }

        int[][] image6 =  {{7, 4, 0, 1},
            {5, 6, 2, 2},
            {6, 10, 7},
            {1, 4, 2, 0}};
        result = boxBlur.solution(image6);
        for (int indexI = 0; indexI < result.length; indexI++) {
            for (int indexJ = 0; indexJ < result[0].length; indexJ++) {
                System.out.print(result[indexI][indexJ] + " ");
            }
            System.out.println();
        }
    }

}
