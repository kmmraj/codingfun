package com.test.tree;
// https://leetcode.com/problems/balanced-binary-tree/description/

/**
 * 110. Balanced Binary Tree
 * Easy
 * Given a binary tree, determine if it is
 * height-balanced
 * <p>
 * Example 1:
 * Input: root = [3,9,20,null,null,15,7]
 * Output: true
 * <p>
 * Example 2:
 * Input: root = [1,2,2,3,3,null,null,4,4]
 * Output: false
 * <p>
 * Example 3:
 * Input: root = []
 * Output: true
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the tree is in the range [0, 5000].
 * -104 <= Node.val <= 104
 */
public class BalancedBTree {

    public boolean isBalanced(TreeNode root) {

        BBStatus bbStatus = solveIt(root);
        return bbStatus.treeBalanced;
    }

    private BBStatus solveIt(TreeNode root) {

        // BC
        if (root == null) {
            return new BBStatus(-1, true);
        }

        // Hypothesis & BC check  (extended BC)
        BBStatus leftStatus = solveIt(root.left);
        if (!leftStatus.treeBalanced) {
            return leftStatus;
        }
        BBStatus rightStatus = solveIt(root.right);
        if (!rightStatus.treeBalanced) {
            return rightStatus;
        }

        // Induction
        int treeHeight = Math.max(leftStatus.treeHeight, rightStatus.treeHeight) + 1;
        boolean subTreeBalanced = Math.abs(leftStatus.treeHeight - rightStatus.treeHeight) <= 1;

        return new BBStatus(treeHeight, subTreeBalanced);


    }

    private class BBStatus {
        int treeHeight;
        boolean treeBalanced;

        BBStatus(int treeHeight, boolean treeBalanced) {
            this.treeHeight = treeHeight;
            this.treeBalanced = treeBalanced;
        }
    }

    public static void main(String[] args) {

        BalancedBTree balancedBTree = new BalancedBTree();
        System.out.println(" balancedBTree.isBalanced(\n" +
                "                new TreeNode(3,\n" +
                "                        new TreeNode(9, null , null),\n" +
                "                        new TreeNode(20, null, new TreeNode(7,\n" +
                "                                new TreeNode(15), new TreeNode(25)))))\n " +
                "should be false  and the result is " +
                balancedBTree.isBalanced(
                new TreeNode(3,
                        new TreeNode(9, null, null),
                        new TreeNode(20, null, new TreeNode(7,
                                new TreeNode(15), new TreeNode(25))))));

    }
}
