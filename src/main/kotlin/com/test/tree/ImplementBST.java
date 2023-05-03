package com.test.tree;

public class ImplementBST {
    static class BST {
        public int value;
        public BST left;
        public BST right;
        private int lastValue;

        public BST(int value) {
            this.value = value;
        }

        public BST insert(int value) {
            // Write your code here.
            this.lastValue = value;
            BST node = this;
            if (node.value < value) {
                if (node.right != null) {
                    node = node.right;
                    node.insert(value);
                }
                node.right = new BST(value);
            } else if (node.value > value) {
                if (node.left != null) {
                    node = node.left;
                    node.insert(value);
                }
                node.left = new BST(value);
            } else {
                node.right = new BST(value);
            }

            // Do not edit the return statement of this method.
            return this;
        }

        public boolean contains(int value) {
            // Write your code here.
            BST node = this;
            boolean doesItContain=false;
            if (node.value == value){
                return true;
            } else if (node.value < value && node.right!=null) {
                node = node.right;
                doesItContain = node.contains(value);
            } else if(node.value > value && node.left!=null){
                node = node.left;
                doesItContain= node.contains(value);
            }
            return doesItContain;
        }
        public BST remove(int value) {
            return remove(value,this);
        }
        public BST remove(int value,BST parentNode) {
            // Write your code here.
            // Do not edit the return statement of this method.
            BST node = this;
            if (node.value == value){
                if(node.left==null && node.right==null){
                    node = null; // TODO:Check this..
                    return node;
                } else if(node.left!=null && node.right!=null){ // This is node who has child
                    parentNode.value = parentNode.getMinValueOfRightTree();
                } else if(node == parentNode){
                    // Handle the parent case
                }

            } else if (node.value < value && node.right!=null) {
                node = node.right;
                node.remove(value,parentNode);
            } else if(node.value > value && node.left!=null){
                node = node.left;
                node.remove(value,parentNode);
            }
            return this;
        }


        public int getMinValueOfRightTree(){
            BST node = this.right;
            while(node.left!=null){
                node= node.left;
            }
            return node.value;
        }
    }

    public static void main(String[] args) {
        BST root = new ImplementBST.BST(10);
        root.left = new ImplementBST.BST(5);
        root.left.left = new ImplementBST.BST(2);
        root.left.left.left = new ImplementBST.BST(1);
        root.left.right = new ImplementBST.BST(5);
        root.right = new ImplementBST.BST(15);
        root.right.left = new ImplementBST.BST(13);
        root.right.left.right = new ImplementBST.BST(14);
        root.right.right = new ImplementBST.BST(22);

        root.insert(12);

        System.out.println("Contains 15: "+ root.contains(15));
        System.out.println("Contains 12: "+ root.contains(12));
        System.out.println("getMinValueOfRightTree: "+ root.getMinValueOfRightTree());
       // root.remove(10);
        root.remove(14);
        System.out.println("Contains 14: "+root.contains(14));
    }
}
