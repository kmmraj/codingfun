package com.test.tree;

import java.util.ArrayList;
import java.util.List;

public class FlipBTree2MatchPreOrderTraversal {
    List<Integer> flippedList = new ArrayList<Integer>();
    int index =0;
    int[] voyage;

    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {

        this.voyage = voyage;


        if(root!= null && voyage.length!=0){
            if(root.val != voyage[0]){
                flippedList.add(-1);
                return flippedList;
            }
            flippedList =  preOrderTraversal(root);
        }


        return flippedList;

    }

    private List<Integer> preOrderTraversal(TreeNode root) {
        if(root  == null){
            return flippedList;
        }
        if(index < voyage.length && root.val != voyage[index++]){
            flippedList.clear();
            flippedList.add(-1);
            return flippedList;
        }
       // System.out.println(root.val + " : "+ voyage[index]);
        if(index < voyage.length
                && root.left != null
                && root.left.val != voyage[index]){
            flippedList.add(root.val);
            preOrderTraversal(root.right);
            preOrderTraversal(root.left);
        } else {
            preOrderTraversal(root.left);
            preOrderTraversal(root.right);
        }

        return flippedList;
    }


    public static void main(String[] args) {


        TreeNode chq3 = new TreeNode(3,null,null);
        TreeNode chq2 = new TreeNode(2,null,null);
        TreeNode rootq = new TreeNode(1,chq2,chq3);
        int[] voyage = {1,2,3};
        List<Integer> resultList;


        FlipBTree2MatchPreOrderTraversal bTree = new FlipBTree2MatchPreOrderTraversal();

//        resultList = bTree.flipMatchVoyage(rootq,voyage);
//        System.out.println(resultList);

        TreeNode chq3a = new TreeNode(3,null,null);
        TreeNode chq2a = new TreeNode(2,chq3a,null);
        TreeNode rootqA = new TreeNode(1,chq2a,null);
        int[] voyageA = {1,2,3};

        resultList = bTree.flipMatchVoyage(rootqA,voyageA);
        System.out.println(resultList);

    }
}
