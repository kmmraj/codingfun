package com.test.tree;

import java.util.LinkedList;

// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}

public class PopulateRightNextPtrInEachNode {

    //Input: root = [1,2,3,4,5,6,7]
    //Output: [1,#,2,3,#,4,5,6,7,#]
    public Node connect(Node root) {
        if (root == null) return null;

        LinkedList<Node> queue = new LinkedList<>();
        queue.add(root);
        Node prevNode;
        Node tempNode = null;

        while (!queue.isEmpty()) {

            int queueSize = queue.size();
            for (int idx = 0; idx < queueSize; idx++) {
                prevNode = tempNode;
                tempNode = queue.pop();
                if (idx > 0) {
                    prevNode.next = tempNode;
                }
                if (tempNode.left != null) {
                    queue.add(tempNode.left);
                }
                if (tempNode.right != null) {
                    queue.add(tempNode.right);
                }
            }
            if (tempNode != null) {
                tempNode.next = null;
            }

        }
        return root;
    }

    public static void main(String[] args) {
        //Example 1:
        //
        //
        //Input: root = [1,2,3,4,5,6,7]
        //Output: [1,#,2,3,#,4,5,6,7,#]
        Node node7 = new Node(7);
        Node node6 = new Node(6);
        Node node5 = new Node(5);
        Node node4 = new Node(4, node7, null, null);
        Node node3 = new Node(3, node6, null, null);
        Node node2 = new Node(2, node4, node5, null);
        Node root = new Node(1, node2, node3, null);

        Node connectedNode = new PopulateRightNextPtrInEachNode().connect(root);
        System.out.println("Connected node: " + connectedNode);
    }
}
