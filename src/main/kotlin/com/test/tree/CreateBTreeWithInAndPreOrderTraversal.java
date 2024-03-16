package com.test.tree;
//https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/

import java.util.HashMap;
import java.util.Map;

/**
 * 105. Construct Binary Tree from Preorder and Inorder Traversal
 * Medium
 * Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree
 * and inorder is the inorder traversal of the same tree, construct and return the binary tree.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * Output: [3,9,20,null,null,15,7]
 * <p>
 * Example 2:
 * Input: preorder = [-1], inorder = [-1]
 * Output: [-1]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= preorder.length <= 3000
 * inorder.length == preorder.length
 * -3000 <= preorder[i], inorder[i] <= 3000
 * preorder and inorder consist of unique values.
 * Each value of inorder also appears in preorder.
 * preorder is guaranteed to be the preorder traversal of the tree.
 * inorder is guaranteed to be the inorder traversal of the tree.
 */
public class CreateBTreeWithInAndPreOrderTraversal {

    Map<Integer, Integer> inOrderVal2IdxMap;
    int[] preorder;

    private int i = 0;
    private int p = 0;

    public TreeNode buildTree1(int[] preorder, int[] inorder) {
        return build1(preorder, inorder, Integer.MIN_VALUE);
    }

    private TreeNode build1(int[] preorder, int[] inorder, int stop) {
        if (p >= preorder.length) {
            return null;
        }
        if (inorder[i] == stop) {
            ++i;
            return null;
        }

        TreeNode node = new TreeNode(preorder[p++]);
        node.left = build1(preorder, inorder, node.val);
        node.right = build1(preorder, inorder, stop);
        return node;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        // Create the inOrder Map that has the values and the index
        this.inOrderVal2IdxMap = new HashMap<>();
        for (int idx = 0; idx < inorder.length; idx++) {
            inOrderVal2IdxMap.put(inorder[idx], idx);
        }
        this.preorder = preorder;

        return buildTreeHelper(0, preorder.length, 0, inorder.length);

    }

    private TreeNode buildTreeHelper(
            int preOrderStart, int preOrderEnd,
            int inOrderStart, int inOrderEnd) {
        // BC
        if ((preOrderStart >= preOrderEnd) || (inOrderStart >=inOrderEnd )) {
            return null;
        }

        // H&I
        // Get the root index to split the left and right sub-trees
        int rootIdx = inOrderVal2IdxMap.get(preorder[preOrderStart]);
        int leftSubTreeSize = rootIdx - inOrderStart;
        int rightSubTreeSize = inOrderEnd - rootIdx;

        return new TreeNode(preorder[preOrderStart],
                // Left Sub Tree
                buildTreeHelper(preOrderStart + 1, preOrderStart + 1 + leftSubTreeSize,
                        inOrderStart, rootIdx),
                // Right Sub Tree
                buildTreeHelper(preOrderEnd-rightSubTreeSize+1, preOrderEnd,
                        rootIdx + 1, inOrderEnd));
    }

    public static void main(String[] args) {
        CreateBTreeWithInAndPreOrderTraversal createBTreeWithInAndPreOrderTraversal =
                new CreateBTreeWithInAndPreOrderTraversal();
        //Example 1:
        //Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
        //Output: [3,9,20,null,null,15,7]
        int[] preorder = new int[]{3, 9, 20, 15, 7};
        int[] inorder = new int[]{9, 3, 15, 20, 7};
        TreeNode root = createBTreeWithInAndPreOrderTraversal.buildTree(preorder, inorder);
        System.out.println("root should be 3 and the result is  " + root.val);
        System.out.println("root.left should be 9 and the result is  " + root.left.val);
        System.out.println("root.right should be 20 and the result is  " + root.right.val);
        System.out.println("root.right.left should be 15 and the result is  " + root.right.left.val);
        System.out.println("root.right.right should be 7 and the result is  " + root.right.right.val);
        System.out.println("------------------------  ");

        //Example 2:
        //Input: preorder = [-1], inorder = [-1]
        //Output: [-1]
        preorder = new int[]{-1};
        inorder = new int[]{-1};
        root = createBTreeWithInAndPreOrderTraversal.buildTree(preorder, inorder);
        System.out.println("root should be -1 and the result is  " + root.val);
        System.out.println("------------------------  ");

        //Example 3:
        //Input: preorder = [1,2,3], inorder = [3,2,1]
        //Output: [1,2,null,3]
        preorder = new int[]{1,2,3};
        inorder = new int[]{3,2,1};
        root = createBTreeWithInAndPreOrderTraversal.buildTree(preorder, inorder);
        System.out.println("root should be 1 and the result is  " + root.val);
        System.out.println("root.left should be 2 and the result is  " + root.left.val);
        System.out.println("root.left.left should be 3 and the result is  " + root.left.left.val);
        System.out.println("------------------------  ");


        //Example 4:
        //Input: preorder = [1,2,3], inorder = [1,2,3]
        //Output: [1,null,2,null,3]
        preorder = new int[]{1,2,3};
        inorder = new int[]{1,2,3};
        root = createBTreeWithInAndPreOrderTraversal.buildTree(preorder, inorder);
        System.out.println("root should be 1 and the result is  " + root.val);
        System.out.println("root.right should be 2 and the result is  " + root.right.val);
        System.out.println("root.right.right should be 3 and the result is  " + root.right.right.val);
        System.out.println("------------------------  ");

        //Example 5:


    }
}
