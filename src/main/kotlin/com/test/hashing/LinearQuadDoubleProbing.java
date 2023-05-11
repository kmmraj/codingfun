package com.test.hashing;

import java.util.Arrays;
import java.util.List;

public class LinearQuadDoubleProbing {

    String[] hashTable;
    int countOfHashes;

    public LinearQuadDoubleProbing(int size) {
        hashTable = new String[size];
        countOfHashes = 0;

    }

    private boolean insert(String word) {
        double loadFactor = getLoadFactor();
        if (loadFactor < 0.75) {
            insertIt(word, false);
        } else {
            System.out.println("\n Resizing called");
            reSize();
            return insertIt(word, false);
        }
        return true;
    }

    private double getLoadFactor() {
        return countOfHashes * 1.0 / hashTable.length;
    }

    private boolean insertIt(String word, boolean isInsertSucceed) {
        if (countOfHashes <= word.length()) {
            int hashValue = getHashed(word);
            if (hashTable[hashValue] == null) {
                hashTable[hashValue] = word;
                isInsertSucceed = true;
                countOfHashes++;
            } else {
                // isInsertSucceed = linearProbing(word, isInsertSucceed, hashValue);
                isInsertSucceed = quadProbing(word, isInsertSucceed, hashValue);
            }
        }
        return isInsertSucceed;
    }

    private boolean linearProbing(String word, boolean isInsertSucceed, int hashValue) {
        for (int indx = hashValue + 1; indx < hashValue + hashTable.length; indx++) {
            int newIndex = indx % hashTable.length;
            if (hashTable[newIndex] == null) {
                hashTable[newIndex] = word;
                isInsertSucceed = true;
                countOfHashes++;
                break;
            }
        }
        return isInsertSucceed;
    }

    private boolean quadProbing(String word, boolean isInsertSucceed, int hashValue) {
        int quadCounter = 0;
        int secondHash = getSecondHashed(word);
        for (int indx = hashValue + 1; indx < hashValue + hashTable.length; indx++) {
            int newIndex = (indx + (secondHash + (quadCounter * quadCounter))) % hashTable.length;
            if (hashTable[newIndex] == null) {
                hashTable[newIndex] = word;
                isInsertSucceed = true;
                countOfHashes++;
                break;
            }
            quadCounter++;
        }
        return isInsertSucceed;
    }

    private int getSecondHashed(String word) {
        char[] charList = word.toCharArray();
        int sum = 0;
        for (char c : charList) {
            sum += c;
        }
        sum = sumOfDigits(sum);
        return sum % hashTable.length;
    }

    private int sumOfDigits(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num = num / 10;
        }
        return sum;
    }


    private boolean doubleHashQuadProbing(String word, boolean isInsertSucceed, int hashValue) {
        int quadCounter = 0;
        for (int indx = hashValue + 1; indx < hashValue + hashTable.length; indx++) {
            int newIndex = indx + (quadCounter * quadCounter) % hashTable.length;
            if (hashTable[newIndex] == null) {
                hashTable[newIndex] = word;
                isInsertSucceed = true;
                countOfHashes++;
                break;
            }
            quadCounter++;
        }
        return isInsertSucceed;
    }

    private void reSize() {
        List<String> tempList = Arrays.asList(hashTable);
//        for (int indx = 0; indx < hashTable.length; indx++) {
//            tempList.add(hashTable[indx]);
//        }
        countOfHashes = 0;
        hashTable = new String[hashTable.length * 2];
        for (String word : tempList) {
            if (word != null) {
                insertIt(word, false);
            }
        }
    }

    private int getHashed(String word) {
        char[] charList = word.toCharArray();
        int sum = 0;
        for (char c : charList) {
            sum += c;
        }
        return sum % hashTable.length;
    }

    private void printAll() {
        System.out.println("\n-------------- DH --- Start -------");
        for (int indx = 0; indx < hashTable.length; indx++) {
            System.out.println("Index " + indx + ", key:" + hashTable[indx]);
        }
        System.out.println("\n-------------- DH --- End   -------");
    }


    public static void main(String[] args) {
        LinearQuadDoubleProbing linearQuadDoubleProbing = new LinearQuadDoubleProbing(4);

        linearQuadDoubleProbing.sumOfDigits(222);
        linearQuadDoubleProbing.insert("Get");
        linearQuadDoubleProbing.insert("proper");
        linearQuadDoubleProbing.insert("vaccine");
        linearQuadDoubleProbing.insert("using");
        linearQuadDoubleProbing.insert("First");
        linearQuadDoubleProbing.insert("injection");
        linearQuadDoubleProbing.insert("starts");
        linearQuadDoubleProbing.insert("weekly once");
        linearQuadDoubleProbing.insert("initial week");
        linearQuadDoubleProbing.printAll();

    }


}
