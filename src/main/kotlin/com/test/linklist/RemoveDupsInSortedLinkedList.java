package com.test.linklist;
// https://leetcode.com/problems/remove-duplicates-from-sorted-list/description/
/**
 * 83. Remove Duplicates from Sorted List
 * Given the head of a sorted linked list, delete all duplicates such that each element appears only once.
 * Return the linked list sorted as well.
 *
 *
 *
 * Example 1:
 * Input: head = [1,1,2]
 * Output: [1,2]
 *
 * Example 2:
 * Input: head = [1,1,2,3,3]
 * Output: [1,2,3]
 *
 *
 * Constraints:
 *
 * The number of nodes in the list is in the range [0, 300].
 * -100 <= Node.val <= 100
 * The list is guaranteed to be sorted in ascending order.
 */

import com.test.ListNode;

public class RemoveDupsInSortedLinkedList {


    public ListNode deleteDuplicates2(ListNode head) {
        ListNode dummyHead = new ListNode(Integer.MIN_VALUE,head);
        ListNode prevDistinct;
        while(head != null){
            prevDistinct = head;
            while(head != null && head.next != null && head.val == head.next.val) {
                head = head.next;
            }
            prevDistinct.next = head.next;

            head = head.next;
        }
        return dummyHead.next;
    }
    public ListNode deleteDuplicates(ListNode head) {

        // Border Condition#1
        if(head == null){
            return head;
        }

        // Border Condition#2
        if(head.next == null){
            return head;
        }
        ListNode headCopy = head;
        while (head != null && head.next != null){
            if(head.val == head.next.val){
                head.next = head.next.next;
            } else {
                head = head.next;
            }
        }
        return headCopy;

    }

    public ListNode deleteDuplicatesKeepUniques(ListNode head) {

        ListNode dummy = new ListNode(0);
        // Dummy node points to the original head
        dummy.next = head;
        ListNode prevCopy = dummy;
        ListNode currNode = head;
        while (currNode != null ){


            while (currNode.next != null && currNode.next.val == prevCopy.next.val){
                currNode = currNode.next;
            }

            if(prevCopy.next == currNode){
                // No duplicates
                prevCopy = prevCopy.next;

            } else {
                // Duplicates
                // Fix here
                prevCopy.next = currNode.next;
            }
            currNode = currNode.next;
        }
        return dummy.next;

    }

    public static void main(String[] args) {

        ListNode l8 = new ListNode(5);
        ListNode l7 = new ListNode(4,l8);
        ListNode l6 = new ListNode(4,l7);
        ListNode l5 = new ListNode(3,l6);
        ListNode l4 = new ListNode(3,l5);
        ListNode l3 = new ListNode(2,l4);
        ListNode l2 = new ListNode(1,l3);
        ListNode l1 = new ListNode(1,l2);

        RemoveDupsInSortedLinkedList dups = new RemoveDupsInSortedLinkedList();
        ListNode noDupLL = new ListNode();
        noDupLL.next = dups.deleteDuplicatesKeepUniques(l1);

        do {
            System.out.println(noDupLL.next.val);
            noDupLL = noDupLL.next;
        } while (noDupLL.next != null);

        System.out.println("dups.deleteDuplicates(new ListNode(1, new ListNode(1, new ListNode(2)))) should be [1,2] and result is "
                + dups.deleteDuplicates2(new ListNode(1, new ListNode(1, new ListNode(2)))) );

        System.out.println("dups.deleteDuplicates(new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3)))))) should be [1,2,3] and result is "
                + dups.deleteDuplicates2(new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3)))))) );

        System.out.println("dups.deleteDuplicates(new ListNode(1, new ListNode(1, new ListNode(1)))) should be [1] and result is "
                + dups.deleteDuplicates2(new ListNode(1, new ListNode(1, new ListNode(1)))) );

        System.out.println("dups.deleteDuplicates(new ListNode(1, new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3)))))) should be [1,2,3] and result is "
                + dups.deleteDuplicates2(new ListNode(1, new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3)))))) );

        System.out.println("dups.deleteDuplicates(new ListNode(1, new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(2)))))) should be [1,2] and result is "
                + dups.deleteDuplicates2(new ListNode(1, new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(2)))))) );

        System.out.println("dups.deleteDuplicates(new ListNode(1, new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(3))))))) should be [1,2,3] and result is "
                + dups.deleteDuplicates2(new ListNode(1, new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(3))))))) );

        System.out.println("dups.deleteDuplicates(new ListNode(1, new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(3, new ListNode(3)))))))) should be [1,2,3] and result is "
                + dups.deleteDuplicates2(new ListNode(1, new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(3, new ListNode(3)))))))) );



    }
}
