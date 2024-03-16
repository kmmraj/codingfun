package com.test.tree;

import java.util.*;

public class LCA1 {


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //BC
        if (root == null) {
            return null;
        }

        if (root == p) {
            return root;
        }
        if (root == q) {
            return root;
        }

        /**
         if leftTreeNode is null.
         leftTreeNode is the result of the recursive call to lowestCommonAncestor for the left child of the root node.
         If leftTreeNode is null, it means that neither of the nodes p or q are found in the left subtree
         of the root node.
         Therefore, the method returns rightTreeNode,
         which is the result of the recursive call to lowestCommonAncestor for the right child of the root node.
         This implies that both nodes p and q are in the right subtree.
         */
        TreeNode leftTreeNode = lowestCommonAncestor(root.left, p, q);
        TreeNode rightTreeNode = lowestCommonAncestor(root.right, p, q);
        if (leftTreeNode == null)
            return rightTreeNode;
        if (rightTreeNode == null)
            return leftTreeNode;
        /**
         * If neither leftTreeNode nor rightTreeNode are null,
         * it means that one node is in the left subtree and the other is in the right subtree.
         * In this case, the current root node is the LCA of p and q, so the method returns root.
         *
         */
        return root;

    }

    private TreeNode YetAnotherIterativeLCAHelper(TreeNode node, TreeNode p, TreeNode q) {

        // Create the childParentMap that contains key as child and value as parent
        Map<TreeNode, TreeNode> childParentMap = new HashMap<>();
        childParentMap.put(node, null);

        // Do BFS based approach to fill the childParentMap
        Deque<TreeNode> deq = new LinkedList<>();
        deq.addFirst(node);

        // Fill the map until you hit the match
        while ((!childParentMap.containsKey(p) || !childParentMap.containsKey(q)) /**&& !deq.isEmpty()**/) {
            TreeNode treeNode = deq.removeFirst();
            if (treeNode != null) {
                deq.addFirst(treeNode.left);
                childParentMap.put(treeNode.left, treeNode);

                deq.addFirst(treeNode.right);
                childParentMap.put(treeNode.right, treeNode);
            }
        }

        // Match the ancestors by iterating the parent
        Set<TreeNode> set = new HashSet<>();
        while (p != null) {
            set.add(p);
            p = childParentMap.get(p);
        }

        while (!set.contains(q)) {
            q = childParentMap.get(q);
        }
        return q;
    }


    class LCAStatus {
        int numOfMatches;
        TreeNode ancestor;

        LCAStatus(int numOfMatches, TreeNode ancestor) {
            this.numOfMatches = numOfMatches;
            this.ancestor = ancestor;
        }
    }

    private LCAStatus LCAHelper(TreeNode node, TreeNode p, TreeNode q) {
        // BC
        if (node == null) {
            return new LCAStatus(0, null);
        }

        // H & I
        LCAStatus leftStatus = LCAHelper(node.left, p, q);
        if (leftStatus.numOfMatches == 2) {
            return leftStatus;
        }

        LCAStatus rightStatus = LCAHelper(node.right, p, q);
        if (rightStatus.numOfMatches == 2) {
            return rightStatus;
        }

        int numOfMatches = leftStatus.numOfMatches
                + rightStatus.numOfMatches
                + (node.val == p.val ? 1 : 0)
                + (node.val == q.val ? 1 : 0);

        return new LCAStatus(numOfMatches, numOfMatches == 2 ? node : null);
    }

    public static void main(String[] args) {
        TreeNode ch8 = new TreeNode(8);

        TreeNode ch7 = new TreeNode(7);
        TreeNode ch6 = new TreeNode(6);
        TreeNode ch5 = new TreeNode(5);
        TreeNode ch4 = new TreeNode(4, ch8, null);
        TreeNode ch3 = new TreeNode(3, ch6, ch7);
        TreeNode ch2 = new TreeNode(2, ch4, ch5);
        TreeNode ch1 = new TreeNode(1, ch2, ch3);

        LCA1 lca1 = new LCA1();
        TreeNode treeNode = lca1.lowestCommonAncestor(ch1, ch4, ch7);
        System.out.println("Val is: " + treeNode.val);

        // New test case
        LCA1 lca2 = new LCA1();

        System.out.println("lca2.LCAHelper(new TreeNode(3,\n" +
                "                new TreeNode(5,\n" +
                "                        new TreeNode(6),\n" +
                "                        new TreeNode(2,\n" +
                "                                new TreeNode(7),\n" +
                "                                new TreeNode(4))),\n" +
                "                new TreeNode(1,\n" +
                "                        new TreeNode(0),\n" +
                "                        new TreeNode(8))),\n" +
                "                new TreeNode(5),\n" +
                "                new TreeNode(1)) should be 3 and the result is  " +
                lca2.LCAHelper(new TreeNode(3,
                                new TreeNode(5,
                                        new TreeNode(6),
                                        new TreeNode(2,
                                                new TreeNode(7),
                                                new TreeNode(4))),
                                new TreeNode(1,
                                        new TreeNode(0),
                                        new TreeNode(8))),
                        new TreeNode(5),
                        new TreeNode(1)).ancestor.val);

        System.out.println("lca2.YetAnotherIterativeLCAHelper(new TreeNode(3,\n" +
                "                new TreeNode(5,\n" +
                "                        new TreeNode(6),\n" +
                "                        new TreeNode(2,\n" +
                "                                new TreeNode(7),\n" +
                "                                new TreeNode(4))),\n" +
                "                new TreeNode(1,\n" +
                "                        new TreeNode(0),\n" +
                "                        new TreeNode(8))),\n" +
                "                new TreeNode(5),\n" +
                "                new TreeNode(1)) should be 3 and the result is  " +
                lca2.YetAnotherIterativeLCAHelper(new TreeNode(3,
                                new TreeNode(5,
                                        new TreeNode(6),
                                        new TreeNode(2,
                                                new TreeNode(7),
                                                new TreeNode(4))),
                                new TreeNode(1,
                                        new TreeNode(0),
                                        new TreeNode(8))),
                        new TreeNode(5),
                        new TreeNode(1)).val);
    }
}
