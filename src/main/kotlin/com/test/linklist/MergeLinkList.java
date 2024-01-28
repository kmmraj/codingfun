package com.test.linklist;

import com.test.ListNode;

/**
 * You are given the heads of two sorted linked lists list1 and list2.
 *
 * Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.
 *
 * Return the head of the merged linked list.
 *
 * Example 1:

 * Input: list1 = [1,2,4], list2 = [1,3,4]
 * Output: [1,1,2,3,4,4]
 *
 * Example 2:
 * Input: list1 = [], list2 = []
 * Output: []
 *
 * Example 3:
 * Input: list1 = [], list2 = [0]
 * Output: [0]
 *
 *
 * Constraints:
 *
 * The number of nodes in both lists is in the range [0, 50].
 * -100 <= Node.val <= 100
 * Both list1 and list2 are sorted in non-decreasing order.
 */
public class MergeLinkList {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode resultNode = new ListNode(0);
        ListNode l1 = list1, l2 = list2, startNode = resultNode;

        // System.out.println("resultNode is "+resultNode.val + " next "+resultNode.next );

        while(l1 != null && l2!=null){
            if(l1.val < l2.val){
                resultNode.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                resultNode.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            resultNode = resultNode.next;
        }

        if(l1 != null){
            resultNode.next = l1;
        }
        if(l2 != null){
            resultNode.next = l2;
        }
        return startNode.next;
    }

    public static void main(String[] args) {
        MergeLinkList mergeLinkList = new MergeLinkList();
        System.out.println("mergeLinkList.mergeTwoLists(new ListNode(1, new ListNode(2, new ListNode(4))), " +
                "new ListNode(1, new ListNode(3, new ListNode(4)))) should be [1,1,2,3,4,4] and result is "
                + mergeLinkList.mergeTwoLists(new ListNode(1, new ListNode(2, new ListNode(4))),
                new ListNode(1, new ListNode(3, new ListNode(4)))) );
        System.out.println("mergeLinkList.mergeTwoLists(new ListNode(0), " +
                "new ListNode(1) should be [0,1] and result is "
                + mergeLinkList.mergeTwoLists(new ListNode(0), new ListNode(1)) );
        System.out.println("mergeLinkList.mergeTwoLists(new ListNode(1), " +
                "new ListNode(0) should be [0,1] and result is "
                + mergeLinkList.mergeTwoLists(new ListNode(1), new ListNode(0)) );
        System.out.println("mergeLinkList.mergeTwoLists(new ListNode(7), " +
                "new ListNode(2,new ListNode(4)) should be [2,4,7] and result is "
                + mergeLinkList.mergeTwoLists(new ListNode(7), new ListNode(2,new ListNode(4))) );
    }

}
