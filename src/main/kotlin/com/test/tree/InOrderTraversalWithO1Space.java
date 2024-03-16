package com.test.tree;

import java.util.ArrayList;
import java.util.List;

public class InOrderTraversalWithO1Space {

    private static class BinaryTree<T> {
        T data;
        BinaryTree<T> left, right, parent;
    }

    /**
     * The algorithm in the provided code is an in-order traversal of a binary tree using constant space.
     * Here's a simplified explanation:
     * The algorithm starts at the root of the binary tree.
     * It then tries to move to the leftmost node of the tree, visiting each node along the way.
     * Once it reaches a node with no left child, it adds the node's value to a list.
     * It then tries to move to the right child of the node. If there is no right child, it moves back up to the parent.
     * If it just moved up from a left child, it adds the current node's value to the list and again tries to move to the right child or back up to the parent.
     * If it just moved up from a right child, it continues moving up to the parent.
     * The algorithm repeats these steps until it has visited all nodes in the tree.
     * Finally, it returns the list of node values, which is the in-order traversal of the tree.
     * @param tree
     * @return
     */

    public static List<Integer> inorderTraversal(BinaryTree<Integer> tree) {
        BinaryTree<Integer> prev = null, curr = tree;
        List<Integer> result = new ArrayList<>();
        while (curr != null) {
            BinaryTree<Integer> next;
            if (curr.parent == prev) {
                // We came down to curr from prev.
                if (curr.left != null) { // Keep going left.
                    next = curr.left;
                } else {
                    result.add(curr.data);
                    // Done with left, so go right if right is not empty. // Otherwise , go up.
                    next = (curr.right != null) ? curr.right : curr.parent;
                }
            } else if (curr.left == prev) {
                result.add(curr.data);
                //Done with left,so go right if right is not empty.Otherwise,go up.
                next = (curr.right != null) ? curr.right : curr.parent;
            } else {
                // Done with both children , so move up. next = curr. parent;
                next = curr.parent;
            }

            prev = curr;
            curr = next;
        }
        return result;
    }


    public static void main(String[] args) {
        BinaryTree<Integer> ch8 = new BinaryTree<>();
        ch8.data = 8;
        BinaryTree<Integer> ch7 = new BinaryTree<>();
        ch7.data = 7;
        BinaryTree<Integer> ch6 = new BinaryTree<>();
        ch6.data = 6;
        BinaryTree<Integer> ch5 = new BinaryTree<>();
        ch5.data = 5;
        BinaryTree<Integer> ch4 = new BinaryTree<>();
        ch4.data = 4;
        ch4.left = ch8;
        BinaryTree<Integer> ch3 = new BinaryTree<>();
        ch3.data = 3;
        ch3.left = ch6;
        ch3.right = ch7;
        BinaryTree<Integer> ch2 = new BinaryTree<>();
        ch2.data = 2;
        ch2.left = ch4;
        ch2.right = ch5;

        BinaryTree<Integer> ch1 = new BinaryTree<>();
        ch1.data = 1;
        ch1.left = ch2;
        ch1.right = ch3;

        ch2.parent = ch1;
        ch3.parent = ch1;
        ch4.parent = ch2;
        ch5.parent = ch2;
        ch6.parent = ch3;
        ch7.parent = ch3;
        ch8.parent = ch4;

        // Tree is as follows:
        //             1
        //           /   \
        //          2     3
        //         / \   / \
        //        4   5 6   7
        //      /
        //     8

        System.out.println(" In nOrderTraversalWithO1Space.inorderTraversal(ch1) " +
                "result should be [8, 4, 2, 5, 1, 6, 3, 7]"
                + " and the result is " + InOrderTraversalWithO1Space.inorderTraversal(ch1));
    }
}
