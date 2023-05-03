package com.test.tree;

//https://www.algoexpert.io/questions/Node%20Depths

public class NodeDepthSum {
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

    public static class GrandCount{
         int sum;
    }

    public static int nodeDepths(BinaryTree root) {
        // Write your code here.
        GrandCount grandCount = new GrandCount();
        grandCount.sum = 0;
        solveItDFS(root,grandCount,0);
        return grandCount.sum;
    }

    public static GrandCount solveItDFS(BinaryTree node, GrandCount count,int sum){
        // BC
        if(node == null)
            return count;

        if(node.left!=null){
            sum = sum+1;
            count.sum = count.sum + sum;
        }
        solveItDFS(node.left,count,sum);
        if(node.right!=null && node.left!=null){
            sum--;
        }
        if(node.right!=null){
            sum = sum+1;
            count.sum = count.sum + sum;
        }
        solveItDFS(node.right,count,sum);

        return count;
    }

    public static void main(String[] args) {
        BinaryTree ch9 = new BinaryTree(9);
        BinaryTree ch8 = new BinaryTree(8);
        BinaryTree ch7 = new BinaryTree(7);
        BinaryTree ch6 = new BinaryTree(6);
        BinaryTree ch5 = new BinaryTree(5);
        BinaryTree ch4 = new BinaryTree(4,ch8,ch9);
        BinaryTree ch3 = new BinaryTree(3,ch6,ch7);
        BinaryTree ch2 = new BinaryTree(2,ch4,ch5);
        BinaryTree ch1 = new BinaryTree(1,ch2,ch3);

        System.out.println(NodeDepthSum.nodeDepths(ch1));

    }
}
