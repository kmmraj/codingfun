package com.test.strings;

public class ReverseString {

    public void reverseString(char[] s) {

        int start = 0;
        int end = s.length-1;
        while (start<=end){
            char temp = s[start];
            s[start] = s[end];
            s[end]=temp;
            start++;
            end--;
        }

        for (int idx = 0; idx < s.length; idx++) {
            System.out.printf("%c ",s[idx]);
        }

    }

    public static void main(String[] args) {
        ReverseString string = new ReverseString();
        char[] str = {'h','e','l','l','o'};
        string.reverseString(str);
    }
}
