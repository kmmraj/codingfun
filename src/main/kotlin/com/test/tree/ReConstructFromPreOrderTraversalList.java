package com.test.tree;

import java.util.Arrays;
import java.util.List;

public class ReConstructFromPreOrderTraversalList {

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
    }

    private static Integer subtreeIdx;

    private static BinaryTreeNode<Integer> reconstructPreorder(int[] preorder) {
        subtreeIdx = 0;
        return reconstructPreorderSubtree(preorder);
    }

    // Reconstructs the subtree that is rooted at subtreeIdx .
    private static BinaryTreeNode<Integer> reconstructPreorderSubtree(int[] preorder) {
        if (subtreeIdx == preorder.length) {
            return null;
        }
        Integer subtreeKey = preorder[subtreeIdx];
        ++subtreeIdx;

        // Note that reconstructPreorderSubtree updates subtreeldx.
        // So the order of // following two calls are critical.

        BinaryTreeNode<Integer> leftSubtree = reconstructPreorderSubtree(preorder);
        BinaryTreeNode<Integer> rightSubtree = reconstructPreorderSubtree(preorder);
        return new BinaryTreeNode<>(subtreeKey, leftSubtree, rightSubtree);
    }

    public static BinaryTreeNode<Integer > reconstructPreorder ( List<Integer> preorder) {
        subtreeIdx = 0;
        return reconstructPreorderSubtree(preorder);
    }
    // Reconstructs the subtree that is rooted at subtreeIdx .
    private static BinaryTreeNode<Integer> reconstructPreorderSubtree(List<Integer> preorder) {
        Integer subtreeKey = preorder.get(subtreeIdx);
        ++subtreeIdx;
        if (subtreeKey == null) {
            return null;
        }
         // Note that reconstructPreorderSubtree updates subtreeIdx.
        // So the order of // following two calls are critical.
        BinaryTreeNode<Integer> leftSubtree = reconstructPreorderSubtree(preorder);
        BinaryTreeNode<Integer> rightSubtree = reconstructPreorderSubtree(preorder);
        return new BinaryTreeNode<>(subtreeKey, leftSubtree, rightSubtree);
    }


        public static void main(String[] args) {
        int[] preOrder = {1,
                2, 4, Integer.MIN_VALUE, Integer.MIN_VALUE,
                5, Integer.MIN_VALUE, Integer.MIN_VALUE, 3, 6, Integer.MIN_VALUE, Integer.MIN_VALUE, 7, Integer.MIN_VALUE, Integer.MIN_VALUE};
        BinaryTreeNode<Integer> root = reconstructPreorder(preOrder);
        System.out.println("root should be 1 and the result is  " + root.val);
        System.out.println("root.left should be 2 and the result is  " + root.left.val);
        System.out.println("root.right should be 3 and the result is  " + root.right.val);

        List<Integer> preOrderList = Arrays.asList(1, 2, 4, null, null, 5, null, null, 3, 6, null, null, 7, null, null);
        BinaryTreeNode<Integer> rootList = reconstructPreorder(preOrderList);
        System.out.println("root should be 1 and the result is  " + rootList.val);
        System.out.println("root.left should be 2 and the result is  " + rootList.left.val);
        System.out.println("root.right should be 3 and the result is  " + rootList.right.val);
    }

}