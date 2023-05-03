package com.test.linklist;

import java.util.Stack;

public class FindKthElementFromEnd {


    SingleLinkList singleLinkList;
    public FindKthElementFromEnd(SingleLinkList singleLinkList) {
        this.singleLinkList = singleLinkList;
    }


    public static void main(String[] args) {

        SingleLinkList singleLinkList = new SingleLinkList(1);
        singleLinkList.add(2);
        singleLinkList.add(3);
        singleLinkList.add(4);
        singleLinkList.add(5);
        singleLinkList.add(6);
        FindKthElementFromEnd findKthElementFromEnd = new FindKthElementFromEnd(singleLinkList);

        System.out.println("K th element from End is "+ findKthElementFromEnd.find(2));
        findKthElementFromEnd.remove(2);
        singleLinkList.printAll();
        findKthElementFromEnd.remove(3);
        singleLinkList.printAll();

    }

    private void remove(int kFromEnd) {
        SingleLinkList.Node firstNode = this.singleLinkList.head;
        SingleLinkList.Node secondNode = this.singleLinkList.head;

        // kFromEnd is 2
        // Two pointer
        // 1 -> 2 -> 3 -> 4 -> 5 -> 6
        // secondNode.data = 3 (for K=3)
        // 1 -> 2 -> 3 -> 4 -> 5 -> 6
        //           ^
        //           |
        //  while (secondNode!=null)
        // 1 -> 2 -> 3 -> 4 -> 5 -> 6
        // ^         ^
        // |         |
        // 1st       2nd

        // 1 -> 2 -> 3 -> 4 -> 5 -> 6
        //      ^         ^
        //      |         |
        //     1st       2nd

        // 1 -> 2 -> 3 -> 4 -> 5 -> 6
        //                ^         ^
        //                |         |
        //               1st       2nd

        for (int indx = 0; indx < kFromEnd; indx++) {
            secondNode = secondNode.next;
        }
        SingleLinkList.Node prevNode = null;
        while (secondNode!=null){
            secondNode = secondNode.next;
            prevNode = firstNode;
            firstNode = firstNode.next;
        }
        assert firstNode != null;
        assert prevNode != null;
        prevNode.next = firstNode.next;
    }

    private int find(final int value) {
        Stack<Integer> stack = new Stack<>();
        int counter = value;
        SingleLinkList.Node tempNode = this.singleLinkList.head;
        while (tempNode != null){
            stack.add(tempNode.data);
            tempNode = tempNode.next;
        }
        int foundValue = Integer.MIN_VALUE;
        while (counter > 0){
            foundValue = stack.pop();
            counter--;
        }

        System.out.println(foundValue);
        return foundValue;

    }
}
