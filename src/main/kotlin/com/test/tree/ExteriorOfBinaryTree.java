package com.test.tree;

import java.util.ArrayList;
import java.util.List;

public class ExteriorOfBinaryTree {

    static class BinaryTreeNode<T> {
        public T val;
        public BinaryTreeNode<T> left, right;

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
    public static List<BinaryTreeNode<Integer>> exteriorBinaryTree(BinaryTreeNode<Integer> tree){
        List<BinaryTreeNode<Integer>> exterior = new ArrayList<>();
        if(tree != null) {
            exterior.add(tree);
            exterior.addAll(leftBoundaryAndLeaves(tree.left, true));
            exterior.addAll(rightBoundaryAndLeaves(tree.right, true));
        }
        return exterior;
    }

    private static List<BinaryTreeNode<Integer>> leftBoundaryAndLeaves(BinaryTreeNode<Integer> tree, boolean isBoundary){
        List<BinaryTreeNode<Integer>> result = new ArrayList<>();
        if(tree != null) {
            if(isBoundary || isLeaf(tree)) {
                result.add(tree);
            }
            result.addAll(leftBoundaryAndLeaves(tree.left, isBoundary));
            result.addAll(leftBoundaryAndLeaves(tree.right, isBoundary && tree.left == null));
        }
        return result;
    }

    private static List<BinaryTreeNode<Integer>> rightBoundaryAndLeaves(BinaryTreeNode<Integer> tree, boolean isBoundary){
        List<BinaryTreeNode<Integer>> result = new ArrayList<>();
        if(tree != null) {
            result.addAll(rightBoundaryAndLeaves(tree.left, isBoundary && tree.right == null));
            result.addAll(rightBoundaryAndLeaves(tree.right, isBoundary));
            if(isBoundary || isLeaf(tree)) {
                result.add(tree);
            }
        }
        return result;
    }

    private static boolean isLeaf(BinaryTreeNode<Integer> tree) {
        return tree.left == null && tree.right == null;
    }


    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(1);
        root.left = new BinaryTreeNode<>(2);
        root.right = new BinaryTreeNode<>(3);
        root.left.left = new BinaryTreeNode<>(4);
        root.left.right = new BinaryTreeNode<>(5);
        root.right.left = new BinaryTreeNode<>(6);
        root.right.right = new BinaryTreeNode<>(7);

        //                   1
        //                 /   \
        //                2     3
        //               / \   / \
        //              4   5 6   7

        System.out.println("ExteriorOfBinaryTree.exteriorBinaryTree(root) should return [1, 2, 4, 5, 6, 7, 3] and the result is "
                + ExteriorOfBinaryTree.exteriorBinaryTree(root));

        BinaryTreeNode<Integer> root2 = new BinaryTreeNode<>(1);
        root2.left = new BinaryTreeNode<>(2);
        root2.right = new BinaryTreeNode<>(3);
        root2.left.right = new BinaryTreeNode<>(4);
        root2.right.left = new BinaryTreeNode<>(5);
        root2.left.right.left = new BinaryTreeNode<>(6);
        root2.right.left.right = new BinaryTreeNode<>(7);

        //                   1
        //                 /   \
        //                2     3
        //                 \   /
        //                  4 5
        //                 /   \
        //                6     7

        System.out.println("ExteriorOfBinaryTree.exteriorBinaryTree(root2) should return [1, 2, 4, 6, 7, 5, 3] and the result is "
                + ExteriorOfBinaryTree.exteriorBinaryTree(root2));


        BinaryTreeNode<Integer> root3 = new BinaryTreeNode<>(1);
        root3.left = new BinaryTreeNode<>(2);
        root3.right = new BinaryTreeNode<>(3);
        root3.left.left = new BinaryTreeNode<>(4);
        root3.left.right = new BinaryTreeNode<>(5);
        root3.left.right.left = new BinaryTreeNode<>(6);
        root3.left.right.right = new BinaryTreeNode<>(7);
        root3.right.left = new BinaryTreeNode<>(8);
        root3.right.left.left = new BinaryTreeNode<>(9);
        root3.right.left.right = new BinaryTreeNode<>(10);
        root3.right.left.right.left = new BinaryTreeNode<>(11);
        root3.right.left.right.right = new BinaryTreeNode<>(12);
        root3.right.right = new BinaryTreeNode<>(13);
        root3.right.right.left = new BinaryTreeNode<>(14);
        root3.right.right.right = new BinaryTreeNode<>(15);
        root3.right.right.right.left = new BinaryTreeNode<>(16);
        root3.right.right.right.right = new BinaryTreeNode<>(17);
        // Depicting the tree in the above example
        //                     1
        //                    /  \
        //                   /    \
        //                  /      \
        //                 /        \
        //                2          3
        //               / \        / \
        //              /   \      /   \
        //             4     5    8     13
        //                  / \  / \    / \
        //                 6  7 9  10  14 15
        //                        / \     / \
        //                       11 12   16 17


        System.out.println("ExteriorOfBinaryTree.exteriorBinaryTree(root3) should return [1, 2, 4, 6, 7, 10, 12, 17, 16, 15, 11, 9, 14, 13, 3] and the result is "
                + ExteriorOfBinaryTree.exteriorBinaryTree(root3));



        


    }
}
