package com.test.tree;

import java.util.ArrayDeque;

public class DiameterOfBTree {

    static class Diameter{
        public int value = Integer.MIN_VALUE;
    }

    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    public int binaryTreeDiameter(BinaryTree tree) {
        Diameter dia = new Diameter();
        binaryTreeDiameter(tree,dia);
        return dia.value==Integer.MIN_VALUE?0:dia.value-1;
    }

    private int binaryTreeDiameter(BinaryTree tree,Diameter diameter){
        //BC -- get the dia return
        if(tree == null)
            return 0;

        // Hypo & Choices
        int leftDept = binaryTreeDiameter(tree.left,diameter);
        int rightDept =  binaryTreeDiameter(tree.right,diameter);

        // Induction - Backtracking
        diameter.value = Math.max(diameter.value,leftDept+rightDept+1);
        return Math.max(leftDept,rightDept)+1;
    }

//    private int binaryTreeDiameter(BinaryTree tree, int leftDept, int rightDept, int diameter, int currDia) {
//        //BC
//        if (tree == null)
//            return currDia;
//        // Hypo & Choices
//        currDia = binaryTreeDiameter(tree.left, leftDept + 1, rightDept, diameter, leftDept + rightDept)
//                + binaryTreeDiameter(tree.right, leftDept, rightDept + 1, diameter, leftDept + rightDept);
//        diameter = Math.max(diameter, currDia);
//        return diameter;
//    }

    public static void main(String[] args) {
        TestCase1();
    }

    public static void TestCase1() {
        TestBinaryTree input = new TestBinaryTree(1);
        input.insert(new int[]{2, 3, 4, 5, 6, 7}, 0);
        int expected = 4;
        int actual = new DiameterOfBTree().binaryTreeDiameter(input);
        System.out.println(expected == actual);
    }

    static class TestBinaryTree extends DiameterOfBTree.BinaryTree {
        public TestBinaryTree(int value) {
            super(value);
        }

        public void insert(int[] values, int i) {
            if (i >= values.length) {
                return;
            }
            ArrayDeque<DiameterOfBTree.BinaryTree> queue = new ArrayDeque<BinaryTree>();
            queue.addLast(this);
            while (queue.size() > 0) {
                DiameterOfBTree.BinaryTree current = queue.pollFirst();
                if (current.left == null) {
                    current.left = new DiameterOfBTree.BinaryTree(values[i]);
                    break;
                }
                queue.addLast(current.left);
                if (current.right == null) {
                    current.right = new DiameterOfBTree.BinaryTree(values[i]);
                    break;
                }
                queue.addLast(current.right);
            }
            insert(values, i + 1);
        }
    }
}
