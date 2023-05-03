package com.test.dynamicprogramming.mcm;

import java.time.Duration;
import java.time.Instant;
import java.util.HashMap;

/**
 * https://leetcode.com/problems/scramble-string/
 */
public class ScrambledString {

    HashMap<String,Boolean> dpM;

    public boolean isScramble(String s1, String s2) {

        // BC
        if (s1.length() != s2.length())
            return false;

        if(s1.length() == 0)
            return true;

        if(s1.equals(s2))
            return true;

        // Hypo & Choice Flows
        int n = s1.length();

        boolean isScrambled = false;
        // Why not until n ?
        // Breaking in to empty string is not allowed
        // for example "great" cannot be broken in to "great" and "" !!
        for (int i = 1; i < n; i++) {
            /*
              Note :

             */

           /**
            *   Swapped
            *  "great" and "rgeat" is partitioned as "g | reat" and "r| geat"
            *   and S2 is swapped as "geat | r"
            *
            *   Why S1 is not swapped?
            *   S1 is just a comparision string, S2 is the one gets scrambled
            *
            *   Comparision should be between string of equal length i.e swapped elements
            *
            *        S1                             S2
            *
            *    " g | reat "                    "r | geat"
            *
            *           After Swap (S2 only swaps)
            *
            *    " g | reat "                     "geat |  r"
            *
            *                    Compare
            *
            *            (i,n)                    (0,n-i)  #Case A
            *             __________________________
            *            |                          |
            *            |                          |
            *
            *    " g | reat "                     "geat |  r "
            *
            *      |                                       |
            *      |                                       |
            *      |_______________________________________|
            *
            *     (0,i)                                   (n-i ,n) #CaseB
            *
            *
            */

            if(isScramble(s1.substring(0,i),s2.substring(n-i,n)) // Case B
                    && isScramble(s1.substring(i,n),s2.substring(0,n-i))){ // Case A
                isScrambled = true;
                break;
                //return true;
            }
            /**
             *   NOT Swapped
             *  "great" and "rgeat" is partitioned as "g | reat" and "r| geat"
             *   and S2 is swapped as "geat | r"
             *
             *
             *        S1                             S2
             *
             *    " g | reat "                    "r | geat"
             *
             *                     No Swap
             *
             *    " g | reat "                    "r | geat"
             *
             *                    Compare
             *
             *            (i,n)                    (i,n)  #Case A
             *             ________________________________
             *            |                                |
             *            |                                |
             *            |                                |
             *
             *    " g | reat "                     "r |  geat "
             *
             *      |                               |
             *      |                               |
             *      |                               |
             *      |_______________________________|
             *
             *     (0,i)                            (0,i)  #Case B
             *
             *
             */
            if(isScramble(s1.substring(0,i),s2.substring(0,i)) //  #Case B
                    && isScramble(s1.substring(i,n),s2.substring(i,n))){ // #Case A
                isScrambled = true;
                break;
            }

        }

        return isScrambled;
    }

    public boolean isScrambleMemoized(String s1, String s2) {

        dpM = new HashMap<>();

        return isScrambledSolveIt(s1,s2);

    }

