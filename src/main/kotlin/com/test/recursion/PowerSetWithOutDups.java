package com.test.recursion;

import java.util.ArrayList;

public class PowerSetWithOutDups {

    private ArrayList<String> solve(String ipString) {
        ArrayList<String> answer = new ArrayList<String>();
        solveIt(ipString, 0, "", answer);
        return answer;
    }

    private void solveIt(String ipString, int index, String opString, ArrayList<String> answer) {
        //BC
        if(index == ipString.length()){
            // check dups  and then add
            if(!answer.contains(opString)){
                answer.add(opString);
            }
            return;
        }

        // Hypo and Induction
        solveIt(ipString,index+1, opString + ipString.charAt(index),answer);
        solveIt(ipString,index+1, opString,answer);

    }

    public static void main(String[] args) {
        PowerSetWithOutDups setWithOutDups = new PowerSetWithOutDups();
        ArrayList<String> answer  = setWithOutDups.solve("aab");
        for (String item:answer) {
            System.out.println(item);
        }
    }


}
