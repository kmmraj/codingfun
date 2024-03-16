package com.test.tree;

import java.util.ArrayList;
import java.util.List;

public class FindSuccessor {
    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;
        public BinaryTree parent = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    public BinaryTree findSuccessor(BinaryTree tree, BinaryTree node) {
        // Write your code here.
        List<BinaryTree> array = new ArrayList<>();
        solveItRecursively(tree, node, array);
        BinaryTree answer = null;
        for (int idx = 0; idx < array.size(); idx++) {
            if (array.get(idx).value == node.value) {
                if (idx + 1 < array.size())
                    answer = array.get(idx + 1);
                else
                    answer = null;
            }
        }
        return answer;
    }

    public List<BinaryTree> solveItRecursively(BinaryTree tree, BinaryTree node, List<BinaryTree> array) {
        if (tree == null)
            return array;

        solveItRecursively(tree.left, node, array);
        array.add(tree);
        solveItRecursively(tree.right, node, array);
        return array;
    }

    // EPI Solution

    public static BinaryTree findSuccessor(BinaryTree node) {
        BinaryTree iter = node;
        if (iter.right != null) {
            //Find the leftmost element innode’s rightsubtree.
            iter = iter.right;
            while (iter.left != null) {
                iter = iter.left;
            }
            return iter;

        }
         // Find the closest ancestor whose left subtree contains node.

        // This loop continues to traverse up the tree (i.e., towards the root) as
        // long as the current node is the right child of its parent.
        // This is because if the current node is the right child of its parent,
        // then all nodes in the parent's subtree have already been visited in the in-order traversal.
        // **Once the loop finds a node that is the left child of its parent, it stops.**
        // The parent of this node is the in-order successor of the original node.
        // This is because in an in-order traversal, after visiting all nodes in the left subtree of a node
        // and the node itself, we visit the node's right subtree.
        // If the original node does not have a right subtree (which is the case we are considering here),
        // the next node to be visited is the node's parent.
        while (iter.parent != null && iter.parent.right == iter) {
            iter = iter.parent;
        }
        // A return value of null means node does not have successor, i.e., it is
        // the rightmost node in the tree.
        return iter.parent;
    }


    public static void main(String[] args) {
        TestCase1();
    }

    public static void TestCase1() {
        FindSuccessor.BinaryTree root = new FindSuccessor.BinaryTree(1);
        root.left = new FindSuccessor.BinaryTree(2);
        root.left.parent = root;
        root.right = new FindSuccessor.BinaryTree(3);
        root.right.parent = root;
        root.left.left = new FindSuccessor.BinaryTree(4);
        root.left.left.parent = root.left;
        root.left.right = new FindSuccessor.BinaryTree(5);
        root.left.right.parent = root.left;
        root.left.left.left = new FindSuccessor.BinaryTree(6);
        root.left.left.left.parent = root.left.left;
        FindSuccessor.BinaryTree node = root.left.right;
        FindSuccessor.BinaryTree expected = root;
        FindSuccessor.BinaryTree output = new FindSuccessor().findSuccessor(root, node);
        System.out.println(expected == output);
    }
}
