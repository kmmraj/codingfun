package com.test.recursion;

import org.jetbrains.annotations.NotNull;

public class NextPermutation {

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



    private void reverseArray(@NotNull char[] charArray, int i) {
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

    private void reverseIntArray(@NotNull int[] intArray, int i) {
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
    }
}