    private boolean isScrambledSolveIt(String s1, String s2) {
        // BC
        if (s1.length() != s2.length())
            return false;

        if(s1.length() == 0)
            return true;

        if(s1.equals(s2))
            return true;

        String key0 = s1+"_"+s2;

        if(dpM.containsKey(key0)){
            return dpM.get(key0);
        }

        // Hypo & Choice Flows
        int n = s1.length();

        boolean isScramble = false;

        // Why not until n ?
        // Breaking in to empty string is not allowed
        // for example "great" cannot be broken in to "great" and "" !!
        for (int i = 1; i < n; i++) {
            /*
              Note :

             */

            /**
             *   Swapped
             *  "great" and "rgeat" is partitioned as "g | reat" and "r| geat"
             *   and S2 is swapped as "geat | r"
             *
             *   Why S1 is not swapped?
             *   S1 is just a comparision string, S2 is the one gets scrambled
             *
             *   Comparision should be between string of equal length i.e swapped elements
             *
             *        S1                             S2
             *
             *    " g | reat "                    "r | geat"
             *
             *           After Swap (S2 only swaps)
             *
             *    " g | reat "                     "geat |  r"
             *
             *                    Compare
             *
             *            (i,n)                    (0,n-i)  #Case A
             *             __________________________
             *            |                          |
             *            |                          |
             *
             *    " g | reat "                     "geat |  r "
             *
             *      |                                       |
             *      |                                       |
             *      |_______________________________________|
             *
             *     (0,i)                                   (n-i ,n) #CaseB
             *
             *
             */

            Boolean contd1;
            Boolean contd2;
            Boolean contd3;
            Boolean contd4;

            String key1 = s1.substring(0,i)+"_"+ s2.substring(n-i,n);

            if(dpM.containsKey(key1)){
                contd1 = dpM.get(key1);
            } else {
               contd1 = isScrambledSolveIt(s1.substring(0,i),s2.substring(n-i,n));
               dpM.put(key1,contd1);
            }

            String key2 =s1.substring(i,n)+ "_"+s2.substring(0,n-i);
            if(dpM.containsKey(key2)){
                contd2 = dpM.get(key2);
            } else {
                //isScramble(s1.substring(i,n),s2.substring(0,n-i))
              contd2 = isScrambledSolveIt(s1.substring(i,n),s2.substring(0,n-i));
              dpM.put(key2,contd2);
            }

            if(contd1 // Case B
                    && contd2){ // Case A
                isScramble = true;
                break;
               // return true;
            }
            /**
             *   NOT Swapped
             *  "great" and "rgeat" is partitioned as "g | reat" and "r| geat"
             *   and S2 is swapped as "geat | r"
             *
             *
             *        S1                             S2
             *
             *    " g | reat "                    "r | geat"
             *
             *                     No Swap
             *
             *    " g | reat "                    "r | geat"
             *
             *                    Compare
             *
             *            (i,n)                    (i,n)  #Case A
             *             ________________________________
             *            |                                |
             *            |                                |
             *            |                                |
             *
             *    " g | reat "                     "r |  geat "
             *
             *      |                               |
             *      |                               |
             *      |                               |
             *      |_______________________________|
             *
             *     (0,i)                            (0,i)  #Case B
             *
             *
             */

            String key3 = s1.substring(0,i)+ "_"+s2.substring(0,i);
            if(dpM.containsKey(key3)){
                contd3 = dpM.get(key3);
            } else {
                contd3 = isScrambledSolveIt(s1.substring(0,i),s2.substring(0,i));
                dpM.put(key3,contd3);
            }

            String key4 = s1.substring(i,n)+ "_"+s2.substring(i,n);
            if(dpM.containsKey(key4)){
                contd4 = dpM.get(key4);
            } else {
                contd4 = isScrambledSolveIt(s1.substring(i,n),s2.substring(i,n));
                dpM.put(key4,contd4);
            }

            if(contd3 //  #Case B
                    && contd4){ // #Case A
                isScramble = true;
                break;
                //return true;
            }

        }
        dpM.put(key0,isScramble);

        return isScramble;

    }

    public static void main(String[] args) {
        ScrambledString scrambledString = new ScrambledString();
      //  String  s1 = "great", s2 = "rgeat";
        String  s1 = "abcdefghijklmnopq", s2 = "efghijklmnopqcadb";
        Instant start = Instant.now();
        System.out.println(scrambledString.isScrambleMemoized(s1,s2));
        Instant end = Instant.now();
        Duration timeElapsed = Duration.between(start,end);
        System.out.println("Memoized Time taken is : "+timeElapsed.toMillis());
        start = Instant.now();
        System.out.println(scrambledString.isScramble(s1,s2));
        end = Instant.now();
        timeElapsed = Duration.between(start,end);
        System.out.println("Time taken is : "+timeElapsed.toMillis());
    }
}
