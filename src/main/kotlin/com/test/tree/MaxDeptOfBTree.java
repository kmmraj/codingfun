package com.test.tree;

import java.util.LinkedList;
import java.util.Queue;

public class MaxDeptOfBTree {
    public int maxDepth(TreeNode root) {
        if(root ==null){
            return 0;
        }

        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        return Math.max(leftDepth,rightDepth)+1;
    }

    public int minDepth(TreeNode root) {
        if(root ==null){
            return 0;
        }

        int leftDepth = minDepth(root.left);
        int rightDepth = minDepth(root.right);

        return Math.min(leftDepth,rightDepth)+1;
    }

    public int maxDepthWithBFS(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int maxDepth = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            maxDepth++;
            for (int index = 0; index < queue.size(); index++) {
                TreeNode tempNode = queue.remove();
                if (tempNode.left != null) {
                    queue.add(tempNode.left);
                }
                if (tempNode.right != null) {
                    queue.add(tempNode.right);
                }
            }
        }
        return maxDepth;
    }

    public int minDepthWithBFS(TreeNode root) {
        if(root == null) return 0;
        int depth = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){

            int size = queue.size();
            for(int index=0; index< size; index++){
                TreeNode tempNode = queue.remove();
                if(tempNode.left == null && tempNode.right == null){
                    return depth;
                }
                if(tempNode.left != null) {
                    queue.add(tempNode.left);
                }
                if(tempNode.right != null) {
                    queue.add(tempNode.right);
                }
            }
            depth++;
        }
        return depth;
    }




    public static void main(String[] args) {

        TreeNode ch9 = new TreeNode(9);
        TreeNode ch8 = new TreeNode(8,ch9,null);
        TreeNode ch7 = new TreeNode(7);
        TreeNode ch6 = new TreeNode(6);
        TreeNode ch5 = new TreeNode(5);
        TreeNode ch4 = new TreeNode(4,ch8,null);
        TreeNode ch3 = new TreeNode(3,ch6,ch7);
        TreeNode ch2 = new TreeNode(2,ch4,ch5);
        TreeNode ch1 = new TreeNode(1,ch2,ch3);

        MaxDeptOfBTree balancedBTree = new MaxDeptOfBTree();
        System.out.println(balancedBTree.maxDepth(ch1));
        System.out.println(balancedBTree.minDepth(ch1));
        System.out.println(balancedBTree.maxDepthWithBFS(ch1));
        System.out.println(balancedBTree.minDepthWithBFS(ch1));

    }
}
