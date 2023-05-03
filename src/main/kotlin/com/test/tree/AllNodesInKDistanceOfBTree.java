package com.test.tree;

import java.util.*;

public class AllNodesInKDistanceOfBTree {

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        HashMap<TreeNode,TreeNode> parentMappingMap = new HashMap<TreeNode, TreeNode>();
        
        getParentMapping(root,null,parentMappingMap);

        Queue<TreeNode> queue =  new LinkedList<TreeNode>();
        HashSet<TreeNode> seenTreeNodes = new HashSet<TreeNode>();
        queue.add(target);
        seenTreeNodes.add(target);
        int level  = 0;
        List<Integer> nodesFromKDistance = new ArrayList<Integer>();
        solveIt(queue,seenTreeNodes,parentMappingMap,K,level,nodesFromKDistance);

        return nodesFromKDistance;
    }

    private void solveIt(Queue<TreeNode> queue,
                         HashSet<TreeNode> seenTreeNodes,
                         HashMap<TreeNode,TreeNode> parentMappingMap,
                         int K,
                         int level,
                         List<Integer> nodesFromKDistance ) {
       // BC
        if(level == K){
            for (TreeNode item: queue) {
                nodesFromKDistance.add(item.val);
            }
            return;
        }
        if(queue.isEmpty())
            return;

        // Induction
        List<TreeNode> currentLevelNodes = new ArrayList<TreeNode>(queue);
        for (TreeNode currentNode: currentLevelNodes) {
            queue.poll();
            if(currentNode.left!=null && !seenTreeNodes.contains(currentNode.left)){
                queue.add(currentNode.left);
                seenTreeNodes.add(currentNode.left);
            }
            if(currentNode.right!= null && !seenTreeNodes.contains(currentNode.right)) {
                queue.add(currentNode.right);
                seenTreeNodes.add(currentNode.right);
            }
            TreeNode parentNode = parentMappingMap.get(currentNode);
            if(parentNode !=null && !seenTreeNodes.contains(parentNode)){
                queue.add(parentNode);
                seenTreeNodes.add(parentNode);
            }
        }

       level++;
       solveIt(queue,seenTreeNodes,parentMappingMap,K,level,nodesFromKDistance);
    }

    private void getParentMapping(TreeNode root, TreeNode parent, HashMap<TreeNode, TreeNode> parentMappingMap) {
        //BC
        if(root==null){
            return;
        }
        // Induction
        parentMappingMap.put(root,parent);
        getParentMapping(root.left,root,parentMappingMap);
        getParentMapping(root.right,root,parentMappingMap);
    }

    public static void main(String[] args) {
        TreeNode ch9 = new TreeNode(9);
        TreeNode ch8 = new TreeNode(8);
        TreeNode ch7 = new TreeNode(7);
        TreeNode ch6 = new TreeNode(6);
        TreeNode ch5 = new TreeNode(5,null,ch9);
        TreeNode ch4 = new TreeNode(4,ch8,null);
        TreeNode ch3 = new TreeNode(3,ch6,ch7);
        TreeNode ch2 = new TreeNode(2,ch4,ch5);
        TreeNode ch1 = new TreeNode(1,ch2,ch3);

        AllNodesInKDistanceOfBTree kDistanceOfBTree =  new AllNodesInKDistanceOfBTree();
        List<Integer> resultList= kDistanceOfBTree.distanceK(ch1,ch4,3);

        for (Integer item: resultList) {
            System.out.println(item);
        }
    }
}
