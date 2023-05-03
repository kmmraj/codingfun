package com.test.dynamicprogramming;

//https://leetcode.com/problems/diameter-of-binary-tree/
import com.test.tree.TreeNode;

public class BTreeDiameter {

    public int diameterOfBinaryTree(TreeNode root) {

        TempAnswer tempAnswer = new TempAnswer();
        solveItBTree(root, tempAnswer);
        return tempAnswer.ans == Integer.MIN_VALUE? 0: tempAnswer.ans-1;
    }

    private int solveItBTree(TreeNode treeNode, TempAnswer tempAnswer) {
       // BC
        if(treeNode == null)
            return 0;

        // Hypothesis and Choice Diagram
        int leftHeight = solveItBTree(treeNode.left,tempAnswer);
        int rightHeight = solveItBTree(treeNode.right,tempAnswer);

        // Induction
        tempAnswer.ans = Math.max(tempAnswer.ans,leftHeight+rightHeight+1);
        return Math.max(leftHeight,rightHeight)+1; // Total height of the current node
    }

    static class TempAnswer{
        int ans = Integer.MIN_VALUE;
    }

    public static void main(String[] args) {
        BTreeDiameter bTreeDiameter = new BTreeDiameter();
        TreeNode ch8 = new TreeNode(8);

        TreeNode ch7 = new TreeNode(7);
        TreeNode ch6 = new TreeNode(6);
        TreeNode ch5 = new TreeNode(5);
        TreeNode ch4 = new TreeNode(4,ch8,null);
        TreeNode ch3 = new TreeNode(3,ch6,ch7);
        TreeNode ch2 = new TreeNode(2,ch4,ch5);
        TreeNode ch1 = new TreeNode(1,ch2,ch3);
        System.out.println(bTreeDiameter.diameterOfBinaryTree(ch1));
    }
}
