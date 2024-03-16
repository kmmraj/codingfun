package com.test.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TreeTraverse {
    public static List<Integer> inOrderTraverse(BST tree, List<Integer> array) {
        // Write your code here.
        if (tree == null)
            return array;

        inOrderTraverse(tree.left, array);
        array.add(tree.value);
        inOrderTraverse(tree.right, array);
        return array;
    }



    public static List<Integer> preOrderTraverse(BST tree, List<Integer> array) {
        if (tree == null)
            return array;

        array.add(tree.value);
        preOrderTraverse(tree.left, array);
        preOrderTraverse(tree.right, array);
        return array;
    }

    public static List<Integer> postOrderTraverse(BST tree, List<Integer> array) {
        if (tree == null)
            return array;

        postOrderTraverse(tree.left, array);
        postOrderTraverse(tree.right, array);
        array.add(tree.value);
        return array;
    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        TestCase1();
    }

    public static void TestCase1() {
        BST root = new TreeTraverse.BST(10);
        root.left = new TreeTraverse.BST(5);
        root.left.left = new TreeTraverse.BST(2);
        root.left.left.left = new TreeTraverse.BST(1);
        root.left.right = new TreeTraverse.BST(5);
        root.right = new TreeTraverse.BST(15);
        root.right.right = new TreeTraverse.BST(22);

        List<Integer> inOrder = Arrays.asList(new Integer[] {1, 2, 5, 5, 10, 15, 22});
        List<Integer> preOrder = Arrays.asList(new Integer[] {10, 5, 2, 1, 5, 15, 22});
        List<Integer> postOrder = Arrays.asList(new Integer[] {1, 2, 5, 5, 22, 15, 10});

        System.out.println(TreeTraverse.inOrderTraverse(root, new ArrayList<Integer>()).equals(inOrder));
        System.out.println(TreeTraverse.preOrderTraverse(root, new ArrayList<Integer>()).equals(preOrder));
        System.out.println(TreeTraverse.postOrderTraverse(root, new ArrayList<Integer>()).equals(postOrder));
    }
}
