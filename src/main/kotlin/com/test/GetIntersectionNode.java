package com.test;

import java.util.HashSet;
import java.util.Set;

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

    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        Set<ListNode> listNodeSet = new HashSet<>();
        while (headA != null || headB != null) {
            if (headA != null) {
                if (listNodeSet.add(headA)) {
                    headA = headA.next;
                } else {
                    return headA;
                }
            }

            if (headB != null) {
                if (listNodeSet.add(headB)) {
                    headB = headB.next;
                } else {
                    return headB;
                }
            }

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


        // list one
        ListNode aN1 = new ListNode(1);
        ListNode aN2 = new ListNode(2,aN1);
        ListNode aN3 = new ListNode(3,aN2);

        // list two
        ListNode bN1 = new ListNode(11,aN2);
        ListNode bN2 = new ListNode(12,bN1);
        ListNode bN3 = new ListNode(13,bN2);

        System.out.println(" Intersection should be at  aN2 (2) and result is " +intersectionNode.getIntersectionNode2(aN3,bN3).val);





    }
}
