package com.test.tree;

import java.util.ArrayList;

public class KthLargestValueInBST {

    static class BST {
        public int value;
        public BST left = null;
        public BST right = null;

        public BST(int value) {
            this.value = value;
        }
    }

    public int findKthLargestValueInBst(BST tree, int k) {
        // Write your code here.
        ArrayList<Integer> sortedValues = new ArrayList<>();
        inOrderTraversal(tree,sortedValues);
        return sortedValues.get(sortedValues.size()-k);
    }

    private void inOrderTraversal(BST node, ArrayList<Integer> sortedValues) {
        if(node== null)
            return;
        inOrderTraversal(node.left,sortedValues);
        sortedValues.add(node.value);
        inOrderTraversal(node.right,sortedValues);
    }

    public static void main(String[] args) {
       TestCase1();
    }

    public static void TestCase1() {
        KthLargestValueInBST.BST root = new KthLargestValueInBST.BST(15);
        root.left = new KthLargestValueInBST.BST(5);
        root.left.left = new KthLargestValueInBST.BST(2);
        root.left.left.left = new KthLargestValueInBST.BST(1);
        root.left.left.right = new KthLargestValueInBST.BST(3);
        root.left.right = new KthLargestValueInBST.BST(5);
        root.right = new KthLargestValueInBST.BST(20);
        root.right.left = new KthLargestValueInBST.BST(17);
        root.right.right = new KthLargestValueInBST.BST(22);
        int k = 3;
        int expected = 17;
        int actual = new KthLargestValueInBST().findKthLargestValueInBst(root, k);
        System.out.println(expected == actual);
    }
}
