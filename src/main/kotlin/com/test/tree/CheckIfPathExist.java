package com.test.tree;
// https://www.geeksforgeeks.org/check-root-leaf-path-given-sequence/
public class CheckIfPathExist {


    private static boolean existPath(Node root, int[] arr, int n, int i) {
        // BC
        if(root == null) return false;

        // Hypo
        if(root.left == null && root.right == null) {
            return root.val == arr[i] && i == n - 1;
        }

        // Choice
        if(i < n && root.val == arr[i]) {
            return existPath(root.left, arr, n, i+1) || existPath(root.right, arr, n, i+1);
        }
        return false;
    }

    public static void main (String[] args) {

        // arr[] : sequence of root to leaf path
        int arr[] = {5, 8, 6, 7};
        int n = arr.length;
        Node root = new Node(5);
        root.left = new Node(3);
        root.right = new Node(8);
        root.left.left = new Node(2);
        root.left.right = new Node(4);
        root.left.left.left = new Node(1);
        root.right.left = new Node(6);
        root.right.left.right = new Node(7);

        if(existPath(root, arr, n, 0))
            System.out.println("Path Exists");
        else
            System.out.println("Path does not Exist");

    }


}
