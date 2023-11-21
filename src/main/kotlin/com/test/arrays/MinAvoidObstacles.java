package com.test.arrays;

import java.util.HashSet;
import java.util.Set;

public class MinAvoidObstacles {

    int solution(int[] inputArray) {
        // inputArray: [1000, 999] => 6 => [996,1002]
        // inputArray: [1, 4, 10, 6, 2] => 7 => [0,7,14]
        // inputArray: [2, 3] => 4 => [0,4]
        // inputArray: [5, 3, 6, 7, 9] => 4 => [0,4,8,12]

        Set<Integer> obstacleSet = new HashSet<>();
        int maxObstacle = Integer.MIN_VALUE;
        for (int index = 0; index < inputArray.length; index++) {
            obstacleSet.add(inputArray[index]);
            maxObstacle = Integer.max(inputArray[index], maxObstacle);
        }

        System.out.println("maxObstacle is " + maxObstacle);

        for (int obstacle = 2; obstacle < maxObstacle; obstacle++) {
            int multiple = 1;
            int maxMutipleIdx = (maxObstacle / obstacle) + 1;
            System.out.println("maxMutipleIdx is " + maxMutipleIdx);
            boolean doesNotContain = true;
            for (multiple = 1; multiple <= maxMutipleIdx; multiple++) {
                System.out.println("obstacle * multiple is " + obstacle * multiple);
                if (obstacleSet.contains(obstacle * multiple)) {
                    System.out.println("breaking, since obstacleSet contains  " + obstacle * multiple);
                    doesNotContain = false;
                    break;
                }
            }
            if (doesNotContain) {
                return obstacle;
            }
        }
        return maxObstacle + 1; // For the edge case, if the value does not match
    }

    public static void main(String[] args) {
        MinAvoidObstacles minAvoidObstacles = new MinAvoidObstacles();
        int[] inputArray = {1000, 999};
        System.out.println(minAvoidObstacles.solution(inputArray));

        inputArray = new int[]{1, 4, 10, 6, 2};
        System.out.println(minAvoidObstacles.solution(inputArray));

        inputArray = new int[]{2, 3};
        System.out.println(minAvoidObstacles.solution(inputArray));

        inputArray = new int[]{5, 3, 6, 7, 9};
        System.out.println(minAvoidObstacles.solution(inputArray));
    }
}
