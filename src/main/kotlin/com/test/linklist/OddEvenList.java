package com.test.linklist;
// https://leetcode.com/problems/odd-even-linked-list/description/

/**
 * 328. Odd Even Linked List
 * Given the head of a singly linked list, group all the nodes with odd indices together
 * followed by the nodes with even indices, and return the reordered list.
 * <p>
 * The first node is considered odd, and the second node is even, and so on.
 * <p>
 * Note that the relative order inside both the even and odd groups should remain as it was in the input.
 * <p>
 * You must solve the problem in O(1) extra space complexity and O(n) time complexity.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: head = [1,2,3,4,5]
 * Output: [1,3,5,2,4]
 * Example 2:
 * <p>
 * <p>
 * Input: head = [2,1,3,5,6,4,7]
 * Output: [2,3,6,7,1,5,4]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the linked list is in the range [0, 104].
 * -106 <= Node.val <= 106
 */

import com.test.ListNode;

public class OddEvenList {

    public ListNode oddEvenList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode oddHead = new ListNode(0, head);
        ListNode evenHead = new ListNode(0, head);
        ListNode evenHeadSave = evenHead, oddHeadSave = oddHead;

        ListNode dummyHead = new ListNode(0, head);

        boolean isEven = false;

        while (head != null) {
            System.out.println("head is " + head.val);
            if (isEven) {
                evenHead.next = head;
                evenHead = evenHead.next;//  == null ? new ListNode(0) : evenHead.next;
                System.out.println("evenHead is " + evenHead.val);
            } else {
                oddHead.next = head; // 1 ->
                oddHead = oddHead.next;// == null ? new ListNode(0) : oddHead.next;
                System.out.println("oddHead is " + oddHead.val);
            }
            isEven = !isEven;
            head = head.next;
        }

        dummyHead.next = oddHeadSave.next;
        oddHead.next = evenHeadSave.next;
        evenHead.next = null;

        return dummyHead.next;
    }

    public static void main(String[] args) {

        OddEvenList oddEvenList = new OddEvenList();
        System.out.println(" oddEvenList.oddEvenList() should be [1,3,2,4] and the result is  "
                + oddEvenList.oddEvenList(new ListNode(1, new ListNode(2,
                new ListNode(3, new ListNode(4))))));

        System.out.println(" oddEvenList.oddEvenList() should be [1,3,5,2,4] and the result is  "
                + oddEvenList.oddEvenList(new ListNode(1,
                new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))))));
    }
}
