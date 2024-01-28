package com.test.linklist;

import com.test.tree.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LevelOrderTraversal {


    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        levelOrder(root, result, 0);
        return result;
    }

    private List<List<Integer>> levelOrder(
            TreeNode node,
            List<List<Integer>> result,
            int level) {

        if (node == null) {
            return result;
        } else {
            if (result.size() <= level) {
                result.add(new ArrayList<>());
            }
            result.get(level).add(node.val);

            if (node.left != null) {
                levelOrder(node.left, result, level + 1);
            }
            if (node.right != null) {
                levelOrder(node.right, result, level + 1);
            }
        }
        return result;
    }

    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Deque<TreeNode> dq = new LinkedList<>();
        dq.addFirst(root);

        while (!dq.isEmpty()) {
            int size = dq.size();
            List<Integer> tempList = new ArrayList<>();
            //  System.out.println("size is " + size);
            for (int idx = 0; idx < size; idx++) {
                TreeNode node = dq.removeLast();
                tempList.add(node.val);
                if (node.left != null) {
                    dq.addFirst(node.left);
                }
                if (node.right != null) {
                    dq.addFirst(node.right);
                }
            }
            result.add(tempList);
        }
        return result;
    }

    public static void main(String[] args) {
        LevelOrderTraversal levelOrderTraversal = new LevelOrderTraversal();

        System.out.println("levelOrderTraversal.levelOrder(" +
                "new TreeNode(3," +
                "new TreeNode(9),new TreeNode(20," +
                "new TreeNode(15),new TreeNode(7)))))" +
                " should be [[3], [9, 20], [15, 7]] and result is "
                + levelOrderTraversal.levelOrder(
                new TreeNode(3,
                        new TreeNode(9), new TreeNode(20,
                        new TreeNode(15), new TreeNode(7)))));

        System.out.println("levelOrderTraversal.levelOrder2(" +
                "new TreeNode(3,new TreeNode(9),new TreeNode(20,new TreeNode(15),new TreeNode(7)))))" +
                " should be [[3], [9, 20], [15, 7]] and result is "
                + levelOrderTraversal.levelOrder2(
                new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)))));
    }
}
