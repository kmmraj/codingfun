package com.test.linklist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveDupsInSortedLinkList {

    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public LinkedList removeDuplicatesFromLinkedList(LinkedList linkedList) {
        // Write your code here.
        int existingVal = Integer.MIN_VALUE;
        LinkedList head = linkedList;
        LinkedList prev = null;
        while (linkedList!=null){
            if(existingVal == linkedList.value){
                // && linkedList.next !=null
                prev.next = linkedList.next;
                linkedList = linkedList.next;
            } else {
                existingVal = linkedList.value;
                prev =linkedList;
                linkedList = linkedList.next;
            }
        }
        return head;
    }

    public RemoveDupsInSortedLinkList.LinkedList addMany(RemoveDupsInSortedLinkList.LinkedList ll, List<Integer> values) {
        RemoveDupsInSortedLinkList.LinkedList current = ll;
        while (current.next != null) {
            current = current.next;
        }
        for (int value : values) {
            current.next = new RemoveDupsInSortedLinkList.LinkedList(value);
            current = current.next;
        }
        return ll;
    }

    public List<Integer> getNodesInArray(RemoveDupsInSortedLinkList.LinkedList ll) {
        List<Integer> nodes = new ArrayList<Integer>();
        RemoveDupsInSortedLinkList.LinkedList current = ll;
        while (current != null) {
            nodes.add(current.value);
            current = current.next;
        }
        return nodes;
    }

    public static void main(String[] args) {
        RemoveDupsInSortedLinkList dups = new RemoveDupsInSortedLinkList();
        RemoveDupsInSortedLinkList.LinkedList input = new RemoveDupsInSortedLinkList.LinkedList(1);
        dups.addMany(input, new ArrayList<Integer>(Arrays.asList(1, 3, 4, 4, 4, 5, 6, 6)));
        RemoveDupsInSortedLinkList.LinkedList output = dups.removeDuplicatesFromLinkedList(input);
        while (output!=null){
            System.out.printf("%2d ",output.value);
            output = output.next;
        }
    }

//    @Test
//    public void TestCase1() {
//        RemoveDupsInSortedLinkList.LinkedList input = new RemoveDupsInSortedLinkList.LinkedList(1);
//        addMany(input, new ArrayList<Integer>(Arrays.asList(1, 3, 4, 4, 4, 5, 6, 6)));
//        List<Integer> expectedNodes = new ArrayList<Integer>(Arrays.asList(1, 3, 4, 5, 6));
//        Utils.assertTrue(getNodesInArray(output).equals(expectedNodes));
//    }
}
