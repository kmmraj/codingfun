package com.test.linklist;
// https://leetcode.com/problems/binary-tree-preorder-traversal/description/

import com.test.tree.TreeNode;

import java.util.*;

/**
 * 144. Binary Tree Preorder Traversal
 * Given the root of a binary tree, return the preorder traversal of its nodes' values.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: root = [1,null,2,3]
 * Output: [1,2,3]
 * Example 2:
 * <p>
 * Input: root = []
 * Output: []
 * Example 3:
 * <p>
 * Input: root = [1]
 * Output: [1]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the tree is in the range [0, 100].
 * -100 <= Node.val <= 100
 * <p>
 * <p>
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 */
public class PreOrderTraversal {

    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        Deque<TreeNode> dq = new LinkedList<>();
        List<Integer> resultList = new ArrayList<>();
        dq.addLast(root);
        while (!dq.isEmpty()) {
            TreeNode node = dq.removeLast();
            // System.out.println("dq val is "+node.val + " node.left is "+node.left
            // + " node.right is " +node.right);
            resultList.add(node.val);
            if (node.right != null) {
                dq.addLast(node.right);
            }
            if (node.left != null) {
                dq.addLast(node.left);
            }

        }
        return resultList;
    }

    //List<Integer> resultList = new ArrayList<>();

    public List<Integer> preorderTraversal2(TreeNode root,List<Integer> resultList) {
        // BC
        if (root == null) {
            return resultList;
        }

        // H & I
        resultList.add(root.val);
        if (root.left != null) {
            preorderTraversal2(root.left,resultList);
        }
        if (root.right != null) {
            preorderTraversal2(root.right,resultList);
        }

        return resultList;

    }

    public static void main(String[] args) {
        PreOrderTraversal preOrderTraversal = new PreOrderTraversal();

        System.out.println("preOrderTraversal.preorderTraversal(" +
                "new TreeNode(1,null,new TreeNode(2,new TreeNode(3),null))))" +
                "should be [1, 2, 3] and result is "
                + preOrderTraversal.preorderTraversal(
                new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null))));

        System.out.println("preOrderTraversal.preorderTraversal2(" +
                "new TreeNode(1,null,new TreeNode(2,new TreeNode(3),null))))" +
                "should be [1, 2, 3] and result is "
                + preOrderTraversal.preorderTraversal2(
                new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null)), new ArrayList<>()));

        System.out.println("preOrderTraversal.preorderTraversal(" +
                "new TreeNode(1,null,new TreeNode(2,new TreeNode(3),null))))" +
                "should be [1, 2, 3, 4, 5, 6, 7] and result is "
                + preOrderTraversal.preorderTraversal(
                new TreeNode(1,
                        new TreeNode(2, new TreeNode(3), new TreeNode(4)),
                        new TreeNode(5, new TreeNode(6), new TreeNode(7)))));

        System.out.println("preOrderTraversal.preorderTraversal2(" +
                "new TreeNode(1,null,new TreeNode(2,new TreeNode(3),null))))" +
                "should be [1, 2, 3, 4, 5, 6, 7] and result is "
                + preOrderTraversal.preorderTraversal2(
                new TreeNode(1,
                        new TreeNode(2, new TreeNode(3), new TreeNode(4)),
                        new TreeNode(5, new TreeNode(6), new TreeNode(7))),new ArrayList<>()));
    }

}
