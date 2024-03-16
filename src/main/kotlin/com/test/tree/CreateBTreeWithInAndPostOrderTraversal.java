package com.test.tree;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CreateBTreeWithInAndPostOrderTraversal {

    Map<Integer, Integer> inOrderVal2IdxMap;
    int[] postorder;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // Create the in order value to index Map
        System.out.println("inorder is " + Arrays.toString(inorder));
        System.out.println("postorder is " + Arrays.toString(postorder));
        this.inOrderVal2IdxMap = new HashMap<>();
        this.postorder = postorder;
        for (int idx = 0; idx < inorder.length; idx++) {
            inOrderVal2IdxMap.put(inorder[idx], idx);
        }
        return buildTreeHelper(0, postorder.length - 1, 0, inorder.length-1);
    }

    private TreeNode buildTreeHelper(int postOrderStart, int postOrderEnd,
                                     int inOrderStart, int inOrderEnd) {

        System.out.println("postOrderStart is " + postOrderStart + " postOrderEnd is " + postOrderEnd
                + " inOrderStart is " + inOrderStart + " inOrderEnd is " + inOrderEnd);
        // BC
        if ((postOrderStart > postOrderEnd)
                || (inOrderStart > inOrderEnd)) {
            return null;
        }

        // H & I
        System.out.println("root element is " + this.postorder[postOrderEnd]);
        int rootIdx = this.inOrderVal2IdxMap.get(this.postorder[postOrderEnd]);
        int rightTreeSize = inOrderEnd - rootIdx;
        int leftTreeSize = rootIdx - inOrderStart;

        System.out.println("rootIdx is " + rootIdx + " rightTreeSize is "
                + rightTreeSize + " leftTreeSize is " + leftTreeSize);

        return new TreeNode(this.postorder[postOrderEnd],
                buildTreeHelper(postOrderStart, postOrderStart + leftTreeSize - 1, inOrderStart, rootIdx - 1),
                buildTreeHelper(postOrderStart + leftTreeSize, postOrderEnd - 1, rootIdx + 1, inOrderEnd)
                );

    }


    public static void main(String[] args) {
        CreateBTreeWithInAndPostOrderTraversal createBTreeWithInAndPostOrderTraversal = new CreateBTreeWithInAndPostOrderTraversal();
        int[] inOrder = {9,3,15,20,7};
        int[] postOrder = {9,15,7,20,3};
        TreeNode root = createBTreeWithInAndPostOrderTraversal.buildTree(inOrder, postOrder);

        System.out.println("root should be 3 and the result is  " + root.val);
        System.out.println("root.left should be 9 and the result is  " + root.left.val);
        System.out.println("root.right should be 20 and the result is  " + root.right.val);
        System.out.println("root.right.left should be 15 and the result is  " + root.right.left.val);
        System.out.println("root.right.right should be 7 and the result is  " + root.right.right.val);
        System.out.println("------------------------  ");
    }
}
