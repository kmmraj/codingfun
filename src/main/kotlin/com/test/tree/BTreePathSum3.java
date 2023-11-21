package com.test.tree;

import java.util.*;

public class BTreePathSum3 {

    List<List<Integer>> matchingList;
    //  List<Integer> workingList;
    // Queue<TreeNode> treeNodeList;
    ArrayList<Integer> path;
    long workingSum;
    int totalCount = 0;

    List<Integer> nodeList;

//    public int pathSum(TreeNode root, int sum) {
//
//        workingSum =0;
//    //    this.matchingList = new LinkedList();
//    //    this.workingList = new ArrayList<Integer>();
//     //   this.treeNodeList = new LinkedList<TreeNode>();
//        this.path =  new ArrayList<>();
//
//        if(root != null){
//            solveItDFS(root,sum);
//        }
////        for (List item:matchingList) {
////            System.out.println(item);
////        }
//        return totalCount;
//    }

    private void solveItDFS(TreeNode node, int sum) {
        // BC
        if (node == null) {
            return;
        }

        // Hypothesis & Induction
        path.add(node.val);

        solveItDFS(node.left, sum);

        solveItDFS(node.right, sum);
        workingSum = 0;
        for (int index = path.size() - 1; index >= 0; index--) {
            workingSum += path.get(index);
            if (workingSum == sum) {
                //add2WorkingList(path,index);
                totalCount++;
            }
        }
        path.remove(path.size() - 1);
    }

//    void add2WorkingList(ArrayList<Integer> path, int index){
//
//        for (int negIndex = index; negIndex < path.size() ; negIndex++) {
//            this.workingList.add(path.get(negIndex));
//        }
//        this.matchingList.add(new ArrayList<Integer>(workingList));
//        workingList.clear();
//
//    }


    public int pathSum(TreeNode root, int targetSum) {
        nodeList = new ArrayList<>();
        if (root == null)
            return 0;
        solveIt(root, targetSum);
        return totalCount;
    }

    private void solveIt(TreeNode node, int targetSum) {
        if (node == null)
            return;

        nodeList.add(node.val);

        solveIt(node.left, targetSum);
        solveIt(node.right, targetSum);

        workingSum = 0;
        for (int index = nodeList.size() - 1; index >= 0; index--) {
            workingSum += nodeList.get(index);
            if (workingSum == targetSum)
                totalCount++;
        }
        nodeList.remove(nodeList.size() - 1);
    }

    public static void main(String[] args) {
        int count = 0;
        BTreePathSum3 bTreePathSum3 = new BTreePathSum3();
        // TC1: [10,5,-3,3,2,null,11,3,-2,null,1]
        TreeNode ch10 = new TreeNode(1);
        TreeNode ch9 = new TreeNode(-2);
        TreeNode ch8 = new TreeNode(3);

        TreeNode ch7 = new TreeNode(11);
        TreeNode ch5 = new TreeNode(2, null, ch10);
        TreeNode ch4 = new TreeNode(3, ch8, ch9);
        TreeNode ch3 = new TreeNode(-3, null, ch7);
        TreeNode ch2 = new TreeNode(5, ch4, ch5);
        TreeNode ch1 = new TreeNode(10, ch2, ch3);


        count = bTreePathSum3.pathSum(ch1, 8);

        System.out.println(count);

        // TC2: [5,4,8,11,null,13,4,7,2,null,null,5,1]

        TreeNode ch11 = new TreeNode(1);
        TreeNode ch12 = new TreeNode(5);
        TreeNode ch13 = new TreeNode(2);
        TreeNode ch14 = new TreeNode(7);
        TreeNode ch15 = new TreeNode(4, ch11, null);
        TreeNode ch16 = new TreeNode(13);
        TreeNode ch17 = new TreeNode(11, ch14, ch15);
        TreeNode ch18 = new TreeNode(8, ch16, ch17);
        TreeNode ch19 = new TreeNode(4, ch12, ch13);
        TreeNode ch20 = new TreeNode(5, ch18, ch19);


        count = bTreePathSum3.pathSum(ch20, 22);

        System.out.println(count);

        // TC3: [1000000000,1000000000,null,294967296,null,1000000000,null,1000000000,null,1000000000]
        // Result: 0
        bTreePathSum3.totalCount = 0;
        TreeNode ch21 = new TreeNode(1000000000);
        TreeNode ch22 = new TreeNode(1000000000, null, ch21);
        TreeNode ch23 = new TreeNode(1000000000, null, ch22);
        TreeNode ch25 = new TreeNode(294967296, null, ch23);
        TreeNode ch26 = new TreeNode(1000000000, null, ch25);
        TreeNode ch27 = new TreeNode(1000000000,ch26,null);

        count = bTreePathSum3.pathSum(ch27, 0);

        System.out.println(count);







    }
}
