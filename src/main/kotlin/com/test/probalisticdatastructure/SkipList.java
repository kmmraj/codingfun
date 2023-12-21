package com.test.probalisticdatastructure;

import java.util.Random;

class SkipListNode<T extends Comparable<T>> {
    T value;
    SkipListNode<T>[] next;

    @SuppressWarnings("unchecked")
    public SkipListNode(T value, int level) {
        this.value = value;
        this.next = new SkipListNode[level + 1];
    }
}

public class SkipList<T extends Comparable<T>> {
    private static final int MAX_LEVEL = 3; // Maximum number of levels in the skip list
    private int level; // Current maximum level of the skip list
    private SkipListNode<T> head; // Head node of the skip list
    private Random random;

    public SkipList() {
        this.level = 0;
        this.head = new SkipListNode<>(null, MAX_LEVEL);
        this.random = new Random();
    }

    public void insert(T value) {
        SkipListNode<T>[] update = new SkipListNode[MAX_LEVEL + 1];
        SkipListNode<T> current = head;

        for (int i = level; i >= 0; i--) {
            while (current.next[i] != null && current.next[i].value.compareTo(value) < 0) {
                current = current.next[i];
            }
            update[i] = current;
        }

        int newLevel = generateRandomLevel();
        if (newLevel > level) {
            for (int i = level + 1; i <= newLevel; i++) {
                update[i] = head;
            }
            level = newLevel;
        }

        SkipListNode<T> newNode = new SkipListNode<>(value, newLevel);

        for (int i = 0; i <= newLevel; i++) {
            newNode.next[i] = update[i].next[i];
            update[i].next[i] = newNode;
        }
    }

    public boolean contains(T value) {
        SkipListNode<T> current = head;

        for (int i = level; i >= 0; i--) {
            while (current.next[i] != null && current.next[i].value.compareTo(value) < 0) {
                current = current.next[i];
            }
        }

        return current.next[0] != null && current.next[0].value.compareTo(value) == 0;
    }

    public void printSkipList() {
        for (int i = level; i >= 0; i--) {
            SkipListNode<T> current = head.next[i];
            System.out.print("Level " + i + ": ");
            while (current != null) {
                System.out.print(current.value + " ");
                current = current.next[i];
            }
            System.out.println();
        }
    }

    private int generateRandomLevel() {
        int newLevel = 0;
        while (random.nextDouble() < 0.5 && newLevel < MAX_LEVEL) {
            newLevel++;
        }
        return newLevel;
    }

    public static void main(String[] args) {
        SkipList<Integer> skipList = new SkipList<>();

        skipList.insert(3);
        skipList.insert(6);
        skipList.insert(7);
        skipList.insert(49);
        skipList.insert(60);
        skipList.insert(9);
        skipList.insert(12);
        skipList.insert(22);
        skipList.insert(17);
        skipList.insert(26);
        skipList.insert(21);
        skipList.insert(25);

        System.out.println("Skip List after insertion:");
        skipList.printSkipList();

        int searchValue = 19;
        System.out.println("\nDoes the skip list contain " + searchValue + "? " + skipList.contains(searchValue));
    }
}

