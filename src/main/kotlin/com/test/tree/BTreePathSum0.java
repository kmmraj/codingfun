package com.test.tree;
//https://leetcode.com/problems/path-sum/description/

/**
 * 112. Path Sum
 * Easy
 * Given the root of a binary tree and an integer targetSum,
 * return true if the tree has a root-to-leaf path such that adding up
 * all the values along the path equals targetSum.
 *
 * A leaf is a node with no children.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
 * Output: true
 * Explanation: The root-to-leaf path with the target sum is shown.
 * Example 2:
 *
 *
 * Input: root = [1,2,3], targetSum = 5
 * Output: false
 * Explanation: There two root-to-leaf paths in the tree:
 * (1 --> 2): The sum is 3.
 * (1 --> 3): The sum is 4.
 * There is no root-to-leaf path with sum = 5.
 * Example 3:
 *
 * Input: root = [], targetSum = 0
 * Output: false
 * Explanation: Since the tree is empty, there are no root-to-leaf paths.
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 5000].
 * -1000 <= Node.val <= 1000
 * -1000 <= targetSum <= 1000
 */
public class BTreePathSum0 {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        return pathSumHelper(root, targetSum, 0);
    }

    public boolean pathSumHelper(TreeNode node, int targetSum, int partialSum) {
        // BC
        if (node == null) {
            return false;
        }

        // H & I
        partialSum += node.val;
        if (node.left == null && node.right == null) {
            return partialSum == targetSum;
        }

        return pathSumHelper(node.left, targetSum, partialSum)
                || pathSumHelper(node.right, targetSum, partialSum);
    }

    boolean match = false;

    public boolean hasPathSumWithMemberVar(TreeNode root, int targetSum) {
        pathSumHelperMemVar(root, targetSum, 0);
        return match;
    }

    public void pathSumHelperMemVar(TreeNode node, int targetSum, int partialSum) {
        // BC
        if (node == null || match) {
            return;
        }

        // H & I
        partialSum += node.val;
        if (node.left == null && node.right == null) {
            match = (partialSum == targetSum);
        }
        //System.out.println("match is " + match + " partialSum is " + partialSum);
        if (match) {
            return;
        }

        pathSumHelperMemVar(node.left, targetSum, partialSum);
        pathSumHelperMemVar(node.right, targetSum, partialSum);
    }

    public static void main(String[] args) {
        BTreePathSum0 bTreePathSum = new BTreePathSum0();
        //Example 1:
        //
        //
        //Input: root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
        //Output: true
        TreeNode node7 = new TreeNode(7);
        TreeNode node2 = new TreeNode(2);
        TreeNode node11 = new TreeNode(11, node7, node2);
        TreeNode node13 = new TreeNode(13);
        TreeNode node4 = new TreeNode(4, node11, null);
        TreeNode node1 = new TreeNode(1);
        TreeNode node4_2 = new TreeNode(4, node13, node1);
        TreeNode node8 = new TreeNode(8, node13, node4_2);
        TreeNode root = new TreeNode(5, node4, node8);
        System.out.println("bTreePathSum.hasPathSum(root,22) should be true and the result is  " +
                bTreePathSum.hasPathSum(root, 22));
        System.out.println("bTreePathSum.hasPathSumWithMemberVar(root,22) should be true and the result is  " +
                bTreePathSum.hasPathSumWithMemberVar(root, 22));


        //Example 2:
        //
        //
        //Input: root = [1,2,3], targetSum = 5
        //Output: false
        bTreePathSum.match = false;
        TreeNode node3 = new TreeNode(3);
        TreeNode node2_2 = new TreeNode(2);
        TreeNode root2 = new TreeNode(1, node2_2, node3);
        System.out.println("bTreePathSum.hasPathSum(root2,5) should be false and the result is  " +
                bTreePathSum.hasPathSum(root2, 5));
        System.out.println("bTreePathSum.hasPathSumWithMemberVar(root2,5) should be false and the result is  " +
                bTreePathSum.hasPathSumWithMemberVar(root2, 5));
        //Example 3:
        //
        //
        //Input: root = [], targetSum = 0
        //Output: false
        bTreePathSum.match = false;
        System.out.println("bTreePathSum.hasPathSum(null,0) should be false and the result is  " +
                bTreePathSum.hasPathSum(null, 0));
        System.out.println("bTreePathSum.hasPathSumWithMemberVar(null,0) should be false and the result is  " +
                bTreePathSum.hasPathSumWithMemberVar(null, 0));


    }
}
