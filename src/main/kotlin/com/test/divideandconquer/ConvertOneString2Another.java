package com.test.divideandconquer;

public class ConvertOneString2Another {


    public static void main(String[] args) {
        System.out.println("No of min operations required to convert s2 to s1 is : "
                + ConvertOneString2Another.findMinOperations("table", "tbres", 0, 0));
        System.out.println("No of min operations required to convert s2 to s1 is : "
                + ConvertOneString2Another.findMinOperationsTopDown("table", "tbres", 0, 0));

        System.out.println("No of min operations required to convert s2 to s1 is : "
                + ConvertOneString2Another.findMinOperations("tableone", "tbrleoni", 0, 0));
        System.out.println("No of min operations required to convert s2 to s1 is : "
                + ConvertOneString2Another.findMinOperationsTopDown("tableone", "tbrleoni", 0, 0));
    }

    private static int findMinOperations(String string1, String string2, int index1, int index2) {
        // BC
        if (index1 == string1.length()) { // rest of the chars to be deleted
            return string2.length() - index2;
        }

        if (index2 == string2.length()) {
            return string1.length() - index1; // rest of the chars to be inserted
        }

        if (string1.charAt(index1) == string2.charAt(index2)) { // Both of them are matching
            return findMinOperations(string1, string2, index1 + 1, index2 + 1);
        }

        int deleteOperation = 1 + findMinOperations(string1, string2, index1 + 1, index2);
        int insertOperation = 1 + findMinOperations(string1, string2, index1, index2 + 1);
        int replaceOperation = 1 + findMinOperations(string1, string2, index1 + 1, index2 + 1);

        int minOne = Math.min(deleteOperation, insertOperation);
        return Math.min(minOne, replaceOperation);

    }

    private static int findMinOperationsTopDown(String string1, String string2, int index1, int index2) {
        int[][] memo = new int[string1.length()+1][string2.length()+1];
        return findMinOperationsTopDown(string1, string2, index1, index2, memo);
    }

    private static int findMinOperationsTopDown(String string1, String string2, int index1, int index2, int[][] memo) {
        // BC
        if (index1 == string1.length()) { // rest of the chars to be deleted
            memo[index1][index2] = string2.length() - index2;
            return memo[index1][index2] ;
        }

        if (index2 == string2.length()) { // rest of the chars to be inserted
            memo[index1][index2] = string1.length() - index1;
            return memo[index1][index2] ;
        }

        if (string1.charAt(index1) == string2.charAt(index2)) { // Both of them are matching
            memo[index1][index2] = findMinOperationsTopDown(string1, string2, index1 + 1, index2 + 1, memo);
            return memo[index1][index2];
        }

        if (memo[index1][index2] == 0) {
            int deleteOperation = 1 + findMinOperationsTopDown(string1, string2, index1 + 1, index2, memo);
            int insertOperation = 1 + findMinOperationsTopDown(string1, string2, index1, index2 + 1, memo);
            int replaceOperation = 1 + findMinOperationsTopDown(string1, string2, index1 + 1, index2 + 1, memo);

            int minOne = Math.min(deleteOperation, insertOperation);
            memo[index1][index2] = Math.min(minOne, replaceOperation);
        }
        return memo[index1][index2];

    }
}
