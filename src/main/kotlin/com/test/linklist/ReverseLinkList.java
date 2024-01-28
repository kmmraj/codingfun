package com.test.linklist;
// https://leetcode.com/problems/reverse-linked-list/description/
/**
 * 206. Reverse Linked List
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 * Example 1:
 *
 * Input: head = [1,2,3,4,5]
 * Output: [5,4,3,2,1]
 *
 * Example 2:
 *
 * Input: head = [1,2]
 * Output: [2,1]
 *
 * Example 3:
 *
 * Input: head = []
 * Output: []
 *
 *
 * Constraints:
 *
 * The number of nodes in the list is the range [0, 5000].
 * -5000 <= Node.val <= 5000
 *
 *
 * Follow up: A linked list can be reversed either iteratively or recursively. Could you implement both?
 */

import com.test.ListNode;

import java.util.Stack;

public class ReverseLinkList {
    public ListNode reverseList(ListNode head) {
        ListNode listNode = new ListNode(-1,head);
        Stack<ListNode>  stack = new Stack<ListNode>();
        do {
            listNode = listNode.next;
            ListNode temp = new ListNode(listNode.val,null);
            stack.add(temp);
        } while (listNode.next != null);

        ListNode returnListNode = new ListNode();
        ListNode prevListNode = null;
        ListNode newListNode;
        do {
            ListNode temp = stack.pop();
            newListNode = new ListNode(temp.val,null);
            if(prevListNode != null)
                prevListNode.next = newListNode;
            else
                returnListNode.next = newListNode;

            prevListNode = newListNode;
        } while (!stack.isEmpty());

        return returnListNode.next;
    }

    public ListNode reverseList1(ListNode head) {
        ListNode prev = null, tempNext = null;

        while(head != null){
            //
            tempNext = head.next;
            head.next = prev;
            prev = head;
            head = tempNext;
        }
        return prev;
    }

    public ListNode reverseList2(ListNode head) {
        ListNode prev = null;
        return reverseList(head, prev);
    }

    private ListNode reverseList(ListNode head,
                                 ListNode prev) {
        // BC
        if (head == null)
            return prev;

        // H & I
        ListNode tempNext = head.next;
        head.next = prev;
        return reverseList(tempNext, head);
    }


    public ListNode reverseListInOnePass(ListNode head) {
        ListNode listNode = new ListNode(-1, head);
        ListNode returnListNode = new ListNode(-1, null);
        ListNode currentListNode, lastListNode = null;
        do {
            listNode = listNode.next;
            currentListNode = new ListNode(listNode.val, null);
            if(lastListNode != null){
                // Second time onwards
                currentListNode.next = lastListNode;
            }
            lastListNode = currentListNode;

        } while(listNode.next != null);
        returnListNode.next = lastListNode;
        return returnListNode.next;
    }

    public ListNode reverseListWRecursion(ListNode head) {
        ListNode listNode = new ListNode(-1, head);
        ListNode subListNode = new ListNode(-1, null);
        ListNode returnListNode;
        ListNode workListNode = new ListNode(-1, null);

//        returnListNode = reverseIt(head, workListNode);
        reverseIt(head, workListNode,null);

        return workListNode.next;
    }

    public void reverseIt(ListNode head, ListNode returnListNode,ListNode subListNode){
        // Base condition
        if(head.next == null) {
            ListNode currentListNode = new ListNode(head.val, null);
            currentListNode.next = subListNode;
            subListNode =  currentListNode;
            returnListNode.next = subListNode;
            return;
        }

        // Induction
        ListNode currentListNode = new ListNode(head.val, null);
        currentListNode.next = subListNode;
        subListNode = currentListNode;
        // Hypothesis
        reverseIt(head.next,returnListNode,subListNode);

    }

    public static void main(String[] args) {

        ListNode l6 = new ListNode(6);
        ListNode l5 = new ListNode(5,l6);
        ListNode l4 = new ListNode(4,l5);
        ListNode l3 = new ListNode(3,l4);
        ListNode l2 = new ListNode(2,l3);
        ListNode l1 = new ListNode(1,l2);

        ReverseLinkList reverseLinkList = new ReverseLinkList();

        ListNode reversedLN = new ListNode(-1);
//        reversedLN.next = reverseLinkList.reverseList(l1);
//        reversedLN.next = reverseLinkList.reverseListInOnePass(l1);
        reversedLN.next = reverseLinkList.reverseListWRecursion(l1);
        do {
            reversedLN = reversedLN.next;
            System.out.println(reversedLN.val);
        } while (reversedLN.next != null);


        System.out.println("reverseLinkList.reverseList(new ListNode(1, new ListNode(2, new ListNode(3)))) "
                + "should be [3,2,1] and result is "
                + reverseLinkList.reverseList1(new ListNode(1, new ListNode(2, new ListNode(3)))) );
        System.out.println("reverseLinkList.reverseList(new ListNode(1, new ListNode(2))) "
                + "should be [2,1] and result is "
                + reverseLinkList.reverseList1(new ListNode(1, new ListNode(2))) );
        System.out.println("reverseLinkList.reverseList(new ListNode(1)) "
                + "should be [1] and result is "
                + reverseLinkList.reverseList1(new ListNode(1)) );
        System.out.println("reverseLinkList.reverseList(new ListNode(1, new ListNode(2, new ListNode(3, "
                + "new ListNode(4, new ListNode(5)))))) "
                + "should be [5,4,3,2,1] and result is "
                + reverseLinkList.reverseList1(new ListNode(1, new ListNode(2, new ListNode(3,
                new ListNode(4, new ListNode(5)))))) );


        System.out.println("reverseLinkList.reverseList2(new ListNode(1, new ListNode(2, new ListNode(3)))) "
                + "should be [3,2,1] and result is "
                + reverseLinkList.reverseList2(new ListNode(1, new ListNode(2, new ListNode(3)))) );
        System.out.println("reverseLinkList.reverseList2(new ListNode(1, new ListNode(2))) "
                + "should be [2,1] and result is "
                + reverseLinkList.reverseList2(new ListNode(1, new ListNode(2))) );
        System.out.println("reverseLinkList.reverseList2(new ListNode(1)) "
                + "should be [1] and result is "
                + reverseLinkList.reverseList2(new ListNode(1)) );
        System.out.println("reverseLinkList.reverseList2(new ListNode(1, new ListNode(2, new ListNode(3, "
                + "new ListNode(4, new ListNode(5)))))) "
                + "should be [5,4,3,2,1] and result is "
                + reverseLinkList.reverseList2(new ListNode(1, new ListNode(2, new ListNode(3,
                new ListNode(4, new ListNode(5)))))) );
    }
}
