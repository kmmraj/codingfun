package com.test.trie;

import java.util.HashMap;
import java.util.Map;

public class Trie {

    static class TrieNode {
        Map<Character, TrieNode> childNodeMap;
        boolean endOfString = false;

        public TrieNode() {
            childNodeMap = new HashMap<>();
        }
    }

    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public boolean search(String word) {
        TrieNode currentNode = root;
        for (int idx = 0; idx < word.length(); idx++) {
            TrieNode nextNode = currentNode.childNodeMap.get(word.charAt(idx));
            if (nextNode == null) {
                return false;
            }
            currentNode = nextNode;
        }

        if (!currentNode.endOfString) {
            System.out.println("Found the string: " + word + " is a prefix");
        }
        return currentNode.endOfString;
    }

    public String insert(final String word) {
        TrieNode currentNode = root;
        for (int idx = 0; idx < word.length(); idx++) {
            TrieNode nextNode = currentNode.childNodeMap.get(word.charAt(idx));
            if (nextNode == null) {
                TrieNode newNode = new TrieNode();
                currentNode.childNodeMap.put(word.charAt(idx), newNode);
                currentNode = newNode;
            } else {
                currentNode = nextNode;
            }
        }
        currentNode.endOfString = true;
        return word;
    }

    private boolean delete(String word) {
//        if (!search(word)) {
//            return false;
//        }
//        return deleteIt(root, word, 0);
        return deleteNode(root, word, 0);

    }

    // API
    // APIS
    // to be deleted APIS
    private boolean deleteNode(TrieNode currentNode, String word, int index) {
        // BC
        char charValue = word.charAt(index);
        TrieNode nextNode = currentNode.childNodeMap.get(charValue);
        if(nextNode == null){
            System.out.println("Not found while deleting "+ word);
            return false;
        }
        if (index == word.length() - 1) {
            if (nextNode.childNodeMap.size() >= 1) {
                // Leaf Node is connected to other node
                nextNode.endOfString = false;
                return true;
            } else {
                // Leaf Node is not connected to any node
                currentNode.childNodeMap.remove(charValue);
                return true;
            }
        }
        // Hypothesis

        deleteNode(nextNode, word, index + 1);

        // Post recursion

        if (nextNode.childNodeMap.size() == 0 && !nextNode.endOfString) {
            currentNode.childNodeMap.remove(charValue);
        }
        return true;
    }

    private boolean deleteIt(TrieNode currentNode, String word, int index) {
        // BC
        // TODO : Write a proper BC
//        if (index >= word.length()) {
//            return true;
//        }

        // H & I
        char charValue = word.charAt(index);
        TrieNode nextNode = currentNode.childNodeMap.get(charValue);
        boolean canThisNodeBeDeleted;

        if (index == word.length() - 1) {
            if (nextNode.childNodeMap.size() >= 1) {
                nextNode.endOfString = false;
                return false;
            } else {
                currentNode.childNodeMap.remove(charValue);
                return true;
            }
        }

        if (nextNode.childNodeMap.size() > 1 || nextNode.endOfString) {
            deleteIt(nextNode, word, index + 1);
            return false;
        }

        canThisNodeBeDeleted = deleteIt(nextNode, word, index + 1);
        if (canThisNodeBeDeleted) {
            currentNode.childNodeMap.remove(charValue);
            return true;
        } else {
            return false;
        }
    }


    public static void main(String[] args) {
        Trie trie = new Trie();
        System.out.println("Inserting word: " + trie.insert("API"));
        System.out.println("Inserting word: " + trie.insert("APIS"));
        System.out.println("Inserting word: " + trie.insert("ACTOR"));
//        System.out.println("Inserting word: " + trie.insert("AP"));
//        System.out.println("Inserting word: " + trie.insert("APPLE"));
//        System.out.println("Searching word: API result ? " + trie.search("API"));
//        System.out.println("Searching word: APIS result ? " + trie.search("APIS"));
//        System.out.println("Searching word: AP result ? " + trie.search("AP"));
//        System.out.println("Searching word: APPLE result ? " + trie.search("APPLE"));
//        System.out.println("Searching word: APPLE result ? " + trie.search("MOHAN"));

//        System.out.println("Deleting word: API result ? " + trie.delete("API"));


        System.out.println("Deleting word: API result ? " + trie.delete("API"));
        System.out.println("Searching word: API result ? " + trie.search("API"));

        System.out.println("Deleting word: APIS result ? " + trie.delete("APIS"));
        System.out.println("Searching word: APIS result ? " + trie.search("APIS"));

        System.out.println("Searching word: ACTOR result ? " + trie.search("ACTOR"));
        System.out.println("Inserting word: " + trie.insert("ACT"));
        System.out.println("Deleting word: ACTOR result ? " + trie.delete("ACTOR"));
        System.out.println("Deleting word: ACTING result ? " + trie.delete("ACTING"));
        System.out.println("Searching word: ACT result ? " + trie.search("ACT"));
    }


}
