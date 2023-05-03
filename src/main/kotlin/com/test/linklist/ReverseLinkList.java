package com.test.linklist;

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
    }
}
