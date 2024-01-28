package com.test.linklist;


import com.test.ListNode;

public class ReverseLinkListFromM2N {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode copyListNode = new ListNode(-1, head);
        int indx = 1;
        ListNode returnListNode = new ListNode(-1);
        ListNode returnListNodeHead = returnListNode; // Head of returnListNode
        ListNode subListNode = null;
        ListNode tempListNode;
        ListNode subListLastNode = null;
        ListNode endListNode = null;

        if (m == n) return head;
        do {
            copyListNode = copyListNode.next;
            if (indx < m) {
                tempListNode = new ListNode(copyListNode.val, null);
                returnListNode.next = tempListNode;
                returnListNode = returnListNode.next;
                indx++;
            } else if (indx == m) {
                subListLastNode = subListNode = new ListNode(copyListNode.val, null);
                indx++;
            } else if (indx <= n) {
                tempListNode = subListNode;
                subListNode = new ListNode(copyListNode.val, tempListNode);
                if (indx == n)
                    returnListNode.next = subListNode;
                indx++;
            } else {
                tempListNode = new ListNode(copyListNode.val, null);
                if (indx == n + 1) {
                    subListLastNode.next = tempListNode;
                    endListNode = tempListNode;
                } else {
                    endListNode.next = tempListNode;
                    endListNode = endListNode.next;
                }

                indx++;
            }

        } while (copyListNode.next != null);

