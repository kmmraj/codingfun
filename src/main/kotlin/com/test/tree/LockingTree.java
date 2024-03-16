package com.test.tree;

class LockingTree {

    private LockingTree parent, left, right;
    private boolean locked = false;
    private int lockedChildCount = 0;
    private int val;

    private LockingTree[] array;

    public LockingTree(int val) {
        this.val = val;
    }

    public LockingTree(int[] parent) {
        array = new LockingTree[parent.length];
        for (int idx = 0; idx < parent.length; idx++) {
            LockingTree node = new LockingTree(idx);
            if (idx == 0) {
                node.parent = null;
            } else {
                LockingTree parentNode = array[(idx - 1) / 2];
                node.parent = parentNode;
                if (idx % 2 != 0) {
                    parentNode.left = node;
                } else {
                    parentNode.right = node;
                }
            }
            array[idx] = node;
        }

    }

//    public boolean lock(int num, int user) {
//
//    }
//
//    public boolean unlock(int num, int user) {
//
//    }
//
//    public boolean upgrade(int num, int user) {
//
//    }

    public static void main(String[] args) {
        int[] parent = {-1, 0, 0, 1, 1, 2, 2};
        LockingTree lockingTree = new LockingTree(parent);
        System.out.println(lockingTree.array[0].val);

    }
}
