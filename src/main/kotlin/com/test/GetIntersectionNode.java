package com.test;

import java.util.HashSet;

public class GetIntersectionNode {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode result = new ListNode();
        ListNode headBCopy = headB;
        while (headA != null){
            headB =  headBCopy;
            while (headB  != null && headA != headB){
                headB = headB.next;
            }

            if(headA == headB) {
                result = headB;
                return result;
            }

            headA = headA.next;
        }
        return result;

    }

    public ListNode getIntersectionNodeWithHashSet(ListNode headA, ListNode headB) {

        HashSet<ListNode> listNodeSetA = new HashSet<ListNode>();
        while (headA != null){
           listNodeSetA.add(headA);
           headA = headA.next;
        }

        while (headB != null){
            if(listNodeSetA.contains(headB)) {
                return headB;
            }
            headB  = headB.next;
        }
        return null;

    }

    public static void main(String[] args) {

        // list one
        ListNode l8 = new ListNode(13);
        ListNode l7 = new ListNode(11,l8);
        ListNode l6 = new ListNode(10,l7);

        // list two
        ListNode l5 = new ListNode(5);
        ListNode l4 = new ListNode(4,l5);
        ListNode l3 = new ListNode(3,l4);
        ListNode l2 = new ListNode(2,l3);
        ListNode l1 = new ListNode(1,l2);

        l6.next = l2;

        GetIntersectionNode intersectionNode = new GetIntersectionNode();
       // ListNode result = intersectionNode.getIntersectionNode(l1,l6);
        ListNode result = intersectionNode.getIntersectionNodeWithHashSet(l1,l6);

        System.out.println(result.val);




    }
}
