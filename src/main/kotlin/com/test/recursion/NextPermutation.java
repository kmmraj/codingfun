package com.test.recursion;
//https://leetcode.com/problems/next-permutation/description

//A permutation of an array of integers is an arrangement of its members into a sequence or linear order.
//
//For example, for arr = [1,2,3],
// the following are all the permutations of arr: [1,2,3], [1,3,2], [2, 1, 3], [2, 3, 1], [3,1,2], [3,2,1].
//The next permutation of an array of integers is the next lexicographically
// greater permutation of its integer.
// More formally, if all the permutations of the array are sorted in one container
// according to their lexicographical order,
// then the next permutation of that array is the permutation that follows it in the sorted container.
// If such arrangement is not possible,
// the array must be rearranged as the lowest possible order (i.e., sorted in ascending order).
//
//For example, the next permutation of arr = [1,2,3] is [1,3,2].
//Similarly, the next permutation of arr = [2,3,1] is [3,1,2].
//While the next permutation of arr = [3,2,1] is [1,2,3] because [3,2,1] does not have a lexicographical larger rearrangement.
//Given an array of integers nums, find the next permutation of nums.
//
//The replacement must be in place and use only constant extra memory.

import java.util.Arrays;

public class NextPermutation {

//Key Concepts:
//
//Permutation: An arrangement of elements in a specific order.
//Lexicographic Order: The way we compare words alphabetically, extending it to sequences of numbers.
//Explanation:
//
//Lexicographic Ordering:
//
//Imagine array elements as digits forming a number.
//"Smaller" permutations come before "larger" ones in a dictionary-like order.
//Next Permutation:
//
//The "next" permutation is the one immediately following the current one in lexicographic order.
//It's like finding the next word in a dictionary starting with the same letters.
//Example:
//
//Consider the array [1, 2, 3]:
//
//Permutations in lexicographic order:
//
//[1, 2, 3] (smallest)
//[1, 3, 2]
//[2, 1, 3]
//[2, 3, 1]
//[3, 1, 2]
//[3, 2, 1] (largest)
//Next permutation of [1, 2, 3]:
//
//The next permutation in the list is [1, 3, 2].
//Finding the Next Permutation:
//
//Find the longest non-increasing suffix:
//
//In [1, 2, 3], the suffix [3] is already decreasing.
//Find the pivot (just before the suffix):
//
//The pivot is 2.
//Swap the pivot with the smallest number in the suffix larger than it:
//
//Swap 2 and 3, resulting in [1, 3, 2].
//Reverse the suffix to make it increasing:
//
//The suffix is already increasing, so no need to reverse.
//Therefore, [1, 3, 2] is the next permutation of [1, 2, 3].
    public void nextPermutation2(int[] nums) {

        // System.out.println("Input is "+Arrays.toString(nums));
        // Find the decreasing order and Kth inflection point
        // 6,2,1,5,4,3,0
        int kindex= nums.length-2;
        while(kindex >= 0 && nums[kindex] >= nums[kindex+1]){
            kindex--;
        }
        // System.out.println("kindex is "+kindex);

        // if(kindex==-1){
        //     return;
        // }

        // Swap the last element that is greater than kindex value

        int index = nums.length-1;
        while(kindex!=-1 && index > kindex){
            // System.out.println("nums["+index+"] > nums["+kindex+"] is " + nums[index] +"  > " + nums[kindex]);
            if(nums[index] > nums[kindex]){
                swap(nums,index,kindex);
                break;
            }
            index--;
        }

        // reverse the array from k+1 index

        //Arrays.copyRangeOf(nums,k+1,nums.length-1);
        int start = kindex+1, end = nums.length-1;
        while(start<end){
            swap(nums,start++,end--);
        }

    }

    private void swap(int[] arr, int src, int dest){
        int temp = arr[src];
        arr[src] = arr[dest];
        arr[dest] = temp;
    }

    public void nextPermutation(int[] nums) {

        int firstInflectionPt = nums.length-1;

        while (firstInflectionPt >0){

            if(nums[firstInflectionPt-1] < nums[firstInflectionPt])
                break;

            firstInflectionPt--;
        }
        System.out.println(firstInflectionPt);

        if(firstInflectionPt == 0){
            reverseIntArray(nums,firstInflectionPt);
            return;
        }
        firstInflectionPt = firstInflectionPt-1;
        System.out.println(firstInflectionPt);
        int secondInflectionPt = nums.length-1;

        while (secondInflectionPt  >= firstInflectionPt){
            if(nums[firstInflectionPt] < nums[secondInflectionPt])
                break;
            secondInflectionPt--;
        }

        // System.out.println(secondInflectionPt);
        // System.out.println(charArray);

        swapInt(nums,firstInflectionPt,secondInflectionPt);

        // System.out.println(charArray);

        reverseIntArray(nums,firstInflectionPt+1);
        // System.out.println(charArray);

      //  int result = getIntFromCharArray(nums);

        //return nums;

    }

    public int nextGreaterElement(int n) {
        char[] charArray = (n+"").toCharArray();

        int firstInflectionPt = charArray.length-1;

        while (firstInflectionPt >0){

            if(charArray[firstInflectionPt-1] < charArray[firstInflectionPt])
                break;

            firstInflectionPt--;
        }
        firstInflectionPt = firstInflectionPt-1;
        System.out.println(firstInflectionPt);
        int secondInflectionPt = charArray.length-1;

        while (secondInflectionPt  >= firstInflectionPt){
            if(charArray[firstInflectionPt] < charArray[secondInflectionPt])
                break;
                secondInflectionPt--;
        }

       // System.out.println(secondInflectionPt);
       // System.out.println(charArray);

        swap(charArray,firstInflectionPt,secondInflectionPt);

       // System.out.println(charArray);

        reverseArray(charArray,firstInflectionPt+1);
       // System.out.println(charArray);

        int result = getIntFromCharArray(charArray);

        return result;
    }

    private int getIntFromCharArray(char[] charArray) {
        return Integer.parseInt(new String(charArray));
    }



    private void reverseArray(char[] charArray, int i) {
        int firstPt = i;
        int secondPt = charArray.length-1;
        while (firstPt <= secondPt){
            swap(charArray,firstPt,secondPt);
            firstPt++;
            secondPt--;
        }
    }

    private void swap(char[] charArray, int firstPt, int secondPt) {

        char temp = charArray[firstPt];
        charArray[firstPt] = charArray[secondPt];
        charArray[secondPt] = temp;
    }

    private void swapInt(int[] intArray, int firstPt, int secondPt) {

        int temp = intArray[firstPt];
        intArray[firstPt] = intArray[secondPt];
        intArray[secondPt] = temp;
    }

    private void reverseIntArray( int[] intArray, int i) {
        int firstPt = i;
        int secondPt = intArray.length-1;
        while (firstPt <= secondPt){
            swapInt(intArray,firstPt,secondPt);
            firstPt++;
            secondPt--;
        }
    }

    public static void main(String[] args) {
        NextPermutation permutation = new NextPermutation();
        System.out.println(permutation.nextGreaterElement(125431));
        int [] nums = {3,2,1};
        permutation.nextPermutation(nums);
        System.out.println("Result is "+ Arrays.toString(nums));
        nums = new int[]{1,2,3};
        permutation.nextPermutation2(nums);
        System.out.println("Result is "+Arrays.toString(nums));
        nums = new int[]{1,2,3};
        permutation.nextPermutation(nums);
        System.out.println("Result is "+Arrays.toString(nums));
    }
}
