package com.test.linklist;
// https://leetcode.com/problems/remove-nth-node-from-end-of-list/
/**
 * 19. Remove Nth Node From End of List
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.
 *
 *
 *
 * Example 1:
 * Input: head = [1,2,3,4,5], n = 2
 * Output: [1,2,3,5]
 *
 * Example 2:
 * Input: head = [1], n = 1
 * Output: []
 *
 *
 * Example 3:
 * Input: head = [1,2], n = 1
 * Output: [1]
 *
 *
 * Constraints:
 *
 * The number of nodes in the list is sz.
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz
 *
 *
 * Follow up: Could you do this in one pass?
 */

import com.test.ListNode;
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

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode(0, head);
        ListNode slow = dummyHead, fast = head; // <--- This is the key to solve this problem(slow = dummyHead)
        // ListNode slow = head, fast = head;

        while (n-- > 0) {
            fast = fast.next;
        }

        //ListNode prevSlow = slow;

        while (fast != null) {
            fast = fast.next;
            // prevSlow = slow;
            slow = slow.next;
        }
        // prevSlow.next = slow.next;
        slow.next = slow.next.next;
        return dummyHead.next;

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
