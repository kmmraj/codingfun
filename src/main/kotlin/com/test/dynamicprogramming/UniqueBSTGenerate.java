package com.test.dynamicprogramming;

import com.test.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class UniqueBSTGenerate {

//    List<TreeNode> workingTreeNodeList;
//
//    public UniqueBSTGenerate(){
//        workingTreeNodeList = new ArrayList<>();
//    }

    public List<TreeNode> generateTrees(int n) {

        List<TreeNode> answerTreeNodeList = new ArrayList<>();
        List<TreeNode> workingTreeNodeList2 = new ArrayList<>();
        //return solveItRecursively(n,answerTreeNodeList,workingTreeNodeList);
        return solveIt(1,n,workingTreeNodeList2);
    }

    private List<TreeNode> solveIt(int start, int end, List<TreeNode> workingTreeNodeList2) {

        List<TreeNode> workingTreeNodeList = new ArrayList<>();
        // BC
        if(start > end){
            workingTreeNodeList.add(null);
            return workingTreeNodeList;
        }

        if(start == end){
            workingTreeNodeList.add(new TreeNode(start));
            return workingTreeNodeList;
        }

        // Hypo & Choice D
        for (int idx = start; idx <= end; idx++) {
            List<TreeNode> left =  solveIt(start,idx-1,workingTreeNodeList);
            List<TreeNode> right =  solveIt(idx+1,end,workingTreeNodeList);
            for (TreeNode lNode: left) {
                for (TreeNode rNode:right) {
                    workingTreeNodeList.add(new TreeNode(idx,lNode,rNode));
                }
            }
        }
        return workingTreeNodeList;
    }


    private List<TreeNode> solveItRecursively(int n,
                                              List<TreeNode> answerTreeNodeList,
                                              List<TreeNode> workingTreeNodeList) {
        // BC
        if(n==0 ) {
            return workingTreeNodeList;
        }

        if( n==1) {

            return workingTreeNodeList;
        }
        List<TreeNode> left = null;
        List<TreeNode> right = null;
        // Hypothesis and choices
        for (int idx = 1; idx <= n; idx++) {
            workingTreeNodeList.add(new TreeNode(idx));
            left = solveItRecursively(idx-1,answerTreeNodeList,workingTreeNodeList);
            right = solveItRecursively(n-idx,answerTreeNodeList,workingTreeNodeList);
        }
        TreeNode parentNode = workingTreeNodeList.get(0);
        parentNode.left = left.get(0);
        parentNode.right = right.get(0);



        return workingTreeNodeList;
    }

    public static void main(String[] args) {
        UniqueBSTGenerate bstGenerate =  new UniqueBSTGenerate();
        List<TreeNode> answer = bstGenerate.generateTrees(3);
        for (TreeNode ans:answer) {
            System.out.println(ans);
        }

    }
}
