package com.test.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BTreePathSum2 {

    List matchingList;
    List<Integer> workingList;
    Stack<TreeNode> workingStack;
    int workingSum;

    public List<List<Integer>> pathSum(TreeNode root, int sum) {

        workingSum =0;
        this.matchingList = new LinkedList();
        this.workingList = new LinkedList();
        this.workingStack = new Stack<TreeNode>();

        if(root != null){
            solveItDFS(root,sum);
        }
        return matchingList;
    }

    private void solveItDFS(TreeNode node, int sum) {
        // BC
        if(node == null){
            if(workingSum == sum
                    &&  !this.workingList.isEmpty()
                    && this.workingStack.peek().left == null
                    && this.workingStack.peek().right == null) {
                this.matchingList.add(new ArrayList<Integer>(this.workingList));
            }
            return;
        }

        // Hypothesis & Induction

        workingList.add(node.val);
        workingStack.push(node);
        workingSum = workingSum + node.val;




        solveItDFS(node.left,sum);
        if(!workingStack.empty() && workingStack.peek() == node &&  node.right == null){
            workingStack.pop();
            workingSum = workingSum - node.val;
            workingList.remove(workingList.size()-1);
        }


        solveItDFS(node.right,sum);

        // TODO: Check  node.left!= null
        if(!workingStack.empty() && workingStack.peek() == node){
            workingStack.pop();
            workingSum = workingSum - node.val;
            workingList.remove(workingList.size()-1);
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
        TreeNode ch1 = new TreeNode(1,ch2,ch3);

        BTreePathSum2 pathSum2 = new BTreePathSum2();
        List<List<Integer>> matchingList;
        matchingList = pathSum2.pathSum(ch1,8);

        for (List<Integer> item: matchingList) {
            System.out.println(item);
        }


        TreeNode ch2a = new TreeNode(2,null,null);
        TreeNode ch1a = new TreeNode(1,ch2a,null);
        matchingList = pathSum2.pathSum(ch1a,3);

        for (List<Integer> item: matchingList) {
            System.out.println(item);
        }

        TreeNode ch2b = new TreeNode(2,null,null);
        TreeNode ch1b = new TreeNode(1,ch2b,null);
        matchingList = pathSum2.pathSum(ch1b,0);

        for (List<Integer> item: matchingList) {
            System.out.println(item);
        }


        TreeNode ch2c = new TreeNode(2,null,null);
        TreeNode ch1c = new TreeNode(1,ch2c,null);
        matchingList = pathSum2.pathSum(ch1c,1);

        for (List<Integer> item: matchingList) {
            System.out.println(item);
        }

    }
}
