package com.test.tree;
// https://leetcode.com/problems/recover-a-tree-from-preorder-traversal/description/
/**
 * 1028. Recover a Tree From Preorder Traversal
 * Hard
 * We run a preorder depth-first search (DFS) on the root of a binary tree.
 *
 * At each node in this traversal, we output D dashes (where D is the depth of this node), then we output the value of this node.  If the depth of a node is D, the depth of its immediate child is D + 1.  The depth of the root node is 0.
 *
 * If a node has only one child, that child is guaranteed to be the left child.
 *
 * Given the output traversal of this traversal, recover the tree and return its root.
 *
 *
 *
 * Example 1:
 *
 * Input: traversal = "1-2--3--4-5--6--7"
 * Output: [1,2,5,3,4,6,7]
 *
 * Example 2:
 *
 * Input: traversal = "1-2--3---4-5--6---7"
 * Output: [1,2,5,3,null,6,null,4,null,7]
 *
 * Example 3:
 *
 * Input: traversal = "1-401--349---90--88"
 * Output: [1,401,null,349,88,90]
 *
 *
 * Constraints:
 *
 * The number of nodes in the original tree is in the range [1, 1000].
 * 1 <= Node.val <= 109
 */

import java.util.ArrayList;
import java.util.List;

public class ReConstructFromPreOrderString {
    List<String> traversalList;
    int index;

    public TreeNode recoverFromPreorder(String traversal) {
        System.out.println("traversal is " + traversal);
        traversalList = new ArrayList<>();
        index = 0;
        int idx = 0;
        while (idx < traversal.length()) {
            if (traversal.charAt(idx) != '-') {
                StringBuilder tempSB = new StringBuilder();
                while (idx < traversal.length() && traversal.charAt(idx) != '-') {
                    tempSB.append(traversal.charAt(idx));
                    idx++;
                }
                traversalList.add(tempSB.toString());
            } else {
                StringBuilder tempSB = new StringBuilder();
                while (idx < traversal.length() && traversal.charAt(idx) == '-') {
                    tempSB.append(traversal.charAt(idx));
                    idx++;
                }
                traversalList.add(tempSB.toString());
            }

        }
        System.out.println("traversalList is " + traversalList);
        return recoverFromPreorderHelper(0);
    }

    private TreeNode recoverFromPreorderHelper(int sizeIdx) {
        // BC
        if (index >= traversalList.size()) {
            return null;
        }

        // H & I
        //[1, -, 2, --, 3, --, 4, -, 5, --, 6, --, 7]
        System.out.println("index is " + index + " sizeIdx is " + sizeIdx
                + " traversalList.get(index).length() is " + traversalList.get(index).length());
        if (traversalList.get(index).charAt(0) == '-' && sizeIdx > traversalList.get(index).length()) {
            System.out.println("returning null");
            return null;
        }

        if (traversalList.get(index).charAt(0) == '-' && traversalList.get(index).length() == sizeIdx) {
            index++;
        }
        TreeNode node = new TreeNode(Integer.parseInt(traversalList.get(index++)));
        node.left = recoverFromPreorderHelper(sizeIdx + 1);
        node.right = recoverFromPreorderHelper(sizeIdx + 1);
        return node;
    }

    public static void main(String[] args) {
        ReConstructFromPreOrderString reConstructFromPreOrderString = new ReConstructFromPreOrderString();
        TreeNode root = reConstructFromPreOrderString.recoverFromPreorder("1-2--3--4-5--6--7");
        System.out.println("root should be 1 and the result is  " + root.val + " verified " + (root.val == 1));
        System.out.println("root.left should be 2 and the result is  " + root.left.val + " verified " + (root.left.val == 2));
        System.out.println("root.right should be 5 and the result is  " + root.right.val + " verified " + (root.right.val == 5));
        System.out.println("root.left.left should be 3 and the result is  " + root.left.left.val + " verified " + (root.left.left.val == 3));
        System.out.println("root.left.right should be 4 and the result is  " + root.left.right.val + " verified " + (root.left.right.val == 4));
        System.out.println("root.right.left should be 6 and the result is  " + root.right.left.val + " verified " + (root.right.left.val == 6));
        System.out.println("root.right.right should be 7 and the result is  " + root.right.right.val + " verified " + (root.right.right.val == 7));



    }
}
