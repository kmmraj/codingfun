package com.test.tree;

import java.util.ArrayList;
import java.util.List;

public class FindSuccessor {
    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;
        public BinaryTree parent = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    public BinaryTree findSuccessor(BinaryTree tree, BinaryTree node) {
        // Write your code here.
        List<BinaryTree> array = new ArrayList<>();
        solveItRecursively(tree, node, array);
        BinaryTree answer = null;
        for (int idx = 0; idx < array.size(); idx++) {
            if (array.get(idx).value == node.value) {
                if (idx + 1 < array.size())
                    answer = array.get(idx + 1);
                else
                    answer = null;
            }
        }
        return answer;
    }

    public List<BinaryTree> solveItRecursively(BinaryTree tree, BinaryTree node, List<BinaryTree> array) {
        if (tree == null)
            return array;

        solveItRecursively(tree.left, node, array);
        array.add(tree);
        solveItRecursively(tree.right, node, array);
        return array;
    }



    public static void main(String[] args) {
        TestCase1();
    }

    public static void TestCase1() {
        FindSuccessor.BinaryTree root = new FindSuccessor.BinaryTree(1);
        root.left = new FindSuccessor.BinaryTree(2);
        root.left.parent = root;
        root.right = new FindSuccessor.BinaryTree(3);
        root.right.parent = root;
        root.left.left = new FindSuccessor.BinaryTree(4);
        root.left.left.parent = root.left;
        root.left.right = new FindSuccessor.BinaryTree(5);
        root.left.right.parent = root.left;
        root.left.left.left = new FindSuccessor.BinaryTree(6);
        root.left.left.left.parent = root.left.left;
        FindSuccessor.BinaryTree node = root.left.right;
        FindSuccessor.BinaryTree expected = root;
        FindSuccessor.BinaryTree output = new FindSuccessor().findSuccessor(root, node);
        System.out.println(expected == output);
    }
}
