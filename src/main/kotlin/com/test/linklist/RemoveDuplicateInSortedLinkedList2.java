package com.test.linklist;
// https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
/**
 * 82. Remove Duplicates from Sorted List II
 * Given the head of a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list. Return the linked list sorted as well.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: head = [1,2,3,3,4,4,5]
 * Output: [1,2,5]
 * Example 2:
 *
 *
 * Input: head = [1,1,1,2,3]
 * Output: [2,3]
 *
 *
 * Constraints:
 *
 * The number of nodes in the list is in the range [0, 300].
 * -100 <= Node.val <= 100
 * The list is guaranteed to be sorted in ascending order.
 */

import com.test.ListNode;

public class RemoveDuplicateInSortedLinkedList2 {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummyHead = new ListNode(Integer.MIN_VALUE, head);
        ListNode slow = dummyHead, fast = head;
        while (fast != null) {
            while (fast != null && fast.next != null && fast.val == fast.next.val) {
                // System.out.println("Duplicate detected ! fast.val is " + fast.val + " fast.next.val is "
                //         + fast.next.val);
                fast = fast.next;
            }
            if (slow.next != fast) {
                slow.next = fast.next; // Remove the duplicate
                fast = slow.next;      // Update the iteration ptr
            } else {
                slow = slow.next;
                fast = fast.next;
            }

        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        System.out.println("RemoveDuplicateInSortedLinkedList2().deleteDuplicates(null) should be null and the result is "
                + new RemoveDuplicateInSortedLinkedList2().deleteDuplicates(null));
        System.out.println("RemoveDuplicateInSortedLinkedList2().deleteDuplicates(new ListNode(1)) should be [1] and the result is "
                + new RemoveDuplicateInSortedLinkedList2().deleteDuplicates(new ListNode(1)));
        System.out.println("RemoveDuplicateInSortedLinkedList2().deleteDuplicates(new ListNode(1, new ListNode(2, new ListNode(3)))) should be [1,2,3] and the result is "
                + new RemoveDuplicateInSortedLinkedList2().deleteDuplicates(new ListNode(1, new ListNode(2, new ListNode(3)))));
        System.out.println("RemoveDuplicateInSortedLinkedList2().deleteDuplicates(new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3)))) should be [2,3] and the result is "
                + new RemoveDuplicateInSortedLinkedList2().deleteDuplicates(new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3))))));

        System.out.println("RemoveDuplicateInSortedLinkedList2().deleteDuplicates(new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(3)))) should be [1,3] and the result is "
                + new RemoveDuplicateInSortedLinkedList2().deleteDuplicates(new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(3))))));

        System.out.println("RemoveDuplicateInSortedLinkedList2().deleteDuplicates(new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(3)))))) should be [3] and the result is "
                + new RemoveDuplicateInSortedLinkedList2().deleteDuplicates(new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(3)))))));

        System.out.println("RemoveDuplicateInSortedLinkedList2().deleteDuplicates(new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(3, new ListNode(3))))))) should be [] and the result is "
                + new RemoveDuplicateInSortedLinkedList2().deleteDuplicates(new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(3, new ListNode(3))))))));
    }
}
