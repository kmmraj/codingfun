package com.test.tree;
//https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree-iii/description/
// src/main/docs/LCA-with-Parent-2024-01-29-1707.png
/**
 * 1650. Lowest Common Ancestor of a Binary Tree III
 * Medium
 * <p>
 * Given two nodes of a binary tree p and q, return their lowest common ancestor (LCA).
 * <p>
 * Each node will have a reference to its parent node. The definition for Node is below:
 * <p>
 * class Node {
 * public int val;
 * Node left;
 * Node right;
 * Node parent;
 * }
 * According to the definition of LCA on Wikipedia: "The lowest common ancestor of two nodes p and q in a tree T
 * is the lowest node that has both p and q as descendants (where we allow a node to be a descendant of itself)."
 * <p>
 * Example 1:
 * <p>
 * // Tree structure is as follows:
 * //             1
 * //           /   \
 * //          2     3
 * //         / \   / \
 * //        4   5 6   7
 */
public class LCA3 {

    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node parent;

        public Node() {
        }

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node left, Node right, Node parent) {
            this.val = val;
            this.left = left;
            this.right = right;
            this.parent = parent;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val + ","+
                    "parent=" + parent.val +
                    '}';
        }
    }


    public Node lowestCommonAncestor(Node p, Node q) {

        if (p == null || q == null) {
            return null;
        }

        // Tree structure is as follows:
        //             1
        //           /   \
        //          2     3
        //         / \   / \
        //        4   5 6   7
        //                   \
        //                    8

        Node p1 = p;
        Node q1 = q;
        while (p1 != q1) {
            p1 = (p1 == null) ? q : p1.parent; // 8 -> 7 -> 3 -> 1 -> 3
            q1 = (q1 == null) ? p : q1.parent; // 3 -> 1 -> 8 -> 7 -> 3
        }
        return p1;
    }

    public Node lowestCommonAncestorUsingHeight(Node p, Node q) {
        if (p == null || q == null) {
            return null;
        }

        // Get the height of each node
        int pHeight = getHeight(p);
        int qHeight = getHeight(q);

        // Compare and if qHeight is greater than pHeight swap
        if (qHeight > pHeight) {
            Node tempNode = p;
            p = q;
            q = tempNode;
        }

        int diff = Math.abs(pHeight - qHeight);
        while (diff > 0) {
            p = p.parent;
            diff--;
        }
        while (p != q) {
            p = p.parent;
            q = q.parent;
        }

        return p;

    }

    private int getHeight(Node node) {
        int height = 0;
        while (node != null) {
            height++;
            node = node.parent;
        }
        return height;
    }

    public static void main(String[] args) {
        LCA3 lca3 = new LCA3();
        //Example 1:
        //Input: root = [1,2,3,4,5,6,7]

        // Use Node and its parent to solve this problem
        Node ch8 = new Node(8);
        Node ch7 = new Node(7,ch8,null,null);
        Node ch6 = new Node(6);
        Node ch5 = new Node(5);
        Node ch4 = new Node(4);
        Node ch3 = new Node(3, ch6, ch7, null);
        Node ch2 = new Node(2, ch4, ch5, null);
        Node root = new Node(1, ch2, ch3, null);
        ch2.parent = root;
        ch3.parent = root;
        ch4.parent = ch2;
        ch5.parent = ch2;
        ch6.parent = ch3;
        ch7.parent = ch3;
        ch8.parent = ch7;

        // Tree structure is as follows:
        //             1
        //           /   \
        //          2     3
        //         / \   / \
        //        4   5 6   7
        //                   \
        //                    8


//        System.out.println("lca3.lowestCommonAncestor(ch4, ch7) should be 1 and the result is  " +
//                lca3.lowestCommonAncestor(ch4, ch7).val);
//
//        System.out.println("lca3.lowestCommonAncestorUsingHeight(ch4, ch7) should be 1 and the result is  " +
//                lca3.lowestCommonAncestorUsingHeight(ch4, ch7).val);
//
//        System.out.println("lca3.lowestCommonAncestor(ch4, ch5) should be 2 and the result is  " +
//                lca3.lowestCommonAncestor(ch4, ch5).val);
//
//        System.out.println("lca3.lowestCommonAncestorUsingHeight(ch4, ch5) should be 2 and the result is  " +
//                lca3.lowestCommonAncestorUsingHeight(ch4, ch5).val);
//
//        System.out.println("lca3.lowestCommonAncestor(ch6, ch7) should be 3 and the result is  " +
//                lca3.lowestCommonAncestor(ch6, ch7).val);
//
//        System.out.println("lca3.lowestCommonAncestorUsingHeight(ch6, ch7) should be 3 and the result is  " +
//                lca3.lowestCommonAncestorUsingHeight(ch6, ch7).val);
//
//        System.out.println("lca3.lowestCommonAncestor(ch6, ch3) should be 3 and the result is  " +
//                lca3.lowestCommonAncestor(ch6, ch3).val);
//
//        System.out.println("lca3.lowestCommonAncestorUsingHeight(ch6, ch3) should be 3 and the result is  " +
//                lca3.lowestCommonAncestorUsingHeight(ch6, ch3).val);

        System.out.println("lca3.lowestCommonAncestor(ch8, ch3) should be 3 and the result is  " +
                lca3.lowestCommonAncestor(ch8, ch3).val);


    }

}
