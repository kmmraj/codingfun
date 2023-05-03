package com.test.linklist;

import java.util.HashSet;
import java.util.Set;

public class IntersectingNode {

    static SingleLinkList singleLinkList1;
    static SingleLinkList singleLinkList2;

    public static void main(String[] args) {
        singleLinkList1 = new SingleLinkList(3);
        singleLinkList1.add(1);
        singleLinkList1.add(5);
        singleLinkList1.add(9);

        singleLinkList2 = new SingleLinkList(2);
        singleLinkList2.add(4);
        singleLinkList2.add(6);

        addSameNode(singleLinkList1, singleLinkList2, 7);
        addSameNode(singleLinkList1, singleLinkList2, 2);
        addSameNode(singleLinkList1, singleLinkList2, 1);

        SingleLinkList.Node intersectingNode = findIntersection(singleLinkList1, singleLinkList2);
        System.out.println("intersectingNode is : " + intersectingNode.data);


        singleLinkList1 = new SingleLinkList(3);
        singleLinkList1.add(1);
        singleLinkList1.add(5);


        singleLinkList2 = new SingleLinkList(2);
        singleLinkList2.add(4);
        singleLinkList2.add(6);
        singleLinkList1.add(9);
        singleLinkList1.add(9);

        addSameNode(singleLinkList1, singleLinkList2, 5);
        addSameNode(singleLinkList1, singleLinkList2, 2);
        addSameNode(singleLinkList1, singleLinkList2, 1);

        SingleLinkList.Node intersectingNode2 = findIntersection(singleLinkList1, singleLinkList2);
        System.out.println("intersectingNode is : " + intersectingNode2.data);


    }

    private static SingleLinkList.Node findIntersection(SingleLinkList singleLinkList1, SingleLinkList singleLinkList2) {
        Set<SingleLinkList.Node> uniqueSet = new HashSet<>();
        SingleLinkList.Node currentNode1 = singleLinkList1.head;
        SingleLinkList.Node currentNode2 = singleLinkList2.head;

        // Will insert both link list, if the value is matching then compare the node itself
        while (currentNode1 != null || currentNode2 != null) {
            if (currentNode1 != null && uniqueSet.add(currentNode1)) {
                currentNode1 = currentNode1.next;
            } else {
                return currentNode1;
            }

            if (currentNode2 != null && uniqueSet.add(currentNode2)) {
                currentNode2 = currentNode2.next;
            } else {
                return currentNode2;
            }

        }

        return null;
    }

    private static void addSameNode(SingleLinkList singleLinkList1, SingleLinkList singleLinkList2, int data) {
        SingleLinkList.Node newNode = new SingleLinkList.Node(data);
        singleLinkList1.tail.next = newNode;
        singleLinkList2.tail.next = newNode;
        singleLinkList1.tail = newNode;
        singleLinkList2.tail = newNode;
    }

}
