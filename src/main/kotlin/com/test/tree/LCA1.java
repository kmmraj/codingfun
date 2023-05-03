package com.test.tree;

public class LCA1 {


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //BC
        if(root == null ){
            return null;
        }

        if(root == p){
            return root;
        }
        if(root == q){
            return root;
        }


        TreeNode leftTreeNode  = lowestCommonAncestor(root.left,p,q);
        TreeNode rightTreeNode = lowestCommonAncestor(root.right,p,q);
        if(leftTreeNode == null)
            return rightTreeNode;
        if(rightTreeNode == null)
            return leftTreeNode;
        return root;

    }

    public static void main(String[] args) {
        TreeNode ch8 = new TreeNode(8);

        TreeNode ch7 = new TreeNode(7);
        TreeNode ch6 = new TreeNode(6);
        TreeNode ch5 = new TreeNode(5);
        TreeNode ch4 = new TreeNode(4,ch8,null);
        TreeNode ch3 = new TreeNode(3,ch6,ch7);
        TreeNode ch2 = new TreeNode(2,ch4,ch5);
        TreeNode ch1 = new TreeNode(1,ch2,ch3);

        LCA1 lca1 = new LCA1();
        TreeNode treeNode = lca1.lowestCommonAncestor(ch1,ch4,ch7);
        System.out.println("Val is: "+ treeNode.val);
    }
}
