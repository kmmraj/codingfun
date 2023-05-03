package com.test.tree;

import java.util.*;

public class BTreePathSum3 {

    List<List<Integer>> matchingList;
  //  List<Integer> workingList;
   // Queue<TreeNode> treeNodeList;
    ArrayList<Integer> path;
    int workingSum;
    int totalCount =0;

    public int pathSum(TreeNode root, int sum) {

        workingSum =0;
    //    this.matchingList = new LinkedList();
    //    this.workingList = new ArrayList<Integer>();
     //   this.treeNodeList = new LinkedList<TreeNode>();
        this.path =  new ArrayList<Integer>();

        if(root != null){
            solveItDFS(root,sum);
        }
//        for (List item:matchingList) {
//            System.out.println(item);
//        }
        return totalCount;
    }

    private void solveItDFS(TreeNode node, int sum) {
        // BC
        if(node == null){
            return;
        }

        // Hypothesis & Induction
        path.add(node.val);

        solveItDFS(node.left,sum);

        solveItDFS(node.right,sum);
        workingSum=0;
        for (int index = path.size()-1; index >= 0; index--) {
            workingSum += path.get(index);
            if(workingSum == sum){
                //add2WorkingList(path,index);
                totalCount++;
            }
        }
        path.remove(path.size()-1);
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

    public static void main(String[] args) {
        TreeNode ch10 = new TreeNode(1);
        TreeNode ch9 = new TreeNode(-2);
        TreeNode ch8 = new TreeNode(3);

        TreeNode ch7 = new TreeNode(11);
        TreeNode ch6 = new TreeNode(6);
        TreeNode ch5 = new TreeNode(2,null,ch10);
        TreeNode ch4 = new TreeNode(3,ch8,ch9);
        TreeNode ch3 = new TreeNode(-3,null,ch7);
        TreeNode ch2 = new TreeNode(5,ch4,ch5);
        TreeNode ch1 = new TreeNode(10,ch2,ch3);

        BTreePathSum3 bTreePathSum3 = new BTreePathSum3();
        List<List<Integer>> matchingList;
        int count = bTreePathSum3.pathSum(ch1,8);

        System.out.println(count);

//        for (List<Integer> item: matchingList) {
//            System.out.println(item);
//        }


//        TreeNode ch2a = new TreeNode(2,null,null);
//        TreeNode ch1a = new TreeNode(1,ch2a,null);
//        matchingList = bTreePathSum3.pathSum(ch1a,3);
//
//        for (List<Integer> item: matchingList) {
//            System.out.println(item);
//        }
//
//        TreeNode ch2b = new TreeNode(2,null,null);
//        TreeNode ch1b = new TreeNode(1,ch2b,null);
//        matchingList = bTreePathSum3.pathSum(ch1b,0);
//
//        for (List<Integer> item: matchingList) {
//            System.out.println(item);
//        }
//
//
//        TreeNode ch2c = new TreeNode(2,null,null);
//        TreeNode ch1c = new TreeNode(1,ch2c,null);
//        matchingList = bTreePathSum3.pathSum(ch1c,1);
//
//        for (List<Integer> item: matchingList) {
//            System.out.println(item);
//        }

    }
}
