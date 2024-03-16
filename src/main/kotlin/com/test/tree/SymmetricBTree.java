package com.test.tree;
// https://leetcode.com/problems/symmetric-tree/

/**
 * 101. Symmetric Tree
 * Easy
 * Given the root of a binary tree, check whether it is a mirror of itself
 * (i.e., symmetric around its center).
 *
 *
 *
 * Example 1:
 * Input: root = [1,2,2,3,4,4,3]
 * Output: true
 *
 * Example 2:
 * Input: root = [1,2,2,null,3,null,3]
 * Output: false
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [1, 1000].
 * -100 <= Node.val <= 100
 *
 *
 * Follow up: Could you solve it both recursively and iteratively?
 */
public class SymmetricBTree {

    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        return isSymmetricHelper(root.left, root.right);
    }

    private boolean isSymmetricHelper(TreeNode nodeA, TreeNode nodeB) {
        // BC
        if (nodeA == null && nodeB == null) {
            return true;
        }

        // H & I
        if (nodeA != null && nodeB != null) {
            return nodeA.val == nodeB.val
                    && isSymmetricHelper(nodeA.left, nodeB.right)
                    && isSymmetricHelper(nodeA.right, nodeB.left);
        }

        return false;
    }


    public static void main(String[] args) {
        SymmetricBTree symmetricBTree = new SymmetricBTree();
        //* Example 1:
        // * Input: root = [1,2,2,3,4,4,3]
        // * Output: true
        // *
        System.out.println("symmetricBTree.isSymmetric(new TreeNode(1," +
                "new TreeNode(2,new TreeNode(3),new TreeNode(4))," +
                "new TreeNode(2,new TreeNode(4),new TreeNode(3)))) should be true and the result is  " +
                symmetricBTree.isSymmetric(new TreeNode(1,
                        new TreeNode(2,new TreeNode(3),new TreeNode(4)),
                        new TreeNode(2,new TreeNode(4),new TreeNode(3)))));
    }
}
