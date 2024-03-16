package com.test.tree;
// 10.16 POPULATE THE NEXT RIGHT POINTERS IN EACH NODE
// https://leetcode.com/problems/populating-next-right-pointers-in-each-node/description/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 116. Populating Next Right Pointers in Each Node
 * Medium
 * You are given a perfect binary tree where all leaves are on the same level, and every parent has two children. The binary tree has the following definition:
 * <p>
 * struct Node {
 * int val;
 * Node *left;
 * Node *right;
 * Node *next;
 * }
 * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
 * <p>
 * Initially, all next pointers are set to NULL.
 * <p>
 * Example 1:
 * Input: root = [1,2,3,4,5,6,7]
 * Output: [1,#,2,3,#,4,5,6,7,#]
 * Explanation: Given the above perfect binary tree (Figure A), your function should populate each next pointer
 * to point to its next right node, just like in Figure B.
 * The serialized output is in level order as connected by the next pointers, with '#' signifying the end of each level.
 * <p>
 * Example 2:
 * Input: root = []
 * Output: []
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the tree is in the range [0, 212 - 1].
 * -1000 <= Node.val <= 1000
 * <p>
 * <p>
 * Follow-up:
 * <p>
 * You may only use constant extra space.
 * The recursive approach is fine. You may assume implicit stack space does not count as extra space for this problem.
 */

public class PopulateNextRightPointersEachNode {

    static class BinaryTreeNode<T> {
        public T val;
        public BinaryTreeNode<T> left, right, next;

        public BinaryTreeNode(T val) {
            this.val = val;
        }

        public BinaryTreeNode(T val, BinaryTreeNode<T> left, BinaryTreeNode<T> right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return val.toString();
        }
    }

    public BinaryTreeNode<Integer> connect(BinaryTreeNode<Integer> root) {
        BinaryTreeNode<Integer> node = root;
        while (node != null && node.left != null) {
            connectChildNode(node);
            node = node.left;
        }
        return root;
    }

    private void connectChildNode(BinaryTreeNode<Integer> startNode) {
        BinaryTreeNode<Integer> iter = startNode;
        while (iter != null) {
            if (iter.left != null) {
                iter.left.next = iter.right;
            }
            if (iter.next != null) {
                iter.right.next = iter.next.left;
            }
            iter = iter.next;
        }
    }


    // Definition for a Node.
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };


        public Node connect(Node root) {
            if (root == null) return null;

            LinkedList<Node> queue = new LinkedList<>();
            queue.add(root);
            Node prevNode;
            Node currentNode = null;

            while (!queue.isEmpty()) {

                int queueSize = queue.size();
                for (int idx = 0; idx < queueSize; idx++) {
                    prevNode = currentNode;
                    currentNode = queue.pop();
                    if (idx > 0) {
                        prevNode.next = currentNode;
                    }
                    if (currentNode.left != null) {
                        queue.add(currentNode.left);
                    }
                    if (currentNode.right != null) {
                        queue.add(currentNode.right);
                    }
                }
                if (currentNode != null) {
                    currentNode.next = null;
                }
            }
            return root;
        }

    private List<String> getNodeNextList(BinaryTreeNode<Integer> root) {
        // Print the list of next nodes
        // Add the value to the list, if the next node is null then add # to the list
        List<String> result = new ArrayList<>();
        BinaryTreeNode<Integer> node = root;
        while (node != null) {
            result.add(node.val.toString());
            BinaryTreeNode<Integer> nextNode = node.next;
            while (nextNode != null) {
                result.add(nextNode.val.toString());
                nextNode = nextNode.next;
            }
            result.add("#");
            node = node.left;
        }
        return result;
    }

    public static void main(String[] args) {
        PopulateNextRightPointersEachNode populateNextRightPointersEachNode = new PopulateNextRightPointersEachNode();
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(1);
        root.left = new BinaryTreeNode<>(2);
        root.right = new BinaryTreeNode<>(3);
        root.left.left = new BinaryTreeNode<>(4);
        root.left.right = new BinaryTreeNode<>(5);
        root.right.left = new BinaryTreeNode<>(6);
        root.right.right = new BinaryTreeNode<>(7);

        // Depict the above tree
        //               1
        //             /   \
        //            2     3
        //           / \   / \
        //          4   5 6   7
        // Output: [1,#,2,3,#,4,5,6,7,#]

        BinaryTreeNode<Integer> result = populateNextRightPointersEachNode.connect(root);

        System.out.println("connect(root) should return [1, #, 2, 3, #, 4, 5, 6, 7, #] and the result is "
                + populateNextRightPointersEachNode.getNodeNextList(result) +
                " verified "
                + populateNextRightPointersEachNode.
                getNodeNextList(result).toString().equals("[1, #, 2, 3, #, 4, 5, 6, 7, #]"));
    }

}
