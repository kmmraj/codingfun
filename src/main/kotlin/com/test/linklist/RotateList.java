// https://leetcode.com/problems/rotate-list/description/
package com.test.linklist;

import com.test.ListNode;

public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {

        ListNode originalHead = head;
        ListNode lastNode = null;
        int length = 0;

        // Get the last node and length of the list
        while (head != null) {
            length++;
            lastNode = head;
            head = head.next;
        }
        if (length == 0) {
            return null;
        }
        int rotateBy = k % length;
        if (rotateBy == 0) {
            return originalHead;
        }
        int rotateFrom = length - rotateBy;
        head = originalHead;
        ListNode prevNode = null;
        while (rotateFrom > 0) {
            prevNode = head;
            head = head.next;
            rotateFrom--;
        }
        // Update the last prev node next to null, otherwise it will be cyclical
        if(prevNode !=null) prevNode.next = null;
        // Update the last node next to original head
        lastNode.next = originalHead;
        return head;

    }

    public static void main(String[] args) {
        // Example 1:
        //
        //
        //Input: head = [1,2,3,4,5], k = 2
        //Output: [4,5,1,2,3]
        //Example 2:
        //
        //
        //Input: head = [0,1,2], k = 4
        //Output: [2,0,1]

        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode head = new ListNode(1, node2);

        int k = 2;
        ListNode rotatedList;
//        ListNode rotatedList = new RotateList().rotateRight(head, k);
//        System.out.println("Rotated list: " + rotatedList);


        rotatedList = new RotateList().rotateRight(head, 4);
        System.out.println("Rotated list: " + rotatedList);


    }
}
