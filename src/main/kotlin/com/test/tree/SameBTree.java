package com.test.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SameBTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {

        ArrayList<Integer> pList = new ArrayList<Integer>();
        Queue<TreeNode> pQueue  = new LinkedList<TreeNode>();
        if(p!=null){
            pList.add(p.val);
            pQueue.add(p.left);
            pQueue.add(p.right);
        }
        solveIt(pList,pQueue);
        //ArrayList<Integer> pList =  list;

        ArrayList<Integer> qList = new ArrayList<Integer>();
        Queue<TreeNode> qQueue  = new LinkedList<TreeNode>();
        if(q!=null){
            qList.add(q.val);
            qQueue.add(q.left);
            qQueue.add(q.right);
        }
        solveIt(qList,qQueue);

       return pList.equals(qList);

    }

    private void solveIt(ArrayList<Integer> list, Queue<TreeNode> queue) {
        while (!queue.isEmpty()){
           TreeNode tempNode = queue.poll();
           if(tempNode!=null){
               list.add(tempNode.val);
               if(tempNode.left != null){
                   queue.add(tempNode.left);
               } else {
                   queue.add(null);
               }
               if(tempNode.right != null){
                   queue.add(tempNode.right);
               } else {
                   queue.add(null);
               }
           } else {
               list.add(null);
           }


            solveIt(list,queue);
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
        TreeNode rootp = new TreeNode(1,ch2,ch3);


        TreeNode chq3 = new TreeNode(3,null,null);
        TreeNode chq2 = new TreeNode(2,null,null);
        TreeNode rootq = new TreeNode(1,chq2,chq3);


        SameBTree bTree = new SameBTree();
        boolean isSame = bTree.isSameTree(rootp,rootq);
        System.out.println(isSame);

    }
}
