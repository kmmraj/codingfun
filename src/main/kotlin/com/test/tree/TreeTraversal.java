package com.test.tree;

import java.util.*;

public class TreeTraversal {

    Queue<TreeNode> queue = new LinkedList<TreeNode>();


    void printPreOrder(TreeNode root) {
        if(root == null){
            System.out.println("null");
            return;
        }
        System.out.println(root.val);
        printPreOrder(root.left);
        printPreOrder(root.right);
    }

    void printInOrder(TreeNode root) {
        if(root == null){
            return;
        }
        printInOrder(root.left);
        System.out.println(root.val);
        printInOrder(root.right);
    }

    void printPostOrder(TreeNode root) {
        if(root == null){
            return;
        }
        printPostOrder(root.left);
        printPostOrder(root.right);
        System.out.println(root.val);
    }

    public List<List<Integer>> printLevelOrder(TreeNode root) {

        List<List<Integer>> levelOrderList = new ArrayList<List<Integer>>();

        if (root != null) {
            ArrayList<Integer> innerList = new ArrayList<Integer>();
            innerList.add(root.val);
            levelOrderList.add(innerList);
           // System.out.println(root.val);
            if (root.left != null) {
                queue.offer(root.left);
            }
            if (root.right != null) {
                queue.offer(root.right);
            }
            solveIt(queue,levelOrderList);

        }

        return levelOrderList;
    }

    private void solveIt(Queue<TreeNode> queue, List<List<Integer>> levelOrderList) {

        while (!queue.isEmpty()){

            int queueSize =  queue.size();
            ArrayList<Integer> innerList = new ArrayList<Integer>(queueSize);
            for (int index = 0; index < queueSize; index++) {
                TreeNode tempTreeNode =  queue.poll();
                if(tempTreeNode != null) {
                    innerList.add(tempTreeNode.val);

                 //   System.out.println(tempTreeNode.val);
                    if(tempTreeNode.left != null) {
                        queue.offer(tempTreeNode.left);
                    }

                    if(tempTreeNode.right != null)  {
                        queue.offer(tempTreeNode.right);
                    }
                }

            }
            levelOrderList.add(innerList);


            solveIt(queue,levelOrderList);
        }

    }

   public List<List<Integer>> printLevelOrderReverse(TreeNode root) {

        Stack<List<Integer>> levelOrderList = new Stack<List<Integer>>();

        if (root != null) {
            ArrayList<Integer> innerList = new ArrayList<Integer>();
            innerList.add(root.val);
            levelOrderList.add(innerList);
            // System.out.println(root.val);
            if (root.left != null) {
                queue.offer(root.left);
            }
            if (root.right != null) {
                queue.offer(root.right);
            }
            solveItReverse(queue,levelOrderList);

        }

        List<List<Integer>> reversedList = new ArrayList<List<Integer>>();

        while (!levelOrderList.empty()){
            reversedList.add(levelOrderList.pop());
        }



        return reversedList;
    }


    private void solveItReverse(Queue<TreeNode> queue, Stack<List<Integer>> levelOrderList) {

        while (!queue.isEmpty()){

            int queueSize =  queue.size();
            ArrayList<Integer> innerList = new ArrayList<Integer>(queueSize);
            for (int index = 0; index < queueSize; index++) {
                TreeNode tempTreeNode =  queue.poll();
                if(tempTreeNode != null) {
                    innerList.add(tempTreeNode.val);

                    //   System.out.println(tempTreeNode.val);
                    if(tempTreeNode.left != null) {
                        queue.offer(tempTreeNode.left);
                    }

                    if(tempTreeNode.right != null)  {
                        queue.offer(tempTreeNode.right);
                    }
                }

            }
            levelOrderList.add(innerList);


            solveItReverse(queue,levelOrderList);
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

        TreeTraversal treeTraversal = new TreeTraversal();
        System.out.println("--------Pre--Order------------");
        treeTraversal.printPreOrder(root);
        System.out.println("--------In--Order-------------");
        treeTraversal.printInOrder(root);
        System.out.println("--------Post--Order-----------");
        treeTraversal.printPostOrder(root);

        System.out.println("--------Level--Order----------");
        List<List<Integer>> levelOrderList = treeTraversal.printLevelOrder(root);
        for (List<Integer> item: levelOrderList) {
            System.out.println(item);
        }


        System.out.println("--------Level--Order-Reversed--");
        List<List<Integer>> reversedOrderList = treeTraversal.printLevelOrderReverse(root);
        for (List<Integer> item: reversedOrderList) {
            System.out.println(item);
        }
    }
}
