package com.test.dynamicprogramming.mcm;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;

public class EvaluateBooleanParenthesis {
    int [][][] dpT;
    HashMap<String,Integer> dpMap;



    public int countTrue(String A) {

        dpMap = new HashMap<>();
        dpT = new int[A.length()+1][A.length()+1][2];
        for (int idx = 0; idx < A.length(); idx++) {
            for (int jdx = 0; jdx < A.length(); jdx++) {
                Arrays.fill(dpT[idx][jdx],-1);
            }
        }

        int count;
        Instant start = Instant.now();
        count = solveIt(A,0,A.length()-1,true);
        Instant end = Instant.now();
        Duration timeElapsed = Duration.between(start, end);
        System.out.println("Time taken: "+ timeElapsed.toMillis() +" milliseconds");
        System.out.println(count);
        System.out.println("-------------------------Table Memmoized---------------------------");
        start = Instant.now();
        count = solveItRecursivelyWithMemoized(A,0,A.length()-1,true);
        end = Instant.now();
        timeElapsed = Duration.between(start, end);
        System.out.println("Time taken: "+ timeElapsed.toMillis() +" milliseconds");
        System.out.println(count);

        System.out.println("-------------------------Map Memmoized---------------------------");
        start = Instant.now();
        count = solveItRecursivelyWithMemoizedHashMap(A,0,A.length()-1,true);
        end = Instant.now();
        timeElapsed = Duration.between(start, end);
        System.out.println("Time taken: "+ timeElapsed.toMillis() +" milliseconds");
        System.out.println(count);

        return count;
    }

    public int  solveIt(String str,int i, int j, boolean isTrue){
        //BC#1
        if(i>j)
            return 0;
        //BC#2
        if(i==j){
//           if(isTrue)
//               return str.charAt(i) =='T' ? 1 : 0;
//           else
//               return str.charAt(i) =='F'? 1 : 0;

            if(isTrue && str.charAt(i) =='T')
                return 1;
            else if(!isTrue && str.charAt(i) =='F')
                return 1;
            else
                return 0;
        }

        // Hypo & Choice Diagram
        int answer  = 0;
        for (int k = i+1; k <=j-1; k=k+2) {
            int leftTrue = solveIt(str,i,k-1,true);
            int leftFalse = solveIt(str,i,k-1,false);
            int rightTrue = solveIt(str,k+1,j,true);
            int rightFalse = solveIt(str,k+1,j,false);

            if(str.charAt(k) == '&'){
                if(isTrue)  {
                    answer = answer + (leftTrue * rightTrue);
                } else {
                    answer = answer + (leftFalse * rightTrue) + (leftTrue * rightFalse) + (leftFalse * rightFalse);
                }
            }  else  if(str.charAt(k) == '|'){
                if(isTrue)  {
                    answer = answer + (leftFalse * rightTrue) + (leftTrue * rightFalse) + (leftTrue * rightTrue);
                } else {
                    answer = answer + (leftFalse * rightFalse);
                }
            } else if(str.charAt(k) == '^'){
                if(isTrue)  {
                    answer = answer + (leftFalse * rightTrue) + (leftTrue * rightFalse);
                } else {
                    answer = answer + (leftFalse * rightFalse) + (leftTrue * rightTrue);
                }
            }

        }

        return answer;
    }


    // TODO: Try with HashMap  with key as "i+"_"+j="_"+isTrue
    public int  solveItRecursivelyWithMemoized(String str,int i, int j, boolean isTrue){
        //BC#1
        if(i>j)
            return 0;
        //BC#2
        if(i==j){

            if(isTrue && str.charAt(i) =='T')
                return 1;
            else if(!isTrue && str.charAt(i) =='F')
                return 1;
            else
                return 0;
        }

        // Hypo & Choice Diagram
        int answer  = 0;
        for (int k = i+1; k <=j-1; k=k+2) {
            int leftTrue = dpT[i][k-1][1] == -1 ? dpT[i][k-1][1] = solveItRecursivelyWithMemoized(str,i,k-1,true) : dpT[i][k-1][1];
            int leftFalse = dpT[i][k-1][0] == -1 ? dpT[i][k-1][0] = solveItRecursivelyWithMemoized(str,i,k-1,false): dpT[i][k-1][0];
            int rightTrue = dpT[k+1][j][1] == -1 ? dpT[k+1][j][1] = solveItRecursivelyWithMemoized(str,k+1,j,true) : dpT[k+1][j][1];
            int rightFalse =  dpT[k+1][j][0] == -1 ? dpT[k+1][j][0] = solveItRecursivelyWithMemoized(str,k+1,j,false): dpT[k+1][j][0];

            if(str.charAt(k) == '&'){
                if(isTrue)  {
                    answer = answer + (leftTrue * rightTrue);
                } else {
                    answer = answer + (leftFalse * rightTrue) + (leftTrue * rightFalse) + (leftFalse * rightFalse);
                }
            }  else  if(str.charAt(k) == '|'){
                if(isTrue)  {
                    answer = answer + (leftFalse * rightTrue) + (leftTrue * rightFalse) + (leftTrue * rightTrue);
                } else {
                    answer = answer + (leftFalse * rightFalse);
                }
            } else if(str.charAt(k) == '^'){
                if(isTrue)  {
                    answer = answer + (leftFalse * rightTrue) + (leftTrue * rightFalse);
                } else {
                    answer = answer + (leftFalse * rightFalse) + (leftTrue * rightTrue);
                }
            }

        }

        return dpT[i][j][isTrue?1:0] = answer;
    }


