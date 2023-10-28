// https://leetcode.com/problems/reverse-nodes-in-k-group/description/
package com.test.linklist;

import com.test.ListNode;

import java.util.Stack;

public class ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {

        Stack<ListNode> stack = new Stack<>();

        ListNode headNode = null, prevNode = null;
        ListNode tempNode, lastHeadNode;
        boolean firstRun = true;

        while (head != null) {
            int count = 0;

            lastHeadNode = head;
            while (count < k && head != null) {
                stack.add(head);
                head = head.next;
                count++;
            }

            if (count < k || stack.isEmpty()) {
                // This means - it is the last run
                if (prevNode != null) {
                    prevNode.next = lastHeadNode;
                }
                break;
            }

            if (firstRun) {
                // This is the first run
                prevNode = stack.pop();
                headNode = prevNode;
                firstRun = false;
            } else {
                tempNode = stack.pop();
                prevNode.next = tempNode;
                prevNode = tempNode;
            }

            while (!stack.isEmpty()) {
                // Rest of the items
                tempNode = stack.pop();
                tempNode.next = null;
                prevNode.next = tempNode;
                prevNode = tempNode;
            }
        }
        return headNode;
    }

    public static void main(String[] args) {
        //Input: head = [1,2,3,4,5], k = 2
        //Output: [2,1,4,3,5]
        //Example
        //2:
        //
        //Input: head = [1,2,3,4,5], k = 3
        //Output: [3,2,1,4,5]
        //Example
        //3:
        //
        //Input: head = [1,2,3,4,5], k = 1
        //Output: [1,2,3,4,5]
        //Example
        //4:
        //
        //Input: head = [1], k = 1
        //Output: [1]
        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode head = new ListNode(1, node2);

        ListNode resultNode;
//        resultNode = new ReverseNodesInKGroup().reverseKGroup(head, 3);
//        System.out.println("Result node: " + resultNode);

        resultNode = new ReverseNodesInKGroup().reverseKGroup(head, 2);
        System.out.println("Result node: " + resultNode);
    }
}
