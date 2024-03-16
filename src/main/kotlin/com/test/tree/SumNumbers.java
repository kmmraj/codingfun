package com.test.tree;
// https://leetcode.com/problems/sum-root-to-leaf-numbers/

/**
 * You are given the root of a binary tree containing digits from 0 to 9 only.
 *
 * Each root-to-leaf path in the tree represents a number.
 *
 * For example, the root-to-leaf path 1 -> 2 -> 3 represents the number 123.
 * Return the total sum of all root-to-leaf numbers.
 * Test cases are generated so that the answer will fit in a 32-bit integer.
 *
 * A leaf node is a node with no children.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [1,2,3]
 * Output: 25
 * Explanation:
 * The root-to-leaf path 1->2 represents the number 12.
 * The root-to-leaf path 1->3 represents the number 13.
 * Therefore, sum = 12 + 13 = 25.
 *
 *
 * Example 2:
 * Input: root = [4,9,0,5,1]
 * Output: 1026
 * Explanation:
 * The root-to-leaf path 4->9->5 represents the number 495.
 * The root-to-leaf path 4->9->1 represents the number 491.
 * The root-to-leaf path 4->0 represents the number 40.
 * Therefore, sum = 495 + 491 + 40 = 1026.
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [1, 1000].
 * 0 <= Node.val <= 9
 * The depth of the tree will not exceed 10.
 */
public class SumNumbers {

    int total = 0;

    public int sumNumbers(TreeNode root) {
//        return sumNumbersHelper(root,0,"");
         sumNumbersHelperUsingClassMem(root,0);
        return total;
    }

    private void sumNumbersHelperUsingClassMem(TreeNode node, int partialSum) {
        // BC
        if (node == null) {
            return;
        }

        // H & I
        partialSum = 10 * partialSum + node.val;
        if (node.left == null && node.right == null) {
            total = total + partialSum;
            return;
        }

        sumNumbersHelperUsingClassMem(node.left, partialSum);
        sumNumbersHelperUsingClassMem(node.right, partialSum);
    }

    private int sumNumbersHelper(TreeNode node,int partialSum,String number){
        // BC
        if(node == null ){
            return 0;
        }

        // H & I
        number = number + node.val;

        if(node.left == null && node.right == null){
            return partialSum + Integer.parseInt(number);
        }

        return sumNumbersHelper(node.left,partialSum,number)
                + sumNumbersHelper(node.right,partialSum,number);
    }

    public static void main(String[] args) {
        SumNumbers sumNumbers = new SumNumbers();
        //Example 1:
        //Input: root = [1,2,3]
        //Output: 25
        System.out.println("sumNumbers.sumNumbers(new TreeNode(1,new TreeNode(2),new TreeNode(3))) should be 25 and the result is  " +
                sumNumbers.sumNumbers(new TreeNode(1,new TreeNode(2),new TreeNode(3))));

        sumNumbers.total = 0;

        //Example 2:
        //Input: root = [4,9,0,5,1]
        //Output: 1026
        //       4
        //      / \
        //     9   0
        //    / \
        //   5   1

        System.out.println("sumNumbers.sumNumbers(new TreeNode(4,new TreeNode(9,new TreeNode(5),new TreeNode(1)),new TreeNode(0))) should be 1026 and the result is  " +
                sumNumbers.sumNumbers(new TreeNode(4,
                        new TreeNode(9,new TreeNode(5),new TreeNode(1)),
                        new TreeNode(0))));
    }
}
