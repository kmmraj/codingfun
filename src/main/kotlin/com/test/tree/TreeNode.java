package com.test.tree;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public TreeNode(int val) {
        this.val = val;
    }

//    @Override
//    public String toString() {
//        return "("+ val + " -> L: "+ left + " R: "+ right + ")";
//    }
}
