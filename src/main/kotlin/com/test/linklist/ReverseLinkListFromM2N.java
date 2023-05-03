package com.test.linklist;


import com.test.ListNode;

public class ReverseLinkListFromM2N {

        public ListNode reverseBetween(ListNode head, int m, int n) {
            ListNode copyListNode = new ListNode(-1,head);
            int indx = 1;
            ListNode returnListNode = new ListNode(-1);
            ListNode returnListNodeHead = returnListNode; // Head of returnListNode
            ListNode subListNode = null;
            ListNode tempListNode;
            ListNode subListLastNode = null;
            ListNode endListNode = null;

            if(m==n) return head;
            do {
                copyListNode = copyListNode.next;
                if(indx < m){
                    tempListNode = new ListNode(copyListNode.val,null);
                    returnListNode.next = tempListNode;
                    returnListNode = returnListNode.next;
                    indx++;
                }  else if(indx == m){
                    subListLastNode = subListNode = new ListNode(copyListNode.val, null);
                    indx++;
                } else if(indx <=n){
                    tempListNode = subListNode;
                    subListNode = new ListNode(copyListNode.val,tempListNode);
                    if(indx == n)
                        returnListNode.next = subListNode;
                    indx++;
                } else {
                    tempListNode = new ListNode(copyListNode.val, null);
                    if(indx == n+1){
                        subListLastNode.next = tempListNode;
                        endListNode = tempListNode;
                    }else {
                        endListNode.next = tempListNode;
                        endListNode = endListNode.next;
                    }

                    indx++;
                }

            } while (copyListNode.next != null);

            return  returnListNodeHead.next;

        }



    public static void main(String[] args) {
        ReverseLinkListFromM2N fromM2N = new ReverseLinkListFromM2N();

        ListNode l6 = new ListNode(6);
        ListNode l5 = new ListNode(5,l6);
        ListNode l4 = new ListNode(4,l5);
        ListNode l3 = new ListNode(3,l4);
        ListNode l2 = new ListNode(2,l3);
        ListNode l1 = new ListNode(1,l2);

        ListNode reversedLN = new ListNode(-1);
        reversedLN.next = fromM2N.reverseBetween(l1,3,6);
        do {
            reversedLN = reversedLN.next;
            System.out.println(reversedLN.val);
        } while (reversedLN.next != null);

    }
}
