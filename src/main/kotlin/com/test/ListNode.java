package com.test;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        ListNode listNode = this;
        while (listNode != null) {
            output.append(listNode.val).append("->");
            listNode = listNode.next;
        }
        return output.toString();
    }
}
