package com.test.tree;
//https://www.algoexpert.io/questions/Find%20Closest%20Value%20In%20BST
import java.util.Map;

public class FindClosestValueInBST {

    public static int findClosestValueInBst(BST tree, int target) {


        return findClosestValue(tree,target,tree.value);
    }

    public static int findClosestValue(BST tree, int target,int closestValue){
        // BC
        if(tree == null)
            return closestValue;

        // Hypo & Choice D
        // if the existing closet value is greater than the current closest value
        if(Math.abs(target-closestValue) > Math.abs(target-tree.value))
            closestValue = tree.value;


        if(tree.left != null && target <  tree.value){
            return findClosestValue(tree.left,target,closestValue);
        } else if(tree.right != null && target > tree.value){
            return findClosestValue(tree.right,target,closestValue);
        } else {
            return closestValue;
        }
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
        BST root = new FindClosestValueInBST.BST(10);
        root.left = new FindClosestValueInBST.BST(5);
        root.left.left = new FindClosestValueInBST.BST(2);
        root.left.left.left = new FindClosestValueInBST.BST(1);
        root.left.right = new FindClosestValueInBST.BST(5);
        root.right = new FindClosestValueInBST.BST(15);
        root.right.left = new FindClosestValueInBST.BST(13);
        root.right.left.right = new FindClosestValueInBST.BST(14);
        root.right.right = new FindClosestValueInBST.BST(22);

        int expected = 13;
        int actual = FindClosestValueInBST.findClosestValueInBst(root, 0);
        System.out.println(actual);
    }
}
