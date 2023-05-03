package com.test.tree;

import java.util.ArrayDeque;

public class InvertBTree {
    public static void invertBinaryTree(BinaryTree tree) {
        BinaryTree invertedBTree = new BinaryTree(tree.value);
        ///solveItInvertBT(tree, invertedBTree);
        solveItInvertBTCopy(tree);
    }

    private static void solveItInvertBT(BinaryTree tree, BinaryTree invertedTree) {
        if (tree == null)
            return;
        if (tree.left != null && tree.right != null) {
            invertedTree.left = new BinaryTree(tree.right.value);
            invertedTree.right = new BinaryTree(tree.left.value);
        } else if (tree.left != null) {
            invertedTree.right = new BinaryTree(tree.left.value);
        } else if (tree.right != null) {
            invertedTree.left = new BinaryTree(tree.right.value);
        }
        solveItInvertBT(tree.left, invertedTree.right);
        solveItInvertBT(tree.right, invertedTree.left);
    }

    private static void solveItInvertBTCopy(BinaryTree tree) {
        if (tree == null)
            return;

        BinaryTree temp = tree.left;
        tree.left = tree.right;
        tree.right = temp;

        solveItInvertBTCopy(tree.left);
        solveItInvertBTCopy(tree.right);
    }

    static class BinaryTree {
        public int value;
        public BinaryTree left;
        public BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        TestCase1();
    }

    public static void TestCase1() {
        TestBinaryTree tree = new TestBinaryTree(1);
        tree.insert(new int[]{2, 3, 4, 5, 6, 7, 8, 9}, 0);
        InvertBTree.invertBinaryTree(tree);
        InvertedBinaryTree invertedTree = new InvertedBinaryTree(1);
        invertedTree.insert(new int[]{2, 3, 4, 5, 6, 7, 8, 9}, 0);
        System.out.println(compareBT(tree, invertedTree));
    }

    private static boolean compareBT(InvertBTree.BinaryTree tree1, InvertedBinaryTree tree2) {
        if (tree1 == null && tree2 == null) {
            return true;
        }
        if (tree1 != null && tree2 != null) {
            return tree1.value == tree2.value
                    && compareBT(tree1.left, tree2.left)
                    && compareBT(tree1.right, tree2.right);
        }
        return false;
    }

    static class InvertedBinaryTree {
        public int value;
        public InvertedBinaryTree left;
        public InvertedBinaryTree right;

        public InvertedBinaryTree(int value) {
            this.value = value;
        }

        public void insert(int[] values, int i) {
            if (i >= values.length) {
                return;
            }
            ArrayDeque<InvertedBinaryTree> queue = new ArrayDeque<InvertedBinaryTree>();
            queue.addLast(this);
            while (queue.size() > 0) {
                InvertedBinaryTree current = queue.pollFirst();
                if (current.right == null) {
                    current.right = new InvertedBinaryTree(values[i]);
                    break;
                }
                queue.addLast(current.right);
                if (current.left == null) {
                    current.left = new InvertedBinaryTree(values[i]);
                    break;
                }
                queue.addLast(current.left);
            }
            insert(values, i + 1);
        }
    }

    static class TestBinaryTree extends InvertBTree.BinaryTree {
        public TestBinaryTree(int value) {
            super(value);
        }

        public void insert(int[] values, int i) {
            if (i >= values.length) {
                return;
            }
            ArrayDeque<BinaryTree> queue = new ArrayDeque<InvertBTree.BinaryTree>();
            queue.addLast(this);
            while (queue.size() > 0) {
                InvertBTree.BinaryTree current = queue.pollFirst();
                if (current.left == null) {
                    current.left = new InvertBTree.BinaryTree(values[i]);
                    break;
                }
                queue.addLast(current.left);
                if (current.right == null) {
                    current.right = new InvertBTree.BinaryTree(values[i]);
                    break;
                }
                queue.addLast(current.right);
            }
            insert(values, i + 1);
        }
    }
}
