package com.test.linklist;

import com.test.ListNode;

public class RemoveDupsInSortedLinkedList {

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



    }
}
