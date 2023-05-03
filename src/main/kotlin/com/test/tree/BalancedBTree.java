package com.test.tree;

public class BalancedBTree {

    public boolean isBalanced(TreeNode root) {

        BBStatus bbStatus= solveIt(root);
        return bbStatus.treeBalanced;
    }

    private BBStatus solveIt(TreeNode root) {

        // BC
        if(root == null){
            return  new BBStatus(-1,true);
        }

        // Hypothesis & BC check  (extended BC)
        BBStatus leftStatus = solveIt(root.left);
        if(!leftStatus.treeBalanced){
           return leftStatus;
        }
        BBStatus rightStatus = solveIt(root.right);
        if(!rightStatus.treeBalanced){
            return rightStatus;
        }

        // Induction
        int treeHeight = Math.max(leftStatus.treeHeight,rightStatus.treeHeight)+1;
        boolean subTreeBalanced = Math.abs(leftStatus.treeHeight-rightStatus.treeHeight) <= 1;

        return new BBStatus(treeHeight,subTreeBalanced);


    }

    private class BBStatus{
        int treeHeight;
        boolean treeBalanced;

        BBStatus(int treeHeight, boolean treeBalanced) {
            this.treeHeight = treeHeight;
            this.treeBalanced = treeBalanced;
        }
    }

    public static void main(String[] args) {

        TreeNode ch9 = new TreeNode(9);
        TreeNode ch8 = new TreeNode(8);
        TreeNode ch7 = new TreeNode(7);
        TreeNode ch6 = new TreeNode(6);
        TreeNode ch5 = new TreeNode(5);
        TreeNode ch4 = new TreeNode(4,ch8,ch9);
        TreeNode ch3 = new TreeNode(3,ch6,ch7);
        TreeNode ch2 = new TreeNode(2,ch4,ch5);
        TreeNode ch1 = new TreeNode(1,ch2,ch3);

        BalancedBTree balancedBTree = new BalancedBTree();
        System.out.println(balancedBTree.isBalanced(ch1));

    }
}
