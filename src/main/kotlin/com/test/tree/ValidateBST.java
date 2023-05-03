package com.test.tree;

public class ValidateBST {
    public static boolean validateBst(BST tree) {
        // Write your code here.
//        return validateBst(tree, Integer.MIN_VALUE, Integer.MAX_VALUE, tree.value);
        return validateBstNW(tree, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static boolean validateBst(BST node, int minValue, int maxValue, int parentValue) {
        // BC
        if (node.value < minValue || node.value >= maxValue)
            return false;
        // Hypo & Choices
        if (node.left != null && !validateBst(node.left, minValue, node.value, parentValue)) {
            return false;
        }
        if (node.right != null && !validateBst(node.right, node.value, maxValue, parentValue)) {
            return false;
        }
        return true;
    }

    public static boolean validateBstNW(BST node,int minValue,int maxValue){

        // if (root == null) return true;
        // if (root.val >= maxVal || root.val <= minVal) return false;
        //  return isValidBST(root.left, minVal, root.val)
        // && isValidBST(root.right, root.val, maxVal);
        // BC
        if(node == null)
            return true;

        if(node.value > maxValue || node.value < minValue)
            return false;

        return validateBstNW(node.left,minValue,node.value)
                && validateBstNW(node.right,node.value,maxValue);

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
        testCase1();
        testCase6();
    }

    public static void testCase1() {
        BST root = new ValidateBST.BST(10);
        root.left = new ValidateBST.BST(5);
        root.left.left = new ValidateBST.BST(2);
        root.left.left.left = new ValidateBST.BST(1);
        root.left.right = new ValidateBST.BST(5);
        root.right = new ValidateBST.BST(15);
        root.right.left = new ValidateBST.BST(13);
        root.right.left.right = new ValidateBST.BST(14);
        root.right.right = new ValidateBST.BST(22);

        System.out.println(ValidateBST.validateBst(root));
    }

    //"nodes": [
    //      {"id": "10", "left": "5", "right": "15", "value": 10},
    //      {"id": "15", "left": null, "right": "22", "value": 15},
    //      {"id": "22", "left": null, "right": null, "value": 22},
    //      {"id": "5", "left": "2", "right": "5-2", "value": 5},
    //      {"id": "5-2", "left": null, "right": "11", "value": 5},
    //      {"id": "11", "left": null, "right": null, "value": 11},
    //      {"id": "2", "left": "1", "right": null, "value": 2},
    //      {"id": "1", "left": null, "right": null, "value": 1}
    //    ],
    public static void testCase6() {
        BST root = new ValidateBST.BST(10);
        root.left = new ValidateBST.BST(5);
        root.left.left = new ValidateBST.BST(2);
        root.left.left.left = new ValidateBST.BST(1);
        root.left.right = new ValidateBST.BST(5);
        root.left.right.right = new ValidateBST.BST(11);
        root.right = new ValidateBST.BST(15);
        root.right.right = new ValidateBST.BST(22);
        System.out.println(ValidateBST.validateBst(root));
    }
}
