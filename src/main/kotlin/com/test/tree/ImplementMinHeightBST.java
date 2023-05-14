package com.test.tree;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class ImplementMinHeightBST {

    static class TreeNode {
        public int data;
        public TreeNode left;
        public TreeNode right;
        public TreeNode parent;
        public int size = 0;

        public TreeNode(int d) {
            data = d;
            size = 1;
        }

        public int height(){
            int leftHeight = left == null ? 0: left.height();
            int rightHeight = left == null ? 0: right.height();
            return 1+ Integer.max(leftHeight,rightHeight);
        }

    }

    public static TreeNode createMinimalBST(int[] array) {
        int middle = array.length / 2;
        TreeNode root = new TreeNode(array[middle]);
        int start = 0;
        int end = array.length - 1;
        return createMinBST(array, root, start, end);
    }

    private static TreeNode createMinBST(int[] array, TreeNode root, int start, int end) {
        // BC
        int middle = start + (end - start) / 2;
        if (start > middle || end < middle){
            return root;
        }

        // I
        root = new TreeNode(array[middle]);

        // Hy
        root.left = createMinBST(array,root.left,start,middle-1);
        root.right = createMinBST(array,root.right,middle+1,end);
        return root;
    }



    public static void main(String[] args) {
        int[] array = {1,3, 5,7, 9, 11,13, 15,17, 18, 21};
        TreeNode root = ImplementMinHeightBST.createMinimalBST(array);
        levelOrderTraversal(root);

    }

    private static void levelOrderTraversal(TreeNode rootNode) {
        if(rootNode==null){
            return;
        }

      //  System.out.println(currentNode.data);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(rootNode);
        int count =0;
        while (!queue.isEmpty()){
            TreeNode currentNode = queue.poll();


            System.out.print(currentNode.data + " ");
            if(count == (1<<(count-1)) -1){
                System.out.println();
            }
            count++;
            if(currentNode.left!=null){
                queue.offer(currentNode.left);
            }
            if(currentNode.right!=null){
                queue.offer(currentNode.right);
            }
        }

//        levelOrderTraversal(currentNode.left);
//        levelOrderTraversal(currentNode.right);
    }

}
