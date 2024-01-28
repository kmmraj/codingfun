package com.test.linklist;
// https://leetcode.com/problems/linked-list-cycle-ii/
/**
 * 142. Linked List Cycle II
 * Given the head of a linked list, return the node where the cycle begins. If there is no cycle, return null.
 * There is a cycle in a linked list if there is some node in the list that can be reached again
 * by continuously following the next pointer. Internally, pos is used to denote the index of the node
 * that tail's next pointer is connected to (0-indexed). It is -1 if there is no cycle.
 * Note that pos is not passed as a parameter.
 *
 * Do not modify the linked list.
 *
 * Example 1:
 * Input: head = [3,2,0,-4], pos = 1
 * Output: tail connects to node index 1
 * Explanation: There is a cycle in the linked list, where tail connects to the second node.
 *
 * Example 2:
 * Input: head = [1,2], pos = 0
 * Output: tail connects to node index 0
 * Explanation: There is a cycle in the linked list, where tail connects to the first node.
 *
 * Example 3:
 * Input: head = [1], pos = -1
 * Output: no cycle
 * Explanation: There is no cycle in the linked list.
 *
 *
 * Constraints:
 *
 * The number of the nodes in the list is in the range [0, 104].
 * -105 <= Node.val <= 105
 * pos is -1 or a valid index in the linked-list.
 *
 *
 * Follow up: Can you solve it using O(1) (i.e. constant) memory?
 */

import com.test.ListNode;

import java.util.HashSet;

public class DetectLinkListCycle {

    public boolean hasCycle(ListNode head) {

        HashSet<ListNode> set = new HashSet<ListNode>();

        while (head!= null && head.next != null){
            if(set.contains(head.next))
                return true;
            set.add(head);
            head = head.next;
        }
        return false;
    }

    public boolean hasCycleFast(ListNode head) {

        if(head == null || head.next == null)
            return false;

        ListNode slow = head;
        ListNode fast = head.next.next;

        while (slow != head){
            if(fast == null || fast.next == null)
                return false;
            slow = slow.next;
            fast = fast.next.next;
        }

        return true;
    }

    public ListNode detectCycle(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();

        while (head!= null && head.next != null){
            if(set.contains(head.next)) {
               return head.next;
            }
            set.add(head);
            head = head.next;
        }
        return null;
    }

    public ListNode detectCycle2(ListNode head) {
        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null) {
            //System.out.println("slow is " + slow.val + " fast is " + fast.val);
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                // System.out.println("Matching slow is " + slow.val + " fast is " + fast.val);
                break;
                // return slow;
            }
        }
        if (fast == null || fast.next == null) {
            return null;
        }

        // System.out.println("slow is " + slow.val + " head is " + head.val);

        while (head != slow) {
            head = head.next;
            slow = slow.next;
            // System.out.println("Check matching slow is " + slow.val + " head is " + head.val);
        }

        return slow;

    }

    public static void main(String[] args) {

        ListNode l6 = new ListNode(6);
        ListNode l5 = new ListNode(5,l6);
        ListNode l4 = new ListNode(4,l5);
        ListNode l3 = new ListNode(3,l4);
        ListNode l2 = new ListNode(2,l3);
        ListNode l1 = new ListNode(1,l2);
        l6.next = l2;
        DetectLinkListCycle cycle = new DetectLinkListCycle();
        boolean doesCycleExist = cycle.hasCycleFast(l1);
        System.out.println(doesCycleExist ?"Cycle exist" : "Cycle does not exist");

        System.out.println("cycle.detectCycle(new ListNode(1, new ListNode(2, new ListNode(3)))) should be null and result is "
                + cycle.detectCycle(new ListNode(1, new ListNode(2, new ListNode(3)))) );

        System.out.println("cycle.detectCycle2(new ListNode(1, new ListNode(2, new ListNode(3)))) should be null and result is "
                + cycle.detectCycle2(new ListNode(1, new ListNode(2, new ListNode(3)))) );

        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        listNode.next.next.next.next = listNode.next;

        System.out.println("cycle.detectCycle(listNode) should be 2 and result is "
                + cycle.detectCycle(listNode).val );
    }
}
