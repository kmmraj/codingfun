package com.test.tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SeralizeDeseralizeBT {

    TreeNode treeNode;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null){
            return "null,";
        }

        return  root.val + "," + serialize(root.left) + serialize(root.right);

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        Queue<String> queue = new LinkedList<String>();
        queue.addAll(Arrays.asList(data.split(",")));

        return deserializeNode(queue);
    }

    private TreeNode deserializeNode(Queue<String> queue) {
        if(queue.isEmpty()){
            return this.treeNode;
        }

        String val  = queue.poll();
        if(val.equals("null"))
            return null;

        TreeNode treeNode = new TreeNode(Integer.valueOf(val));
        treeNode.left = deserializeNode(queue);
        treeNode.right = deserializeNode(queue);
        return treeNode;
    }

    public static void main(String[] args) {
        TreeNode ch8 = new TreeNode(8);

        TreeNode ch7 = new TreeNode(7);
        TreeNode ch6 = new TreeNode(6);
        TreeNode ch5 = new TreeNode(5);
        TreeNode ch4 = new TreeNode(4,ch8,null);
        TreeNode ch3 = new TreeNode(3,ch6,ch7);
        TreeNode ch2 = new TreeNode(2,ch4,ch5);
        TreeNode ch1 = new TreeNode(1,ch2,ch3);

        SeralizeDeseralizeBT bt = new SeralizeDeseralizeBT();
        String seralizedCh1 = bt.serialize(ch1);
        System.out.println(seralizedCh1);
        TreeNode treeNode = bt.deserialize(seralizedCh1);
        System.out.println(treeNode);
    }
}
