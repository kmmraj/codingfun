package com.test.recursion;

import com.test.ListNode;

public class ReverseLinkedListNew {

    public void reverseIt(ListNode listNode){

        // BC
        if(listNode.next == null){
            return;
        }

        //  Hypothesis
        ListNode lastValue = new ListNode(listNode.val);
        listNode =  listNode.next;
        reverseIt(listNode);

        ListNode returnList = new ListNode();
        // Induction
        insertIt(listNode, returnList, lastValue);

    }

    private void insertIt(ListNode listNode, ListNode returnList, ListNode lastValue) {
        // BC
        if(listNode.next == null){
            returnList.next = listNode;
            return;
        }

        // Hypothesis
        ListNode  tempListNode = new ListNode(listNode.val);
        listNode = listNode.next;
        returnList =  returnList.next;
        insertIt(listNode,returnList, lastValue);
//
//        // Induction
        tempListNode.next = lastValue;
        returnList.next = tempListNode;
      //  tempListNode.next = returnList; // listValue?
//        listNode.next = lastValue;
    }

//    public ListNode reverseList(ListNode head) {
//        ListNode prev = null;
//        ListNode curr = head;
//        while (curr != null) {
//            ListNode nextTemp = curr.next;
//            curr.next = prev;
//            prev = curr;
//            curr = nextTemp;
//        }
//        return prev;
//    }

    public ListNode reverseList(ListNode head) {
        //BC
        if (head == null || head.next == null)
            return head;

        // Hypothesis
        ListNode p = reverseList(head.next);

        // Induction
        head.next.next = head;
        head.next = null;
        return p;
    }


    public static void main(String[] args) {

        ListNode l6 = new ListNode(6);
        ListNode l5 = new ListNode(5,l6);
        ListNode l4 = new ListNode(4,l5);
        ListNode l3 = new ListNode(3,l4);
        ListNode l2 = new ListNode(2,l3);
        ListNode l1 = new ListNode(1,l2);

        ReverseLinkedListNew reverseLinkList = new ReverseLinkedListNew();

        ListNode reversedLN = new ListNode(-1);
//        reverseLinkList.reverseIt(l1);
        reversedLN.next = reverseLinkList.reverseList(l1);
        do {
            reversedLN = reversedLN.next;
            System.out.println(reversedLN.val);
        } while (reversedLN.next != null);
    }
}
