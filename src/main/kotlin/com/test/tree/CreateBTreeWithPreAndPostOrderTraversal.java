package com.test.tree;

import java.util.HashMap;
import java.util.Map;

public class CreateBTreeWithPreAndPostOrderTraversal {
    int[] preorder;
    int[] postorder;
    int index = 0;
    Map<Integer, Integer> val2IdxPostOrderMap;
    TreeNode node;

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        this.preorder = preorder;
        this.postorder = postorder;
        val2IdxPostOrderMap = new HashMap<>();

        for (int idx = 0; idx < postorder.length; idx++) {
            val2IdxPostOrderMap.put(postorder[idx], idx);
        }

        return constructFromPrePostHelper(0, preorder.length - 1);
    }

    private TreeNode constructFromPrePostHelper(int start, int end) {

        // BC
        // System.out.println("start is "+start+ " end is "+end);
        if (start > end) {
            return null;
        }

        // H & I

        TreeNode node = new TreeNode(this.preorder[index++]);
        if (start == end) {
            return node;
        }

        int leftIdx = val2IdxPostOrderMap.get(this.preorder[index]);
        node.left = constructFromPrePostHelper(start, leftIdx);
        node.right = constructFromPrePostHelper(leftIdx+1, end-1);

        return node;
    }

    public static void main(String[] args) {
        CreateBTreeWithPreAndPostOrderTraversal createBTreeWithPreAndPostOrderTraversal =
                new CreateBTreeWithPreAndPostOrderTraversal();
        int[] preOrder = {1,2,4,5,3,6,7};
        int[] postOrder = {4,5,2,6,7,3,1};
        TreeNode root = createBTreeWithPreAndPostOrderTraversal.constructFromPrePost(preOrder, postOrder);

        System.out.println("root should be 1 and the result is  " + root.val);
        System.out.println("root.left should be 2 and the result is  " + root.left.val);
        System.out.println("root.right should be 3 and the result is  " + root.right.val);
    }
}