        return returnListNodeHead.next;

    }

    public ListNode reverseBetween2(ListNode head, int left, int right) {
        if (left == right)
            return head;

        int index = 0;
        ListNode dummyHead = new ListNode(0, head);
        ListNode prevLeftNode = head;

        // Reach left
        while (++index < left) { // ++index
            prevLeftNode = head;
            head = head.next;
        }

        // Until right
        // 1--> 2 --> 3 --> 4 --> 5 --> 6 --> 7
        // L R
        // 1--> 3 --> 5 --> 4 --> 3 --> 6 --> 7
        ListNode prev = null, leftStartNode = head, tempNext = null;
        // System.out.println("left is " + left + " right is " + right);
        while (left++ <= right) {
            tempNext = head.next;
            head.next = prev;
            prev = head;
            head = tempNext;
        }
        // System.out.println("left is " + left + " head is " + (head != null ? head.val : head)
        //         + " prev is " + prev.val + " prevLeftNode is " + prevLeftNode.val
        //         + " leftStartNode is " + leftStartNode.val);
        // System.out.println(" prevLeftNode is " + prevLeftNode + " leftStartNode is " + leftStartNode);

        if (prevLeftNode == leftStartNode && head == null) { // left is at Head and right is at tail
            dummyHead.next = prev;
        } else if (prevLeftNode == leftStartNode && head != null) { // left is at Head and right is NOT at tail
            dummyHead.next = prev;
            leftStartNode.next = tempNext;
        } else {
            prevLeftNode.next = prev; // headpointer
            leftStartNode.next = tempNext;
        }

        return dummyHead.next;

    }


    public ListNode reverseBetween3(ListNode head, int left, int right) {
        if (left == right)
            return head;

        int index = 1;
        ListNode dummyHead = new ListNode(0, head);
        ListNode prevLeftNode = dummyHead;

        // Reach left
        while (index++ < left) { // index
            prevLeftNode = prevLeftNode.next;
        }

        // Until right
        // 1--> 2 --> 3 --> 4 --> 5 --> 6 --> 7
        //            L           R
        // 1--> 2 --> 5 --> 4 --> 3 --> 6 --> 7
        ListNode subListHead = prevLeftNode.next;
        System.out.println("subListHead is " + subListHead.val);
        while (left++ < right) {
            ListNode tempNext = subListHead.next; // subListHead(3) --> 4 =>
            subListHead.next = tempNext.next; // Move the next of subListHead to 5
            tempNext.next = prevLeftNode.next; // 4--> 3
            prevLeftNode.next = tempNext; // 2--> 4
        }

        return dummyHead.next;

    }


    public static void main(String[] args) {
        ReverseLinkListFromM2N fromM2N = new ReverseLinkListFromM2N();

//        ListNode l6 = new ListNode(6);
//        ListNode l5 = new ListNode(5, l6);
//        ListNode l4 = new ListNode(4, l5);
//        ListNode l3 = new ListNode(3, l4);
//        ListNode l2 = new ListNode(2, l3);
//        ListNode l1 = new ListNode(1, l2);
//
//        ListNode reversedLN = new ListNode(-1);
//        reversedLN.next = fromM2N.reverseBetween(l1, 3, 6);
//        do {
//            reversedLN = reversedLN.next;
//            System.out.println(reversedLN.val);
//        } while (reversedLN.next != null);
//
//
//        System.out.println("fromM2N.reverseBetween(new ListNode(1, new ListNode(2, new ListNode(3))), 1, 2) should be [2,1,3] and result is "
//                + fromM2N.reverseBetween(new ListNode(1, new ListNode(2, new ListNode(3))), 1, 2));
//
//        System.out.println("fromM2N.reverseBetween2(new ListNode(1, new ListNode(2, new ListNode(3))), 1, 2) should be [2,1,3] and result is "
//                + fromM2N.reverseBetween2(new ListNode(1, new ListNode(2, new ListNode(3))), 1, 2));
//
//        System.out.println("fromM2N.reverseBetween3(new ListNode(1, new ListNode(2, new ListNode(3))), 2, 2) should be [1,2,3] and result is "
//                + fromM2N.reverseBetween3(new ListNode(1, new ListNode(2, new ListNode(3))), 1, 2));
//
//        System.out.println("fromM2N.reverseBetween(new ListNode(1, new ListNode(2, new ListNode(3))), 2, 3) should be [1,3,2] and result is "
//                + fromM2N.reverseBetween(new ListNode(1, new ListNode(2, new ListNode(3))), 2, 3));
//
//        System.out.println("fromM2N.reverseBetween2(new ListNode(1, new ListNode(2, new ListNode(3))), 2, 3) should be [1,3,2] and result is "
//                + fromM2N.reverseBetween2(new ListNode(1, new ListNode(2, new ListNode(3))), 2, 3));
//
//        System.out.println("fromM2N.reverseBetween3(new ListNode(1, new ListNode(2, new ListNode(3))), 2, 3) should be [1,3,2] and result is "
//                + fromM2N.reverseBetween3(new ListNode(1, new ListNode(2, new ListNode(3))), 2, 3));
//
//        System.out.println("fromM2N.reverseBetween(new ListNode(1, new ListNode(2, new ListNode(3))), 1, 3) should be [3,2,1] and result is "
//                + fromM2N.reverseBetween(new ListNode(1, new ListNode(2, new ListNode(3))), 1, 3));
//
//        System.out.println("fromM2N.reverseBetween2(new ListNode(1, new ListNode(2, new ListNode(3))), 1, 3) should be [3,2,1] and result is "
//                + fromM2N.reverseBetween2(new ListNode(1, new ListNode(2, new ListNode(3))), 1, 3));
//
//        System.out.println("fromM2N.reverseBetween3(new ListNode(1, new ListNode(2, new ListNode(3))), 1, 3) should be [3,2,1] and result is "
//                + fromM2N.reverseBetween3(new ListNode(1, new ListNode(2, new ListNode(3))), 1, 3));

        // // 1--> 2 --> 3 --> 4 --> 5 --> 6 --> 7  with left 3 and right 5 should be 1--> 2 --> 5 --> 4 --> 3 --> 6 --> 7
        System.out.println("fromM2N.reverseBetween3(new ListNode(1, new ListNode(2, new ListNode(3, " +
                "new ListNode(4, new ListNode(5, new ListNode(6, new ListNode(7))))))), 3, 5) " +
                "should be [1,2,5,4,3,6,7] and result is "
                + fromM2N.reverseBetween3(new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(4,
                                        new ListNode(5,
                                                new ListNode(6,
                                                        new ListNode(7))))))), 3, 5));

    }
}
