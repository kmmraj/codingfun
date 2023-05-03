
// https://www.geeksforgeeks.org/find-maximum-path-sum-two-leaves-binary-tree/
 package com.test.dynamicprogramming;

import com.test.tree.TreeNode;

public class MaxPathSumFromLeaf2Leaf {

    public int maxPathSumFromLeaf2Leaf(TreeNode root) {
        MaxSum maxSum = new MaxSum();
        int ans = solveIt(root, maxSum);

        System.out.println("Ans is :"+ans);
        return maxSum.ans;
    }

    private int solveIt(TreeNode node, MaxSum maxSum) {
        // BC
        if(node == null)
            return 0;

        if(node.left ==  null && node.right == null)
            return node.val;

        //  Hypothesis
        int leftSum = solveIt(node.left,maxSum);
        int rightSum = solveIt(node.right,maxSum);

        // Choice and Induction
        // When
        //       6
        //       /\
        //      /  \
        //    -9  -10
        if(node.left != null &&  node.right != null){
            maxSum.ans = Math.max(maxSum.ans,leftSum+rightSum+node.val);
            return  node.val+Math.max(leftSum,rightSum);
        } else {
            // When
            //       4
            //       /\
            //      /  \
            //     8   null
            return (node.left == null) ? rightSum+node.val : leftSum+node.val;
        }
    }


    static class MaxSum {
        Integer ans = Integer.MIN_VALUE;
    }


    public static void main(String[] args) {
        TreeNode ch8 = new TreeNode(8);

        TreeNode ch7 = new TreeNode(7);
        TreeNode ch6 = new TreeNode(6);
        TreeNode ch5 = new TreeNode(5);
        TreeNode ch4 = new TreeNode(4, ch8, null);
        TreeNode ch3 = new TreeNode(3, ch6, ch7);
        TreeNode ch2 = new TreeNode(2, ch4, ch5);
        TreeNode ch1 = new TreeNode(1, ch2, ch3);

        MaxPathSumFromLeaf2Leaf fromLeaf2Leaf = new MaxPathSumFromLeaf2Leaf();
        int ans = fromLeaf2Leaf.maxPathSumFromLeaf2Leaf(ch1);
        System.out.println(ans);

        TreeNode chA3 = new TreeNode(-10);
        TreeNode chA2 = new TreeNode(-9);
        TreeNode chA1 = new TreeNode(6, chA2, chA3);
        ans = fromLeaf2Leaf.maxPathSumFromLeaf2Leaf(chA1);

        System.out.println(ans);
    }
}
