package com.test.tree;

public class MaxDeptOfBTree {
    public int maxDepth(TreeNode root) {
        if(root ==null){
            return 0;
        }

        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        return Math.max(leftDepth,rightDepth)+1;
    }

    public int minDepth(TreeNode root) {
        if(root ==null){
            return 0;
        }

        int leftDepth = minDepth(root.left);
        int rightDepth = minDepth(root.right);

        return Math.min(leftDepth,rightDepth)+1;
    }




    public static void main(String[] args) {

        TreeNode ch9 = new TreeNode(9);
        TreeNode ch8 = new TreeNode(8,ch9,null);
        TreeNode ch7 = new TreeNode(7);
        TreeNode ch6 = new TreeNode(6);
        TreeNode ch5 = new TreeNode(5);
        TreeNode ch4 = new TreeNode(4,ch8,null);
        TreeNode ch3 = new TreeNode(3,ch6,ch7);
        TreeNode ch2 = new TreeNode(2,ch4,ch5);
        TreeNode ch1 = new TreeNode(1,ch2,ch3);

        MaxDeptOfBTree balancedBTree = new MaxDeptOfBTree();
        System.out.println(balancedBTree.maxDepth(ch1));
        System.out.println(balancedBTree.minDepth(ch1));

    }
}
