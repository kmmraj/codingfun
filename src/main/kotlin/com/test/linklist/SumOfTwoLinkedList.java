package com.test.linklist;

import com.test.ListNode;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
//https://www.algoexpert.io/questions/Sum%20of%20Linked%20Lists
public class SumOfTwoLinkedList {


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode sumNodeHead = new ListNode(0, null);
        ListNode sumNodeIter = sumNodeHead;
        int carry = 0;

        while (l1 != null && l2 != null) {
            int tempSum = l1.val + l2.val + carry;
            sumNodeIter.next = new ListNode(tempSum % 10);
            carry = tempSum / 10;
            sumNodeIter = sumNodeIter.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            // System.out.println("l1.val is " + l1.val + " carry is " + carry);
            int tempSum = l1.val + carry;
            sumNodeIter.next = new ListNode(tempSum % 10);
            carry = tempSum / 10;
            sumNodeIter = sumNodeIter.next;
            l1 = l1.next;
        }

        while (l2 != null) {
            // System.out.println("l2.val is " + l2.val + " carry is " + carry);
            int tempSum = l2.val + carry;
            sumNodeIter.next = new ListNode(tempSum % 10);
            carry = tempSum / 10;
            sumNodeIter = sumNodeIter.next;
            l2 = l2.next;
        }
        if (carry > 0) {
            sumNodeIter.next = new ListNode(carry % 10);
            sumNodeIter = sumNodeIter.next;
            carry = carry / 10;
        }

        return sumNodeHead.next;

    }
    public static void main(String[] args) {
        TestCase1();

        System.out.println(" Sum of Two Linked List addTwoNumbers(new ListNode(2), new ListNode(9)) " +
                "should be 1 -> 1 and the result is "
                + new SumOfTwoLinkedList().addTwoNumbers(new ListNode(2), new ListNode(9)));

        System.out.println(" Sum of Two Linked List addTwoNumbers(new ListNode(2,new ListNode(5)), new ListNode(9)) " +
                "should be 1 -> 6 and the result is "
                + new SumOfTwoLinkedList().addTwoNumbers(new ListNode(2,new ListNode(5)), new ListNode(9)));

        System.out.println(" Sum of Two Linked List addTwoNumbers(new ListNode(2,new ListNode(5)), new ListNode(9, new ListNode(9))) " +
                "should be 1 -> 5 -> 1 and the result is "
                + new SumOfTwoLinkedList().addTwoNumbers(new ListNode(2,new ListNode(5)), new ListNode(9, new ListNode(9))));


    }

    public static void TestCase1() {
        SumOfTwoLinkedList.LinkedList ll1 = addMany(new SumOfTwoLinkedList.LinkedList(2), new int[]{4, 7, 1});
        SumOfTwoLinkedList.LinkedList ll2 = addMany(new SumOfTwoLinkedList.LinkedList(9), new int[]{4, 5});
        SumOfTwoLinkedList.LinkedList expected = addMany(new SumOfTwoLinkedList.LinkedList(1), new int[]{9, 2, 2});
        LinkedList actual = new SumOfTwoLinkedList().sumOfLinkedLists(ll1, ll2);
        assertEquals(getNodesInArray(expected), getNodesInArray(actual));
    }

    public static LinkedList addMany(LinkedList linkedList, int[] values) {
        LinkedList current = linkedList;
        while (current.next != null) {
            current = current.next;
        }
        for (int value : values) {
            current.next = new SumOfTwoLinkedList.LinkedList(value);
            current = current.next;
        }
        return linkedList;
    }

    public static List<Integer> getNodesInArray(SumOfTwoLinkedList.LinkedList linkedList) {
        ArrayList<Integer> nodeValues = new ArrayList<>();
        SumOfTwoLinkedList.LinkedList current = linkedList;
        while (current != null) {
            nodeValues.add(current.value);
            current = current.next;
        }
        return nodeValues;
    }

    public LinkedList sumOfLinkedLists(LinkedList linkedListOne, LinkedList linkedListTwo) {
        // Write your code here.
        int carry = 0;
        LinkedList head = new LinkedList(-1);
        LinkedList result = head;
        while (linkedListOne != null || linkedListTwo != null || carry != 0) {
            int value1 = linkedListOne == null ? 0 : linkedListOne.value;
            int value2 = linkedListTwo == null ? 0 : linkedListTwo.value;
            int sum = value1 + value2 + carry;
            carry = sum / 10;
            sum = sum % 10;
            result.next = new LinkedList(sum);
            result = result.next;
            linkedListOne = linkedListOne == null ? null : linkedListOne.next;
            linkedListTwo = linkedListTwo == null ? null : linkedListTwo.next;
        }
        return head.next;
    }

    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }
}
