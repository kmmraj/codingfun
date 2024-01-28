package com.test.linklist;
// https://leetcode.com/problems/partition-list/description/

/**
 * 86. Partition List
 * Given the head of a linked list and a value x, partition it such that all nodes less than x come before nodes
 * greater than or equal to x.
 *
 * You should preserve the original relative order of the nodes in each of the two partitions.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: head = [1,4,3,2,5,2], x = 3
 * Output: [1,2,2,4,3,5]
 * Example 2:
 *
 * Input: head = [2,1], x = 2
 * Output: [1,2]
 *
 *
 * Constraints:
 *
 * The number of nodes in the list is in the range [0, 200].
 * -100 <= Node.val <= 100
 * -200 <= x <= 200
 */

import com.test.ListNode;

public class PivotLinkedList {

    public ListNode partition(ListNode head, int x) {
        ListNode lessThanHead = new ListNode(0, null);
        ListNode greaterThanHead = new ListNode(0, null);

        ListNode lessThanIter = lessThanHead, greaterThanIter = greaterThanHead, headIter = head;
        // Split the list into two with less than and greater than or equal to x
        while (headIter != null) {
            if (headIter.val < x) {
                lessThanIter.next = headIter;
                lessThanIter = lessThanIter.next;
            } else {
                greaterThanIter.next = headIter;
                greaterThanIter = greaterThanIter.next;
            }
            headIter = headIter.next;
        }
        // Fix the pointers
        lessThanIter.next = greaterThanHead.next;
        greaterThanIter.next = null;

        return lessThanHead.next;
    }

    public static void main(String[] args) {
        System.out.println("PivotLinkedList().partition(null, 3) should be null and the result is "
                + new PivotLinkedList().partition(null, 3));
        System.out.println("PivotLinkedList().partition(new ListNode(1), 3) should be [1] and the result is "
                + new PivotLinkedList().partition(new ListNode(1), 3));
        System.out.println("PivotLinkedList().partition(new ListNode(1, new ListNode(4, new ListNode(3, new ListNode(2, new ListNode(5, new ListNode(2)))))), 3) should be [1,2,2,4,3,5] and the result is "
                + new PivotLinkedList().partition(new ListNode(1, new ListNode(4, new ListNode(3, new ListNode(2, new ListNode(5, new ListNode(2)))))), 3));
        System.out.println("PivotLinkedList().partition(new ListNode(2, new ListNode(1)), 2) should be [1,2] and the result is "
                + new PivotLinkedList().partition(new ListNode(2, new ListNode(1)), 2));
    }
}
