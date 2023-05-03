package com.test.linklist;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertTrue;

public class RemoveKthNodeFromEnd {

    public static void removeKthNodeFromEnd(LinkedList head, int k) {
        // Write your code here.
        LinkedList first = head;
        LinkedList second = head;
        for (int idx = 0; idx < k; idx++) {
            second = second.next;
        }
        if (second == null) {
            // If count = N i.e. delete the head node
            head.value = head.next.value;
            head.next = head.next.next;
            return;
        }

        while (second.next != null) {
            first = first.next;
            second = second.next;
        }
        first.next = first.next.next;


    }

    public static void main(String[] args) {
        RemoveKthNodeFromEnd removeKthNodeFromEnd = new RemoveKthNodeFromEnd();
        removeKthNodeFromEnd.TestCase1();
    }

    @Test
    public void TestCase1() {
        TestLinkedList test = new TestLinkedList(0);
        test.addMany(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        int[] expected = {0, 1, 2, 3, 4, 5, 7, 8, 9};
        RemoveKthNodeFromEnd.removeKthNodeFromEnd(test, 4);
        assertTrue(compare(test.getNodesInArray(), expected));
    }

    @Test
    public void TestCase10() {
        TestLinkedList test = new TestLinkedList(0);
        test.addMany(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        int[] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        RemoveKthNodeFromEnd.removeKthNodeFromEnd(test, 10);
        assertTrue(compare(test.getNodesInArray(), expected));
    }

    public boolean compare(List<Integer> arr1, int[] arr2) {
        if (arr1.size() != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.size(); i++) {
            if (arr1.get(i) != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    static class LinkedList {
        int value;
        LinkedList next = null;

        public LinkedList(int value) {
            this.value = value;
        }
    }

    class TestLinkedList extends RemoveKthNodeFromEnd.LinkedList {

        public TestLinkedList(int value) {
            super(value);
        }

        public void addMany(int[] values) {
            RemoveKthNodeFromEnd.LinkedList current = this;
            while (current.next != null) {
                current = current.next;
            }
            for (int value : values) {
                current.next = new RemoveKthNodeFromEnd.LinkedList(value);
                current = current.next;
            }
        }

        public List<Integer> getNodesInArray() {
            List<Integer> nodes = new ArrayList<Integer>();
            RemoveKthNodeFromEnd.LinkedList current = this;
            while (current != null) {
                nodes.add(current.value);
                current = current.next;
            }
            return nodes;
        }
    }
}
