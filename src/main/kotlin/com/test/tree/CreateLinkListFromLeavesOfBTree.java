package com.test.tree;

import java.util.ArrayList;
import java.util.List;
// 10.14 FORM A LINKED LIST FROM THE LEAVES OF A BINARY TREE
public class CreateLinkListFromLeavesOfBTree {

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
//            return "BTN{" +
//                    "val=" + val +
//                    '}';
            return val.toString();
        }
    }

    List<BinaryTreeNode<Integer>> result = null;

    private  static List<BinaryTreeNode<Integer>> createListOfLeaves(BinaryTreeNode<Integer> tree) {
        List<BinaryTreeNode<Integer>> result = new ArrayList<>();
        return createListOfLeavesHelper(tree,result);
    }

    private static List<BinaryTreeNode<Integer>> createListOfLeavesHelper(BinaryTreeNode<Integer> node,
                                                                          List<BinaryTreeNode<Integer>> result) {
        // BC
        if(node == null) {
            return null;
        }
        // H & I
        if(node.left == null && node.right == null) {
            result.add(node);
        }
        createListOfLeavesHelper(node.left,result);
        createListOfLeavesHelper(node.right,result);
        return result;
    }
    public static void main(String[] args) {
        CreateLinkListFromLeavesOfBTree createLinkListFromLeavesOfBTree = new CreateLinkListFromLeavesOfBTree();
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(1);
        root.left = new BinaryTreeNode<>(2);
        root.right = new BinaryTreeNode<>(3);
        root.left.left = new BinaryTreeNode<>(4);
        root.left.right = new BinaryTreeNode<>(5);
        root.right.left = new BinaryTreeNode<>(6);
        root.right.right = new BinaryTreeNode<>(7);

        System.out.println("createListOfLeavesHelper(root) should return [4, 5, 6,7] and the result is "
                + createLinkListFromLeavesOfBTree.createListOfLeaves(root));
    }
}