    public int  solveItRecursivelyWithMemoizedHashMap(String str,int i, int j, boolean isTrue){
        //BC#1
        if(i>j)
            return 0;
        //BC#2
        if(i==j){

            if(isTrue && str.charAt(i) =='T')
                return 1;
            else if(!isTrue && str.charAt(i) =='F')
                return 1;
            else
                return 0;
        }

        // Hypo & Choice Diagram
        int answer  = 0;
        for (int k = i+1; k <=j-1; k=k+2) {
            String keyRight = i+"_"+(k-1)+"_";
            String keyLeft = (k+1)+"_"+j+"_";

            int leftTrue;
            if(dpMap.containsKey(keyRight+"T")){
                leftTrue = dpMap.get(keyRight+"T");
            } else {
                leftTrue = solveItRecursivelyWithMemoizedHashMap(str,i,k-1,true);
                dpMap.put(keyRight+"T",leftTrue);
            }
            int leftFalse;
            if(dpMap.containsKey(keyRight+"F")){
                leftFalse =  dpMap.get(keyRight+"F");
            } else {
                leftFalse = solveItRecursivelyWithMemoizedHashMap(str,i,k-1,false);
                dpMap.put(keyRight+"F",leftFalse);
            }
            int rightTrue;
            if(dpMap.containsKey(keyLeft+"T")){
                rightTrue = dpMap.get(keyLeft+"T");
            } else {
                rightTrue = solveItRecursivelyWithMemoizedHashMap(str,k+1,j,true);
                dpMap.put(keyLeft+"T",rightTrue);
            }
            int rightFalse;
            if(dpMap.containsKey(keyLeft+"F")){
                rightFalse = dpMap.get(keyLeft+"F");
            } else {
                rightFalse = solveItRecursivelyWithMemoizedHashMap(str,k+1,j,false);
                dpMap.put(keyLeft+"F",rightFalse);
            }

            //int leftTrue = dpMap.containsKey(keyRight+"T") ? dpMap.get(keyRight+"T") : dpMap.put(keyRight+"T",solveItRecursivelyWithMemoizedHashMap(str,i,k-1,true));
           // int leftFalse = dpMap.containsKey(keyRight+"F") ? dpMap.get(keyRight+"F") : dpMap.put(keyRight+"F",solveItRecursivelyWithMemoizedHashMap(str,i,k-1,false));
           // int rightTrue = dpMap.containsKey(keyLeft+"T")?  dpMap.get(keyLeft+"T") : dpMap.put(keyLeft+"T",solveItRecursivelyWithMemoizedHashMap(str,k+1,j,true));
          //  int rightFalse =  dpMap.containsKey(keyLeft+"F")?  dpMap.get(keyLeft+"F") : dpMap.put(keyLeft+"F",solveItRecursivelyWithMemoizedHashMap(str,k+1,j,false));

            if(str.charAt(k) == '&'){
                if(isTrue)  {
                    answer = answer + (leftTrue * rightTrue);
                } else {
                    answer = answer + (leftFalse * rightTrue) + (leftTrue * rightFalse) + (leftFalse * rightFalse);
                }
            }  else  if(str.charAt(k) == '|'){
                if(isTrue)  {
                    answer = answer + (leftFalse * rightTrue) + (leftTrue * rightFalse) + (leftTrue * rightTrue);
                } else {
                    answer = answer + (leftFalse * rightFalse);
                }
            } else if(str.charAt(k) == '^'){
                if(isTrue)  {
                    answer = answer + (leftFalse * rightTrue) + (leftTrue * rightFalse);
                } else {
                    answer = answer + (leftFalse * rightFalse) + (leftTrue * rightTrue);
                }
            }

        }
        String key;
        if(isTrue)
            key = i+"_"+j+"_"+"T";
        else
            key = i+"_"+j+"_"+"F";
        dpMap.put(key, answer);
        return answer;
    }

    public static void main(String[] args) {
        EvaluateBooleanParenthesis booleanParenthesis = new EvaluateBooleanParenthesis();
        String  A = "T^T^T^F|F&F^F|T^F^T";
        System.out.println(booleanParenthesis.countTrue(A));
    }
}
