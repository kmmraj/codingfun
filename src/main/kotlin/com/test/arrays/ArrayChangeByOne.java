package com.test.arrays;
//ou are given an array of integers. On each move you are allowed to increase exactly one of its element by one. Find the minimal number of moves required to obtain a strictly increasing sequence from the input.
//
//Example
//
//For inputArray = [1, 1, 1], the output should be
//solution(inputArray) = 3.
//
//Input/Output
//
//[execution time limit] 3 seconds (java)
//
//[memory limit] 1 GB
//
//[input] array.integer inputArray
//
//Guaranteed constraints:
//3 ≤ inputArray.length ≤ 105,
//-105 ≤ inputArray[i] ≤ 105.
//
//[output] integer
//
//The minimal number of moves needed to obtain a strictly increasing sequence from inputArray.
//It's guaranteed that for the given test cases the answer always fits signed 32-bit integer type
public class ArrayChangeByOne {

    int solution(int[] inputArray) {
        //For inputArray = [1, 1, 1], the output should be
        //solution(inputArray) = 3.

        // inputArray: [-1000, 0, -2, 0]
        // [-1000,0,1,2]

        int count = 0;
        int prevVal = inputArray[0];
        for(int index = 1; index < inputArray.length; index++){
            int diff;
            if(inputArray[index] > prevVal){
                diff = 0;
            } else {
                diff = prevVal - inputArray[index] + 1;
            }

            count = count + diff;
            prevVal = inputArray[index] + diff;
        }
        return count;
    }

}
