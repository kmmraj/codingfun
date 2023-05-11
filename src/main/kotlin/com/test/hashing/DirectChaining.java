package com.test.hashing;

import java.util.LinkedList;

public class DirectChaining {

    LinkedList<String>[] hashTable;

    public DirectChaining(int size) {
        hashTable = new LinkedList[size];
    }

    private int getHashed(String word){
        char[] charList = word.toCharArray();
        int sum =0;
        for (char c : charList) {
            sum += c;
        }
        return sum % hashTable.length;
    }

    /**
     *
     * @param word
     * @return true - newly added, false - updated
     */
    private boolean insert(String word) {
        int hashedValue = getHashed(word);
        if(hashTable[hashedValue] == null){
            hashTable[hashedValue] = new LinkedList<>();
            hashTable[hashedValue].add(word);
            return true;
        }
        hashTable[hashedValue].add(word);
        return false;
    }

    private void printAll() {
        System.out.println("\n-------------- DH --- Start -------");
        for (int indx = 0; indx < hashTable.length; indx++) {
            System.out.println("Index " + indx + ", key:" + hashTable[indx]);
        }
        System.out.println("\n-------------- DH --- End   -------");
    }

    public static void main(String[] args) {
        DirectChaining directChaining = new DirectChaining(7);
        directChaining.insert("Get");
        directChaining.insert("proper");
        directChaining.insert("vaccine");
        directChaining.insert("done");
        directChaining.insert("for");
        directChaining.insert("kids");
        directChaining.insert("Starting");
        directChaining.insert("from");
        directChaining.insert("second");
        directChaining.insert("day");
        directChaining.insert("until");
        directChaining.insert("age");
        directChaining.insert("fifteen");
        directChaining.printAll();
    }




}
