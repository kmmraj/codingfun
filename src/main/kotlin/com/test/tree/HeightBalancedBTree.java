package com.test.tree;

public class HeightBalancedBTree {
    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    static class TreeInfo {
        public boolean isHeightBalanced;
        public int height;

        public TreeInfo(boolean isHeightBalanced, int height) {
            this.isHeightBalanced = isHeightBalanced;
            this.height = height;
        }
    }

    public boolean heightBalancedBinaryTree(BinaryTree tree) {
        // Write your code here.
        TreeInfo treeInfo = getTreeInfo(tree);
        return treeInfo.isHeightBalanced;
    }

    private TreeInfo getTreeInfo(BinaryTree tree) {
        if(tree == null){
            return new TreeInfo(true,-1);
        }

        TreeInfo leftTreeInfo = getTreeInfo(tree.left);
        TreeInfo rightTreeInfo = getTreeInfo(tree.right);

        int height = Math.max(leftTreeInfo.height,rightTreeInfo.height)+1;
        boolean isBalanced = leftTreeInfo.isHeightBalanced
                && rightTreeInfo.isHeightBalanced
                && Math.abs(leftTreeInfo.height - rightTreeInfo.height) <=1;
        return new TreeInfo(isBalanced,height);
    }

    public static void main(String[] args) {
        TestCase1();
    }

    public static void TestCase1() {
        HeightBalancedBTree.BinaryTree root = new HeightBalancedBTree.BinaryTree(1);
        root = new HeightBalancedBTree.BinaryTree(1);
        root.left = new HeightBalancedBTree.BinaryTree(2);
        root.right = new HeightBalancedBTree.BinaryTree(3);
        root.left.left = new HeightBalancedBTree.BinaryTree(4);
        root.left.right = new HeightBalancedBTree.BinaryTree(5);
        root.right.right = new HeightBalancedBTree.BinaryTree(6);
        root.left.right.left = new HeightBalancedBTree.BinaryTree(7);
        root.left.right.right = new HeightBalancedBTree.BinaryTree(8);
        boolean expected = true;
        boolean actual = new HeightBalancedBTree().heightBalancedBinaryTree(root);
        System.out.println(expected == actual);
    }
}
