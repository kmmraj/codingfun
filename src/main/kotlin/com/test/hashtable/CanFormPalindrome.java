package com.test.hashtable;

import java.util.HashMap;
import java.util.Map;

public class CanFormPalindrome {

    private boolean canFormPalindrome(String input){
        int[] table = new int[128];
        for (char c : input.toCharArray()) {
            table[c]++;
        }
        int count = 0;
        for (int i : table) {
            if (i % 2 != 0) {
                count++;
            }
        }
        return count <= 1;

    }

    private boolean canFormPalindrome2(String input){
        Map<Character,Integer> table = new HashMap<>();
        for (char c : input.toCharArray()) {
            table.put(c, table.getOrDefault(c, 0) + 1);
        }
        int count = 0;
        for (Integer value : table.values()){
            if(value %2 != 0){
                count++;
            }
        }
        return count <= 1;
    }

    public static void main(String[] args) {
        CanFormPalindrome canFormPalindrome = new CanFormPalindrome();
        System.out.println("civic is a palindrome and the answer is " +canFormPalindrome.canFormPalindrome("civic"));
        System.out.println("civic is a palindrome and the answer is " +canFormPalindrome.canFormPalindrome2("civic"));

        System.out.println("civil is not a palindrome and the answer is " +canFormPalindrome.canFormPalindrome("civil"));
        System.out.println("civil is not a palindrome and the answer is " +canFormPalindrome.canFormPalindrome2("civil"));

        System.out.println("civvic is a palindrome and the answer is " +canFormPalindrome.canFormPalindrome("civvic"));
        System.out.println("civvic is a palindrome and the answer is " +canFormPalindrome.canFormPalindrome2("civvic"));
    }
}
