package com.test.tree;

import java.util.ArrayList;
import java.util.List;

public class BTreePathSum {
    public static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        BinaryTree(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
        BinaryTree(int value,BinaryTree leftTree,BinaryTree rightTree) {
            this.value = value;
            this.left = leftTree;
            this.right = rightTree;
        }
    }

    public static List<Integer> branchSums(BinaryTree root) {
        // Write your code here.
        return solveItDFS(root,0, new ArrayList<Integer>());
    }

    public static List<Integer> solveItDFS(BinaryTree node, int workingSum,List<Integer> workingList) {
        //BC
        if(node == null) {
            return workingList;
        }

        int newWorkingSum = workingSum+node.value;
        if(node.left== null && node.right==null){
            workingList.add(newWorkingSum);
            return workingList;
        }

        // Hypo & Choices
        solveItDFS(node.left,newWorkingSum,workingList);
        solveItDFS(node.right,newWorkingSum,workingList);
        return workingList;
    }

    public static void main(String[] args) {
        BinaryTree ch8 = new BinaryTree(8);
        BinaryTree ch7 = new BinaryTree(7);
        BinaryTree ch6 = new BinaryTree(6);
        BinaryTree ch5 = new BinaryTree(5);
        BinaryTree ch4 = new BinaryTree(4,ch8,null);
        BinaryTree ch3 = new BinaryTree(3,ch6,ch7);
        BinaryTree ch2 = new BinaryTree(2,ch4,ch5);
        BinaryTree ch1 = new BinaryTree(1,ch2,ch3);

        List<Integer> answerSumList = BTreePathSum.branchSums(ch1);
        for (int item: answerSumList) {
            System.out.printf("%2d, ",item);
        }
    }
}
