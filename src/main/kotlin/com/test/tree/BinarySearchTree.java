package com.test.tree;

import java.util.Queue;

public class BinarySearchTree {

    class BSTNode {
        int data;
        BSTNode left;
        BSTNode right;

        public BSTNode(int data) {
            this.data = data;
        }
    }

    BSTNode root;

    public BinarySearchTree() {
        this.root = null;
    }

    public BSTNode insert(final int value) {

        BSTNode newNode = new BSTNode(value);
        return insert(root, newNode);

    }

    private BSTNode insert(BSTNode currentNode, final BSTNode newNode) {
        // BC
        if (currentNode == null) {
            currentNode = newNode;
            if (root == null) {
                root = newNode;
            }
            return currentNode;
        }

        // H & I
        if (currentNode.data < newNode.data) {
            currentNode.right = insert(currentNode.right, newNode);
        } else {
            currentNode.left = insert(currentNode.left, newNode);
        }
        return currentNode;

    }


    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.insert(10);
        binarySearchTree.insert(5);
        binarySearchTree.insert(15);
        binarySearchTree.insert(2);
        binarySearchTree.insert(6);
        binarySearchTree.insert(13);
        binarySearchTree.insert(22);
        binarySearchTree.insert(1);
        binarySearchTree.insert(14);

        binarySearchTree.levelOrderTraversal(binarySearchTree.root);
        System.out.println("\n ---------------- Pre --Start----------");
        binarySearchTree.preOrderTraversal(binarySearchTree.root);
        System.out.println("\n ---------------- Pre --End----------");

        System.out.println("\n ---------------- In --Start----------");
        binarySearchTree.inOrderTraversal(binarySearchTree.root);
        System.out.println("\n ---------------- In --End----------");

        System.out.println("binarySearchTree.search(10) found ? " + binarySearchTree.search(10));
        System.out.println("binarySearchTree.search(11) found ? " + binarySearchTree.search(11));
        System.out.println("binarySearchTree.search(14) found ? " + binarySearchTree.search(14));


//        System.out.println("binarySearchTree.delete(14)  ? " + binarySearchTree.delete(14));
//        binarySearchTree.levelOrderTraversal(binarySearchTree.root);
//        System.out.println("binarySearchTree.delete(2)  ? " + binarySearchTree.delete(2));
//        binarySearchTree.levelOrderTraversal(binarySearchTree.root);
        binarySearchTree.levelOrderTraversal(binarySearchTree.root);
        System.out.println("binarySearchTree.delete(10)  ? " + binarySearchTree.delete(10));
        binarySearchTree.levelOrderTraversal(binarySearchTree.root);
    }

    private boolean delete(final int value) {
        return deleteIt(value);
    }

    private boolean deleteIt(final int value) {

        // Find the node

        // Check if the node has child
        // No child,delete the node.
        // if 1 child, delete the node make the node's parent
        // as the child's parent using the same direction

        // if 2 child, find the next successor (least value among right children)
        // and make it as the parent and delete the child
        // (by connecting the child's parent to child's child using same direction)

        BSTNode[] foundBSTNodes = find(value);
        if (foundBSTNodes.length != 2) {
            System.out.println("Value " + value + " Not found");
        }
        BSTNode parentNode = foundBSTNodes[0];
        BSTNode foundNode = foundBSTNodes[1];

        if (foundNode.left == null && foundNode.right == null) {
            if (parentNode.left == foundNode) {
                parentNode.left = null;
                return true;
            }

            if (parentNode.right == foundNode) {
                parentNode.right = null;
                return true;
            }

        }



        // Two child exists
        if (foundNode.left != null && foundNode.right != null) {
            BSTNode[] successorNodes = findSuccessor(foundNode.right, foundNode);
            if(successorNodes.length !=2){
                //throw new Exception("Internal Error");
                System.out.println("Error - Internal Error");
                return false;
            }
            BSTNode prevSuccessorNode = successorNodes[0];
            BSTNode foundSuccessorNode = successorNodes[1];
            foundNode.data = foundSuccessorNode.data;

            prevSuccessorNode.left = foundSuccessorNode.right;
            return true;
        }


        // One child case
        if (parentNode.left == foundNode) {
            parentNode.left = foundNode.left;
        }

        if (parentNode.right == foundNode) {
            parentNode.right = foundNode.right;
        }
        return true;


    }

    private BSTNode[] findSuccessor(BSTNode currentNode, BSTNode prevNode) {
        // BC
        if(currentNode.left == null){
            return new BSTNode[]{prevNode,currentNode};
        }

        //  H & I
        return findSuccessor(currentNode.left,currentNode);
    }


    private BSTNode[] find(final int value) {
        return findIt(root, root, value);
    }

    private BSTNode[] findIt(final BSTNode currentNode, BSTNode prevNode, final int value) {
        // BC
        if (currentNode == null) {
            return new BSTNode[]{};
        }
        if (currentNode.data == value) {
            return new BSTNode[]{prevNode, currentNode};
        }

        // H & I
        if (currentNode.data >= value) {
            return findIt(currentNode.left, currentNode, value);
        } else {
            return findIt(currentNode.right, currentNode, value);
        }
    }

    private boolean search(final int value) {
        return searchIt(root, value);
    }

    private boolean searchIt(final BSTNode currentNode, final int value) {
        // BC
        if (currentNode == null) {
            return false;
        }
        if (currentNode.data == value) {
            return true;
        }

        // H & I
        if (currentNode.data >= value) {
            return searchIt(currentNode.left, value);
        } else {
            return searchIt(currentNode.right, value);
        }
    }

    private void preOrderTraversal(BSTNode currentNode) {
        if (currentNode == null) {
            return;
        }
        System.out.print(currentNode.data + " ");
        preOrderTraversal(currentNode.left);
        preOrderTraversal(currentNode.right);
    }

    private void inOrderTraversal(BSTNode currentNode) {
        if (currentNode == null) {
            return;
        }
        inOrderTraversal(currentNode.left);
        System.out.print(currentNode.data + " ");
        inOrderTraversal(currentNode.right);
    }

    private void levelOrderTraversal(BSTNode currentNode) {
        if (currentNode == null) {
            return;
        }

        Queue<BSTNode> levelOrderQueue = new java.util.LinkedList<>();
        levelOrderQueue.add(currentNode);
        System.out.println("\n ---------------- LOT --Start----------");
        while (!levelOrderQueue.isEmpty()) {
            BSTNode tempNode = levelOrderQueue.remove();
            System.out.print(tempNode.data + " ");
            if (tempNode.left != null) {
                levelOrderQueue.add(tempNode.left);
            }
            if (tempNode.right != null) {
                levelOrderQueue.add(tempNode.right);
            }

        }
        System.out.println("\n ---------------- LOT --End----------");


    }


}
