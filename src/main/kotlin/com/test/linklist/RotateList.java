// https://leetcode.com/problems/rotate-list/description/
/**
 * 61. Rotate List
 * Given the head of a linked list, rotate the list to the right by k places.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: head = [1,2,3,4,5], k = 2
 * Output: [4,5,1,2,3]
 * Example 2:
 *
 *
 * Input: head = [0,1,2], k = 4
 * Output: [2,0,1]
 *
 *
 * Constraints:
 *
 * The number of nodes in the list is in the range [0, 500].
 * -100 <= Node.val <= 100
 * 0 <= k <= 2 * 109
 */
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

    public ListNode rotateRight2(ListNode head, int k) {
        // ListNode dummyHead = new ListNode(0, head);
        if (k == 0 || head == null) {
            return head;
        }

        // Calculate the count

        int nodesCount = 1;
        ListNode tailNode = head;
        while ( tailNode.next != null) {
            tailNode = tailNode.next;
            ++nodesCount;
        }

        // Fix the K, so that it does not overflow

        k = k % nodesCount;

        // System.out.println("nodesCount is "+ nodesCount +" k is "+ k + " tailNode is "+tailNode.val);

        if (k == 0) {
            return head;
        }

        // Make the linkedList circular
        tailNode.next = head;

        // Find the new tailNode
        ListNode newHead = tailNode;
        int stepsToNewHead = nodesCount - k;
        while (stepsToNewHead-- > 0) {
            newHead = newHead.next;
        }

        // System.out.println(" stepsToNewHead is "+ stepsToNewHead + " newHead is "+newHead.val);
        ListNode newtail = newHead;
        ListNode returnHead = newHead.next;
        newtail.next = null;
        return returnHead;
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

        System.out.println("Rotated list should be [null] and it is : " + new RotateList().rotateRight(null, 4));
        System.out.println("Rotated list should be [1] and it is : " + new RotateList().rotateRight(new ListNode(1), 4));
        System.out.println("Rotated list should be [1,2] and it is : " + new RotateList().rotateRight(new ListNode(1, new ListNode(2)), 4));
        System.out.println("Rotated list should be [2,1] and it is : " + new RotateList().rotateRight(new ListNode(1, new ListNode(2)), 1));
        System.out.println("Rotated list should be [1,2] and it is : " + new RotateList().rotateRight(new ListNode(1, new ListNode(2)), 2));
        System.out.println("Rotated list should be [1,2] and it is : " + new RotateList().rotateRight(new ListNode(1, new ListNode(2)), 3));
        System.out.println("Rotated list should be [3,4,5,6,1,2] and it is : "
                + new RotateList().rotateRight(new ListNode(1, new ListNode(2, new ListNode(3,new ListNode(4, new ListNode(5, new ListNode(6)))))), 4));


    }
}
