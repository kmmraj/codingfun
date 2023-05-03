package com.test.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageLevelsBTree {

    Queue<TreeNode> queue = new LinkedList<TreeNode>();

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> averageList = new ArrayList<Double>();
        if(root != null){
            averageList.add((double) root.val);
            if(root.left!=null){
                queue.offer(root.left);
            }

            if(root.right!=null){
                queue.offer(root.right);
            }

            solveIt(queue,averageList);
        }

        return averageList;

    }

    private void solveIt(Queue<TreeNode> queue, List<Double> averageList) {
        while (!queue.isEmpty()){
            int queueSize = queue.size();
            double average = 0.0;
            double sum=0.0;
            for (int index = 0; index < queueSize; index++) {
                TreeNode tempNode = queue.poll();
                if(tempNode!= null){
                    sum = sum+tempNode.val;
                    if(tempNode.left!=null)
                        queue.add(tempNode.left);
                    if(tempNode.right!=null)
                        queue.add(tempNode.right);
                }

            }
            average = sum/queueSize;
            averageList.add(average);
            solveIt(queue,averageList);
        }
    }


    public static void main(String[] args) {

        TreeNode ch8 = new TreeNode(8);

        TreeNode ch7 = new TreeNode(7);
        TreeNode ch6 = new TreeNode(6);
        TreeNode ch5 = new TreeNode(5);
        TreeNode ch4 = new TreeNode(4,ch8,null);
        TreeNode ch3 = new TreeNode(3,ch6,ch7);
        TreeNode ch2 = new TreeNode(2,ch4,ch5);
        TreeNode root = new TreeNode(1,ch2,ch3);


        AverageLevelsBTree bTree = new AverageLevelsBTree();
        List<Double> averageList = bTree.averageOfLevels(root);

        for (Double item: averageList) {
            System.out.println(item);
        }
    }
}
