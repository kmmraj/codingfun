package com.test.linklist;

import com.test.ListNode;

public class MiddleLinkedList {

    public ListNode middleNode(ListNode head) {


        // Border condition #1
        if(head.next == null){
            return head;
        }

        // Border condition #2
        if(head.next.next == null){
            return head.next;
        }

        ListNode [] listArray =  new ListNode[100];
        int size = 0;
        int middle;
        do {
            listArray[size] = head;
            size = size+1;
            head = head.next;
        } while (head.next != null);
        middle =  size/2 + (size%2);


        return listArray[middle];
    }

    public static void main(String[] args) {

        MiddleLinkedList middleLinkedList = new MiddleLinkedList();

        ListNode l6 = new ListNode(6);
        ListNode l5 = new ListNode(5,l6);
        ListNode l4 = new ListNode(4,l5);
        ListNode l3 = new ListNode(3,l4);
        ListNode l2 = new ListNode(2,l3);
        ListNode l1 = new ListNode(1,l2);
        ListNode answer;


        // TC#0
        answer= middleLinkedList.middleNode(l6);
        System.out.println(answer.val);

        // TC#1
        answer= middleLinkedList.middleNode(l1);
        System.out.println(answer.val);

        // TC#2
        answer= middleLinkedList.middleNode(l5);
        System.out.println(answer.val);

    }
}
