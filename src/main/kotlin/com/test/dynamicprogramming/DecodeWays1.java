package com.test.dynamicprogramming;

import java.util.ArrayList;

public class DecodeWays1 {
//    public int numDecodings(String s) {
//
//        ArrayList<String> workingString = new ArrayList<>();
//        int decodeWays = 0;
//        int index = 0;
//        int result =  solveIt(s,workingString,decodeWays,index);
//        for (String str:workingString) {
//            System.out.println(str);
//        }
//        return result;
//
//    }

    private int solveIt(String s, ArrayList<String> workingList, int decodeWays, int index) {
        // BC
        if(s.length() == index) {
            if(!workingList.contains(s))
                workingList.add(s);
            return 1;
        }
        if(s.charAt(0) == '0') {
            workingList.clear();
            return 0;
        }


        //  Hypothesis & CD

        String decodedString = s.substring(index,index+1);
        //System.out.println(decodedString);
       // workingList.add(decodedString);
        int result = solveIt(s,workingList,decodeWays+1,index+1);


        if(index < s.length()-1 && validDecodedStr(s, index)){
            String decoded2ndString = s.substring(index,index+2);
                //System.out.println(decoded2ndString);
            workingList.add(decoded2ndString);
            result +=  solveIt(s,workingList,decodeWays+1,index+2);
        }

        return result;
    }

    private boolean validDecode(String decodedString) {
        if(decodedString.length() == 0)
            return false;
        int decodeValue = Integer.parseInt(decodedString);
        return decodeValue >=1 && decodeValue  <=26;
    }

    private boolean validDecodedStr(String decodedString, int index) {
        if((decodedString.charAt(index) == '1' || decodedString.charAt(index) == '2')
                && decodedString.charAt(index+1) < '7' ) {
            return true;
        }
        return false;
    }

    public int numDecodings(String s) {
        return s.length()==0?0:numDecodings(0,s);
    }
    private int numDecodings(int p, String s) {
        int n=s.length();
        if(p==n)
            return 1;
        if(s.charAt(p)=='0')
            return 0;
        int res=numDecodings(p+1,s);
        if(p<n-1&&(s.charAt(p)=='1'||s.charAt(p)=='2'&&s.charAt(p+1)<'7'))
            res+=numDecodings(p+2,s);
        return res;
    }

    public int namDecodingTry(String s) {
        DecodeWays decodeWays = new DecodeWays();
        return s.length()==0?0: namDecodingTry(0,s,decodeWays);
    }
    private int namDecodingTry(int p, String s, DecodeWays decodeWays) {
        int n=s.length();
        if(p==n)
            return decodeWays.val+1;
        if(s.charAt(p)=='0')
            return decodeWays.val;
        decodeWays.val = namDecodingTry(p+1,s,decodeWays);
        if(p<n-1&&(s.charAt(p)=='1'||s.charAt(p)=='2'&&s.charAt(p+1)<'7'))
            decodeWays.val= namDecodingTry(p+2,s,decodeWays);
        return decodeWays.val;
    }

    private class DecodeWays {
        public Integer val = 0;
    }

    public static void main(String[] args) {
        DecodeWays1 decodeWays1 = new DecodeWays1();
      //  System.out.println(decodeWays1.numDecodings("2263"));
        System.out.println("--------------------");
        System.out.println(decodeWays1.numDecodings("221"));
        System.out.println(decodeWays1.namDecodingTry("221"));
        System.out.println(decodeWays1.namDecodingTry("2210"));
        int [] nums = {1,2,3,4,5};
        //num

        /*
        class Solution {
    public int removeDuplicates(int[] nums) {
        for(int idx=0; idx<nums.length; idx++){
            int value =nums[idx];
            for(int secIdx=idx; secIdx<nums.length;secIdx++){
                if(nums[secIdx] == value){
                    nums[.remove]
                }
            }
        }
    }
}
         */
    }
}
