package com.test.dynamicprogramming;

import com.test.tree.TreeNode;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class GenerateBST {
    //List<TreeNode> ans;

    public GenerateBST() {

    }

    public List<TreeNode> generateTrees(int n) {
       return solveIt(1,n);
    }

    private List<TreeNode> solveIt(int start, int end){

        List<TreeNode> ans = new ArrayList<>();
        // BC
        if(start > end){
            ans.add(null);
            return ans;
        }

        // Hypothesis and Choice D
        for (int idx = start; idx <= end; idx++) {
            List<TreeNode> left =  solveIt(start,idx-1);
            List<TreeNode> right = solveIt(idx+1,end);

            for ( TreeNode lLeaf: left) {
                for (TreeNode rLeaf: right) {
                    TreeNode node = new TreeNode(idx,lLeaf,rLeaf);
                    ans.add(node);
                }
            }
        }


        return ans;
    }

    public static void main(String[] args) {
        GenerateBST bst = new GenerateBST();

        Instant start = Instant.now();
        System.out.println(bst.generateTrees(3));
        Instant end = Instant.now();
        Duration duration = Duration.between(start,end);
        System.out.println("Time taken : "+ duration.toMillis());
    }
}
