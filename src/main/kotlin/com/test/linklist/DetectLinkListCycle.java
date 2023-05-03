package com.test.linklist;

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
    }
}
