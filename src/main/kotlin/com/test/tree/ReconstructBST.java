package com.test.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReconstructBST {
    // This is an input class. Do not edit.
    static class BST {
        public int value;
        public BST left = null;
        public BST right = null;

        public BST() {
        }

        public BST(int value) {
            this.value = value;
        }
    }

    public BST reconstructBst(List<Integer> preOrderTraversalValues) {
        // Write your code here.
        return solveItRecursively(preOrderTraversalValues);
    }

    private BST solveItRecursively(List<Integer> preOrderTraversalValues) {

        if (preOrderTraversalValues.size() == 0)
            return null;

        int parentValue = preOrderTraversalValues.get(0);
        int newIdx=preOrderTraversalValues.size();

        for (int idx = 1; idx < preOrderTraversalValues.size(); idx++) {
            if(parentValue <= preOrderTraversalValues.get(idx)){
                newIdx = idx;
                break;
            }
        }

        BST leftTree = solveItRecursively(preOrderTraversalValues.subList(1,newIdx));
        BST rightTree = solveItRecursively(preOrderTraversalValues.subList(newIdx,preOrderTraversalValues.size()));
        BST bst = new BST(parentValue);
        bst.left = leftTree;
        bst.right = rightTree;
        return bst;

    }


    public static List<Integer> getDfsOrder(ReconstructBST.BST node, List<Integer> values) {
        values.add(node.value);
        if (node.left != null) {
            getDfsOrder(node.left, values);
        }
        if (node.right != null) {
            getDfsOrder(node.right, values);
        }
        return values;
    }

    public static void main(String[] args) {

        TestCase1();
    }

    public static void TestCase1() {
        List<Integer> preOrderTraversalValues =
                new ArrayList<Integer>(Arrays.asList(10, 4, 2, 1, 3, 17, 19, 18));
        ReconstructBST.BST tree = new ReconstructBST.BST(10);
        tree.left = new ReconstructBST.BST(4);
        tree.left.left = new ReconstructBST.BST(2);
        tree.left.left.left = new ReconstructBST.BST(1);
        tree.left.right = new ReconstructBST.BST(3);
        tree.right = new ReconstructBST.BST(17);
        tree.right.right = new ReconstructBST.BST(19);
        tree.right.right.left = new ReconstructBST.BST(18);
        List<Integer> expected = getDfsOrder(tree, new ArrayList<Integer>());
        BST actual = new ReconstructBST().reconstructBst((ArrayList<Integer>) preOrderTraversalValues);
        List<Integer> actualValues = getDfsOrder(actual, new ArrayList<Integer>());
        System.out.println(expected.equals(actualValues));
    }
}
