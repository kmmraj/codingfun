//https://leetcode.com/problems/binary-tree-maximum-path-sum/submissions/
package com.test.dynamicprogramming;

import com.test.tree.TreeNode;

public class BTreeMaxSumPath {

    public int maxPathSum(TreeNode root) {
        MaxSum maxSum = new MaxSum();
        solveIt(root, maxSum);

        return maxSum.ans;
    }

    private int solveIt(TreeNode node, MaxSum currentMaxSum) {
        // BC
        if(node == null)
            return 0;

        // Hypothesis and Choice
        int leftSum = solveIt(node.left, currentMaxSum);
        int rightSum = solveIt(node.right, currentMaxSum);

        // Induction

        int choiceOfNodeOrItsLeafsMax = Math.max(node.val, node.val+Math.max(leftSum,rightSum));
        int choiceOfNodeOrLeafSum = Math.max(choiceOfNodeOrItsLeafsMax, node.val+leftSum+rightSum);
        currentMaxSum.ans = Math.max(currentMaxSum.ans, choiceOfNodeOrLeafSum);

        return  choiceOfNodeOrItsLeafsMax;
    }

    static class MaxSum {
        Integer ans = Integer.MIN_VALUE;
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

        BTreeMaxSumPath bTreeMaxSumPath = new BTreeMaxSumPath();
        System.out.println(bTreeMaxSumPath.maxPathSum(ch1));
    }


}
