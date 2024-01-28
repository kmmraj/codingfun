package com.test.linklist;
// https://leetcode.com/problems/palindrome-linked-list/description/
/**
 * 234. Palindrome Linked List
 * Given the head of a singly linked list, return true if it is a
 * palindrome
 *  or false otherwise.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: head = [1,2,2,1]
 * Output: true
 * Example 2:
 *
 *
 * Input: head = [1,2]
 * Output: false
 *
 *
 * Constraints:
 *
 * The number of nodes in the list is in the range [1, 105].
 * 0 <= Node.val <= 9
 *
 *
 * Follow up: Could you do it in O(n) time and O(1) space?
 */

import com.test.ListNode;

import java.util.Stack;

public class CheckPalindromeInLinkedList {
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head;
        // Reach the first half
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // System.out.println("slow val is "+slow.val);

        // Reverse the second half
        ListNode reversedList = reverse(slow);

        ListNode headPtr = head;

        // Commpare reversedList and the head

        while (reversedList != null && headPtr != null) {
            if (reversedList.val != headPtr.val) {
                return false;
            }
            reversedList = reversedList.next;
            headPtr = headPtr.next;
        }
        return true;
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null, tempNext;
        while (head != null) {
            tempNext = head.next;
            head.next = prev;
            prev = head;
            head = tempNext;
        }
        return prev;
    }

    public boolean isPalindrome2(ListNode head) {

        if(head == null || head.next == null ){
            return true;
        }
        ListNode slow = head, fast = head;
        Stack<ListNode> stack = new Stack<>();
        // Reach the first half
        while (fast != null && fast.next != null) {
            stack.push(slow);
            slow = slow.next;
            fast = fast.next.next;
        }

        // Don't push the center element of the odd list
        if (fast != null) {
            slow = slow.next;
        }

        while(slow != null){
            if(stack.isEmpty()|| stack.pop().val != slow.val){
                return false;
            }
            slow = slow.next;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("CheckPalindromeInLinkedList().isPalindrome(null) should be true and the result is "
                + new CheckPalindromeInLinkedList().isPalindrome(null));
        System.out.println("CheckPalindromeInLinkedList().isPalindrome(new ListNode(1)) should be true " +
                "and the result is "
                + new CheckPalindromeInLinkedList().isPalindrome(new ListNode(1)));
        System.out.println("CheckPalindromeInLinkedList().isPalindrome(new ListNode(1, new ListNode(2," +
                " new ListNode(3)))) should be false and the result is "
                + new CheckPalindromeInLinkedList().isPalindrome(new ListNode(1,
                new ListNode(2, new ListNode(3)))));

        System.out.println("CheckPalindromeInLinkedList().isPalindrome(new ListNode(1, " +
                "new ListNode(2, new ListNode(2, new ListNode(1)))) should be true and the result is "
                + new CheckPalindromeInLinkedList().isPalindrome(new ListNode(1,
                new ListNode(2, new ListNode(2, new ListNode(1))))));

        System.out.println("CheckPalindromeInLinkedList().isPalindrome2(new ListNode(1, " +
                "new ListNode(2, new ListNode(2, new ListNode(1)))) should be true and the result is "
                + new CheckPalindromeInLinkedList().isPalindrome2(new ListNode(1,
                new ListNode(2, new ListNode(2, new ListNode(1))))));

        System.out.println("CheckPalindromeInLinkedList().isPalindrome(new ListNode(1, " +
                "new ListNode(2, new ListNode(3, new ListNode(2, new ListNode(1)))))) should be true and the result is "
                + new CheckPalindromeInLinkedList().isPalindrome(new ListNode(1,
                new ListNode(2, new ListNode(3, new ListNode(2, new ListNode(1)))))));

        System.out.println("CheckPalindromeInLinkedList().isPalindrome2(new ListNode(1, " +
                "new ListNode(2, new ListNode(3, new ListNode(2, new ListNode(1)))))) should be true and the result is "
                + new CheckPalindromeInLinkedList().isPalindrome2(new ListNode(1,
                new ListNode(2, new ListNode(3, new ListNode(2, new ListNode(1)))))));
    }


}
