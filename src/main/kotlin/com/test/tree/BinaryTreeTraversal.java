package com.test.tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeTraversal {

    static class BNode<T> {
        T data;
        BNode<T> left;
        BNode<T> right;

        public BNode(T data) {
            this.data = data;
        }

        public BNode(T data, BNode<T> left, BNode<T> right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }

    BNode<Integer> root;

    public BinaryTreeTraversal() {
        this.root = null;
    }

    public void addNode(int data) {
        BNode<Integer> newNode = new BNode(data);
        if (root == null) {
            root = newNode;
            return;
        }
        // Level Order Traversal and Insert
        BNode<Integer> currentNode = root;
        Queue<BNode<Integer>> levelQueue = new java.util.LinkedList<>();
        levelQueue.add(currentNode);
        while (!levelQueue.isEmpty()) {
            BNode<Integer> tempNode = levelQueue.remove();
            System.out.println(tempNode.data + " ");
            if (tempNode.left != null) {
                levelQueue.add(tempNode.left);
            } else {
                tempNode.left = newNode;
                return;
            }

            if (tempNode.right != null) {
                levelQueue.add(tempNode.right);
            } else {
                tempNode.right = newNode;
                return;
            }
        }
    }


    public static void main(String[] args) {
        BinaryTreeTraversal binaryTreeTraversal = new BinaryTreeTraversal();
        System.out.println("binaryTreeTraversal.addNode(1);");
        binaryTreeTraversal.addNode(1);
        System.out.println("binaryTreeTraversal.addNode(2);");
        binaryTreeTraversal.addNode(2);
        System.out.println("binaryTreeTraversal.addNode(3);");
        binaryTreeTraversal.addNode(3);
        System.out.println("binaryTreeTraversal.addNode(4);");
        binaryTreeTraversal.addNode(4);
        System.out.println("binaryTreeTraversal.addNode(5);");
        binaryTreeTraversal.addNode(5);
        System.out.println("binaryTreeTraversal.addNode(6);");
        binaryTreeTraversal.addNode(6);
        binaryTreeTraversal.addNode(7);
        binaryTreeTraversal.addNode(8);
        binaryTreeTraversal.addNode(9);

        binaryTreeTraversal.levelOrderTraversal();
        binaryTreeTraversal.preOrderTraversal();
        binaryTreeTraversal.inOrderTraversal();

        System.out.println("Is the value found for 6 " + binaryTreeTraversal.search(9));
        System.out.println("Is the value found for 7 " + binaryTreeTraversal.search(7));
        System.out.println("Is the value found for 1 " + binaryTreeTraversal.search(1));
        System.out.println("Is the value found for 11 " + binaryTreeTraversal.search(11));
        System.out.println("Is the value found for 7 " + binaryTreeTraversal.deleteNodeWithValue(7));
        binaryTreeTraversal.levelOrderTraversal();
        System.out.println("Is the value found for 8 " + binaryTreeTraversal.deleteNodeWithValue(8));
        binaryTreeTraversal.levelOrderTraversal();
    }

    private boolean deleteNodeWithValue(final int value) {
        if (root == null) {
            return false;
        }

        Queue<BNode<Integer>> levelOrderQueue = new LinkedList<>();
        levelOrderQueue.add(root);
        while (!levelOrderQueue.isEmpty()) {
            BNode<Integer> tempNode = levelOrderQueue.remove();
            if (tempNode.data == value) {
                BNode<Integer> deepestNode = getDeepestNode();
                if(deepestNode != null && deepestNode.data == value){
                    deleteDeepestNode();
                    return true;
                }
                if(deepestNode != null){
                    tempNode.data = deepestNode.data;
                    deleteDeepestNode();
                    return true;
                }

            }
            if (tempNode.left != null) {
                levelOrderQueue.add(tempNode.left);
            }

            if (tempNode.right != null) {
                levelOrderQueue.add(tempNode.right);
            }
        }

        return false;
    }

    private void deleteDeepestNode() {
        if (root == null) {
            return;
        }

        Queue<BNode<Integer>> levelOrderQueue = new LinkedList<>();
        levelOrderQueue.add(root);
        BNode<Integer> tempNode = null;
        BNode<Integer> prevNode;
        while (!levelOrderQueue.isEmpty()) {
            prevNode = tempNode;
            tempNode = levelOrderQueue.remove();

            if (tempNode.left == null) { // Since left was null -- > we need previous node to delete the right sibling
                assert prevNode != null;
                prevNode.right = null;
                return;
            }
            levelOrderQueue.add(tempNode.left);

            if (tempNode.right == null) { // Since right was null -- > we need current node to delete the left sibling
                assert prevNode != null;
                tempNode.left = null;
                return;
            }
            levelOrderQueue.add(tempNode.right);
        }
    }

    private BNode<Integer> getDeepestNode() {
        if (root == null) {
            return null;
        }

        Queue<BNode<Integer>> levelOrderQueue = new LinkedList<>();
        levelOrderQueue.add(root);
        BNode<Integer> tempNode = null;
        while (!levelOrderQueue.isEmpty()) {
            tempNode = levelOrderQueue.remove();

            if (tempNode.left != null) {
                levelOrderQueue.add(tempNode.left);
            }

            if (tempNode.right != null) {
                levelOrderQueue.add(tempNode.right);
            }
        }
        return tempNode;
    }

    private boolean search(final int value) {
        if (root == null) {
            return false;
        }

        Queue<BNode<Integer>> levelOrderQueue = new LinkedList<>();
        levelOrderQueue.add(root);
        while (!levelOrderQueue.isEmpty()) {
            BNode<Integer> tempNode = levelOrderQueue.remove();
            if (tempNode.data == value) {
                return true;
            }
            if (tempNode.left != null) {
                levelOrderQueue.add(tempNode.left);
            }

            if (tempNode.right != null) {
                levelOrderQueue.add(tempNode.right);
            }
        }

        return false;
    }

    private void inOrderTraversal() {
        if (root == null) {
            return;
        }
        System.out.println("\n-----------In Order Traversal ----- Start----------");
        BNode<Integer> currentNode = root;
        inOrder(currentNode);
        System.out.println("\n-----------In Order Traversal ----- End----------");
    }

    private void inOrder(BNode<Integer> currentNode) {
        if (currentNode == null) {
            return;
        }
        inOrder(currentNode.left);
        System.out.print(currentNode.data + " ");
        inOrder(currentNode.right);
    }

    private void preOrderTraversal() {
        if (root == null) {
            return;
        }
        System.out.println("\n-----------Pre Order Traversal ----- Start----------");
        BNode<Integer> currentNode = root;
        preOrder(currentNode);
        System.out.println("\n-----------Pre Order Traversal ----- End----------");
    }

    private boolean preOrder(BNode<Integer> currentNode) {
        if (currentNode == null) {
            return true;
        }
        System.out.print(currentNode.data + " ");
        preOrder(currentNode.left);
        preOrder(currentNode.right);
        return false;
    }

    private void levelOrderTraversal() {
        Queue<BNode<Integer>> levelQueue = new java.util.LinkedList<>();
        levelQueue.add(root);
        System.out.println("\n-----------Level Order Traversal ----- Start----------");
        while (!levelQueue.isEmpty()) {
            BNode<Integer> tempNode = levelQueue.remove();
            System.out.print(tempNode.data + " ");
            if (tempNode.left != null) {
                levelQueue.add(tempNode.left);
            }
            if (tempNode.right != null) {
                levelQueue.add(tempNode.right);
            }
        }
        System.out.println("\n-----------Level Order Traversal ----- End----------");
    }

}
