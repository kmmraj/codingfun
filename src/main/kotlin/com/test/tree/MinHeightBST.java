package com.test.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinHeightBST {
    public static BST minHeightBst(List<Integer> array) {
        // Write your code here.
        // Find the root node
        return minHeightBST(array, null, 0, array.size() - 1);
    }

    public static BST minHeightBST(List<Integer> array, BST node, int start, int end) {
        // BC -- to find out
        if (start > end)
            return node;

        // Hypo & Choices
        int mid = (start + end) / 2;
        if (node == null) {
            node = new BST(array.get(mid));
        } else {
            // create the node and call recursion to attach
            node.insert(array.get(mid));
        }
        minHeightBST(array, node, start, mid - 1);
        minHeightBST(array, node, mid + 1, end);

        return node;
    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
            left = null;
            right = null;
        }

        public void insert(int value) {
            if (value < this.value) {
                if (left == null) {
                    left = new BST(value);
                } else {
                    left.insert(value);
                }
            } else {
                if (right == null) {
                    right = new BST(value);
                } else {
                    right.insert(value);
                }
            }
        }
    }

    public static void main(String[] args) {
        TestCase1();
    }

    public static void TestCase1() {
        List<Integer> array = Arrays.asList(1, 2, 5, 7, 10, 13, 14, 15, 22);
        BST tree = MinHeightBST.minHeightBst(array);

        System.out.println(validateBst(tree));
        System.out.println("Should be 4 Height: " + getTreeHeight(tree));

        List<Integer> inOrder = inOrderTraverse(tree, new ArrayList<>());
        List<Integer> expected = Arrays.asList(1, 2, 5, 7, 10, 13, 14, 15, 22);
        System.out.println(expected.equals(inOrder));
    }

    static boolean validateBst(MinHeightBST.BST tree) {
        return validateBst(tree, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    static boolean validateBst(MinHeightBST.BST tree, int minValue, int maxValue) {
        if (tree.value < minValue || tree.value >= maxValue) {
            return false;
        }
        if (tree.left != null && !validateBst(tree.left, minValue, tree.value)) {
            return false;
        }
        if (tree.right != null && !validateBst(tree.right, tree.value, maxValue)) {
            return false;
        }
        return true;
    }

    static List<Integer> inOrderTraverse(MinHeightBST.BST tree, List<Integer> array) {
        if (tree.left != null) {
            inOrderTraverse(tree.left, array);
        }
        array.add(tree.value);
        if (tree.right != null) {
            inOrderTraverse(tree.right, array);
        }
        return array;
    }

    static int getTreeHeight(MinHeightBST.BST tree) {
        return getTreeHeight(tree, 0);
    }

    static int getTreeHeight(MinHeightBST.BST tree, int height) {
        if (tree == null) return height;
        int leftTreeHeight = getTreeHeight(tree.left, height + 1);
        int rightTreeHeight = getTreeHeight(tree.right, height + 1);
        return Math.max(leftTreeHeight, rightTreeHeight);
    }
}
