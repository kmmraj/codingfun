package com.test.linklist;

import com.test.tree.TreeNode;

import java.util.*;

public class InOrderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> resultList = new ArrayList<>();
        return inorderTraversal(root, resultList);
    }

    private List<Integer> inorderTraversal(TreeNode root, List<Integer> resultList) {
        // BC
        if (root == null) {
            return resultList;
        }

        // H & I
        inorderTraversal(root.left, resultList);
        resultList.add(root.val);
        inorderTraversal(root.right, resultList);
        return resultList;
    }

    public List<Integer> inorderTraversal2(TreeNode root) {

        if (root == null) {
            return Collections.emptyList();
        }

        List<Integer> resultList = new ArrayList<>();
        Deque<TreeNode> dq = new LinkedList<>();
        TreeNode node = root;

        while (node != null || !dq.isEmpty()) {
            while (node != null) {
                dq.addLast(node);
                node = node.left;
            }
            node = dq.removeLast();
            resultList.add(node.val);
            node = node.right;

        }
        return resultList;
    }

    public static void main(String[] args) {
        InOrderTraversal inOrderTraversal = new InOrderTraversal();

        System.out.println("inOrderTraversal.inorderTraversal(" +
                "new TreeNode(1,null,new TreeNode(2,new TreeNode(3),null))))" +
                "should be [1, 3, 2] and result is "
                + inOrderTraversal.inorderTraversal(
                new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null))));

        System.out.println("inOrderTraversal.inorderTraversal2(" +
                "new TreeNode(1,null,new TreeNode(2,new TreeNode(3),null))))" +
                "should be [1, 3, 2] and result is "
                + inOrderTraversal.inorderTraversal2(
                new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null))));

        System.out.println("preOrderTraversal.inOrderTraversal(" +
                "new TreeNode(1,\n" +
                "                        new TreeNode(2, new TreeNode(3), new TreeNode(4)),\n" +
                "                        new TreeNode(5, new TreeNode(6), new TreeNode(7))))" +
                "should be [3, 2, 4, 1, 6, 5, 7] and result is "
                + inOrderTraversal.inorderTraversal(
                new TreeNode(1,
                        new TreeNode(2, new TreeNode(3), new TreeNode(4)),
                        new TreeNode(5, new TreeNode(6), new TreeNode(7)))));

        System.out.println("preOrderTraversal.inOrderTraversal2(" +
                "new TreeNode(1,\n" +
                "                        new TreeNode(2, new TreeNode(3), new TreeNode(4)),\n" +
                "                        new TreeNode(5, new TreeNode(6), new TreeNode(7))))" +
                "should be [3, 2, 4, 1, 6, 5, 7] and result is "
                + inOrderTraversal.inorderTraversal2(
                new TreeNode(1,
                        new TreeNode(2, new TreeNode(3), new TreeNode(4)),
                        new TreeNode(5, new TreeNode(6), new TreeNode(7)))));

    }
}
