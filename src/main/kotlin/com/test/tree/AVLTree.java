package com.test.tree;

import java.util.LinkedList;
import java.util.Queue;

public class AVLTree {

    class BinaryNode {
        int value;
        int height;
        BinaryNode left;
        BinaryNode right;


        BinaryNode() {
            this.height = 0;
        }

        BinaryNode(int value) {
            this.height = 0;
            this.value = value;
        }

        public BinaryNode(int value, int height) {
            this.value = value;
            this.height = height;
        }
    }

    BinaryNode root;

    // Constructor
    AVLTree() {
        root = null;
    }

    // PreOrder Traversal
    public void preOrder(BinaryNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.value + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    // Inorder Traversal
    public void inOrder(BinaryNode node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.print(node.value + " ");
        inOrder(node.right);


    }

    // PostOrder Traversal
    public void postOrder(BinaryNode node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.value + " ");
    }

    // Level Order

    void levelOrder() {
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);
        System.out.println("\n------------------ LOT - Start -----------");
        while (!queue.isEmpty()) {
            BinaryNode presentNode = queue.remove();
            System.out.print(presentNode.value + " ");
            if (presentNode.left != null) {
                queue.add(presentNode.left);
            }
            if (presentNode.right != null) {
                queue.add(presentNode.right);
            }
        }
        System.out.println("\n------------------ LOT - End --------------");
    }

    // Search Method
    BinaryNode search(BinaryNode node, int value) {
        if (node == null) {
            System.out.println("Value: " + value + " not found in AVL");
            return null;
        } else if (node.value == value) {
            System.out.println("Value: " + value + " found in AVL");
            return node;
        } else if (value < node.value) {
            return search(node.left, value);
        } else {
            return search(node.right, value);
        }
    }

    //  getHeight
    public int getHeight(BinaryNode node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }

    public void insert(int value) {
        root = insertNode(root, value);
    }

    private BinaryNode insertNode(BinaryNode currentNode, int value) {

        // BC
        if (currentNode == null) {
            return new BinaryNode(value, 1);
        }

        // H
        if (currentNode.value < value) {
            currentNode.right = insertNode(currentNode.right, value);
        } else {
            currentNode.left = insertNode(currentNode.left, value);
        }

        // I

        // Update heights for all members on the insert path
        currentNode.height = 1 + Integer.max(getHeight(currentNode.left), getHeight(currentNode.right));

        int balance = getBalance(currentNode);

        if (balance > 1 && currentNode.left.value > value) { // This means it is left -> left -> left
            return rotateRight(currentNode);
        }

        if (balance < -1 && currentNode.right.value < value) { // This means it is right->right->right
            return rotateLeft(currentNode);
        }

        if (balance > 1 && currentNode.left.value < value) { // This means it is left -> left -> right
            currentNode.left = rotateLeft(currentNode.left);
            return rotateRight(currentNode);

        }

        if (balance < -1 && currentNode.right.value > value) {
            currentNode.right = rotateRight(currentNode.right);
            return rotateLeft(currentNode);
        }

        return currentNode;
    }

    private BinaryNode rotateLeft(BinaryNode unBalancedNode) {
        System.out.println("\n rotateLeft is called");
        BinaryNode newRoot = unBalancedNode.right;
        unBalancedNode.right = unBalancedNode.right.left;
        newRoot.left = unBalancedNode;

        unBalancedNode.height = 1 + Integer.max(getHeight(unBalancedNode.left), getHeight(unBalancedNode.right));
        newRoot.height = 1 + Integer.max(getHeight(newRoot.left), getHeight(newRoot.right));
        return newRoot;
    }

    private BinaryNode rotateRight(BinaryNode unBalancedNode) {
        System.out.println("\n rotateRight is called");
        BinaryNode newRoot = unBalancedNode.left;
        BinaryNode temp = newRoot.right;
        newRoot.right = unBalancedNode;
        unBalancedNode.left = temp;
        unBalancedNode.height = 1 + Integer.max(getHeight(unBalancedNode.left), getHeight(unBalancedNode.right));
        newRoot.height = 1 + Integer.max(getHeight(newRoot.left), getHeight(newRoot.right));
        return newRoot;
    }

    private int getBalance(BinaryNode currentNode) {
        if (currentNode == null) {
            return 0;
        }
        return getHeight(currentNode.left) - getHeight(currentNode.right);
    }

    private BinaryNode getMinNode(BinaryNode currentNode) {
        if (currentNode.left == null) {
            return currentNode;
        }
        return getMinNode(currentNode.left);
    }

    private BinaryNode delete(final int value) {
//        return delete(root, value);
        return deleteItCheck(root, value);
    }

    private BinaryNode deleteItCheck(BinaryNode currentNode, int value) {

        // Find the matching node
        BinaryNode[] foundNodesArray = findIt(value);
        if (foundNodesArray.length != 2) {
            System.out.println("Value " + value + " not found in the tree");
            return null;
        }

        BinaryNode parentNode = foundNodesArray[0];
        BinaryNode foundNode = foundNodesArray[1];

        // No child case
        if (foundNode.left == null && foundNode.right == null) {
            if (parentNode.left == foundNode) {
                parentNode.left = null;
            } else {
                parentNode.right = null;
            }
        }
        // Two child cases
        if (foundNode.left != null && foundNode.right != null) {
            BinaryNode[] successorNodes = findSuccessorNode(foundNode.right, foundNode);
            BinaryNode successorParentNode = successorNodes[0];
            BinaryNode successorNode = successorNodes[1];
            foundNode.value = successorNode.value;
            successorParentNode.left = successorNode.right;
        }

        if (parentNode.left == foundNode) {
            parentNode.left = foundNode.left;
        } else if (parentNode.right == foundNode) {
            parentNode.right = foundNode.right;
        }


        // When rotation needed
        int balance = getBalance(parentNode);

        if (balance > 1 && getBalance(parentNode.left) >= 0) {
            rotateRight(parentNode);
        }
        return currentNode;
    }

    private BinaryNode[] findSuccessorNode(BinaryNode currentNode, BinaryNode prevNode) {
        if (currentNode.left == null) {
            return new BinaryNode[]{prevNode, currentNode};

        }
        return findSuccessorNode(currentNode.left, currentNode);
    }

    private BinaryNode[] findIt(final int value) {
        return findIt(root, root, value);
    }

    private BinaryNode[] findIt(BinaryNode currentNode, BinaryNode prevNode, final int value) {
        if (currentNode == null) {
            System.out.println("Value " + value + " not found in the tree");
            return new BinaryNode[]{prevNode, currentNode};
        }

        if (currentNode.value == value) {
            System.out.println("Value " + value + " is found in the tree");
            return new BinaryNode[]{prevNode, currentNode};
        }

        if (currentNode.value >= value) {
            return findIt(currentNode.left, currentNode, value);
        }

        return findIt(currentNode.right, currentNode, value);

    }


    private BinaryNode delete(BinaryNode currentNode, final int value) {
        // BC
        if (currentNode == null) {
            System.out.println("Value " + value + " not found in the tree");
            return null;
        }
        if (currentNode.value > value) {
            currentNode.left = delete(currentNode.left, value);
        } else if (currentNode.value < value) {
            currentNode.right = delete(currentNode.right, value);
        } else {

        }

        return currentNode;

    }


    // Delete node
    public BinaryNode deleteNode(BinaryNode node, int value) {
        // BC
        if (node == null) {
            System.out.println("Value not found in AVL");
            return null;
        }

        // H
        if (value < node.value) {
            node.left = deleteNode(node.left, value);
        } else if (value > node.value) {
            node.right = deleteNode(node.right, value);
        } else if (value == node.value) { // Matching case

            if (node.left != null && node.right != null) {
                BinaryNode temp = node;
                BinaryNode minNodeForRight = minimumNode(temp.right);
                node.value = minNodeForRight.value;
                node.right = deleteNode(node.right, minNodeForRight.value);
            } else if (node.left != null) {
                node = node.left;
            } else if (node.right != null) {
                node = node.right;
            } else {
                node = null;
            }
        }

        // I
        // Case 2 - rotation required


        int balance = getBalance(node);

        if (balance > 1 && getBalance(node.left) >= 0) {
            return rotateRight(node);
        }
        if (balance > 1 && getBalance(node.left) < 0) {
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }
        if (balance < -1 && getBalance(node.right) <= 0) {
            return rotateLeft(node);
        }

        if (balance < -1 && getBalance(node.right) > 0) {
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }

        return node;

    }


    private BinaryNode deleteIt(BinaryNode currentNode, final int value) {
        // BC
        if (currentNode == null) {
            System.out.println("Value not found " + value);
            return null;
        }

        // Hypo
        if (currentNode.value > value) {
            currentNode.left = deleteIt(currentNode.left, value);
        }

        if (currentNode.value < value) {
            currentNode.right = deleteIt(currentNode.right, value);
        } else if (currentNode.value == value) {
            // Both cases matches
            if (currentNode.left != null && currentNode.right != null) {
                BinaryNode[] successorNodes = findSuccessorNode(currentNode, currentNode);
                BinaryNode successorNode = successorNodes[1];
                currentNode.value = successorNode.value;
                currentNode.right = deleteIt(currentNode.right, successorNode.value);
            } else if (currentNode.left != null) {
                currentNode = currentNode.left;
            } else if (currentNode.right != null) {
                currentNode = currentNode.right;
            } else {
                currentNode = null;
            }

            // Induction
            if (currentNode == null) {
                return null;
            }
            int balance = getBalance(currentNode);
            if (balance > 1 && getBalance(currentNode.left) >= 0) {
                // L -> L -> L => R-> R
                return rotateRight(currentNode);
            }
            if (balance > 1 && getBalance(currentNode.left) < 0) {
                // L -> L -> R => L->L-> L => R -> R -> R
                currentNode.left = rotateLeft(currentNode.left);
                return rotateRight(currentNode);
            }

            if (balance < -1 && getBalance(currentNode.right) <= 0) {
                //  R-> R -> R ==> L -> L - L
                return rotateLeft(currentNode);
            }

            if (balance < -1 && getBalance(currentNode.right) > 0) {
                // R->R->L => R->R->R => L->L->L
                currentNode.right = rotateLeft(currentNode.right);
                return rotateLeft(currentNode);
            }
        }


        return currentNode;
    }

    // // Minimum node
    public static BinaryNode minimumNode(BinaryNode root) {
        if (root.left == null) {
            return root;
        } else {
            return minimumNode(root.left);
        }
    }


    public static void main(String[] args) {
        AVLTree avlTree = new AVLTree();
        avlTree.insert(70);
        avlTree.insert(50);
        avlTree.insert(30); // Right Rotation

        avlTree.levelOrder();

        avlTree.insert(80);
        avlTree.insert(90); // Left Rotation
        avlTree.levelOrder();
        avlTree.insert(100);

        avlTree.levelOrder();

        avlTree.insert(20);
        avlTree.levelOrder();
        avlTree.insert(25); // Right -> Left Rotation
        avlTree.levelOrder();

        avlTree.insert(95); // Left -> Right Rotation
        avlTree.levelOrder();

        System.out.println("Deleting 30 succeeded ? " + avlTree.deleteIt(avlTree.root, 30).value);
        System.out.println("Deleting 70 succeeded ? " + avlTree.deleteIt(avlTree.root, 70).value);
        //avlTree.deleteNode(avlTree.root,30)
//        avlTree.deleteNode(avlTree.root,70);

        avlTree.levelOrder();

    }


}
