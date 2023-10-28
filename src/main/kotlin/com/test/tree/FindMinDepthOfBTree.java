package com.test.tree;

import com.test.tree.TreeNode;
public class FindMinDepthOfBTree {

    public int minDepth(TreeNode root) {

        // BC
        if(root == null) return 0;

        // Hypo
        int leftDepth = minDepth(root.left);
        int rightDepth = minDepth(root.right);

        // Choice
        if(leftDepth == 0) return rightDepth + 1;
        if(rightDepth == 0) return leftDepth + 1;

        return Math.min(leftDepth, rightDepth) + 1;
    }

    public static void main(String[] args){
        //Example 1:
        //
        //
        //Input: root = [3,9,20,null,null,15,7]
        //Output: 2
        //Example 2:
        //
        //Input: root = [2,null,3,null,4,null,5,null,6]
        //Output: 5

        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(9);
        treeNode.right = new TreeNode(20, new TreeNode(15), new TreeNode(7));

        int minDepth = new FindMinDepthOfBTree().minDepth(treeNode);
        System.out.println("Min depth: " + minDepth);
    }
}
