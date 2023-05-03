package com.test.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreathFirstSearch {

    // Do not edit the class below except
    // for the breadthFirstSearch method.
    // Feel free to add new properties
    // and methods to the class.
    static class Node {
        String name;
        List<Node> children = new ArrayList<Node>();

        public Node(String name) {
            this.name = name;
        }

        public List<String> breadthFirstSearch(List<String> array) {
            // Write your code here.
            array.add(this.name);
            array = solveItBFS(new LinkedList<>(this.children), array);
            return array;
        }

        private List<String> solveItBFS(LinkedList<Node> nodeList, List<String> array) {
            if (nodeList.isEmpty())
                return null;
            for (int idx = 0; idx < nodeList.size(); idx++) {
                array.add(nodeList.get(idx).name);
            }

            LinkedList<Node> childList = new LinkedList<>();
            for (int jdx = 0; jdx < nodeList.size(); jdx++) {
                List<Node> children = nodeList.get(jdx).children;
                childList.addAll(children);
            }

            solveItBFS(childList, array);
            return array;
        }

        public Node addChild(String name) {
            Node child = new Node(name);
            children.add(child);
            return this;
        }
    }

    public static void TestCase1() {
        BreathFirstSearch.Node graph = new BreathFirstSearch.Node("A");
        graph.addChild("B").addChild("C").addChild("D");
        graph.children.get(0).addChild("E").addChild("F");
        graph.children.get(2).addChild("G").addChild("H");
        graph.children.get(0).children.get(1).addChild("I").addChild("J");
        graph.children.get(2).children.get(0).addChild("K");
        String[] expected = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K"};
        List<String> inputArray = new ArrayList<String>();
        System.out.println(compare(graph.breadthFirstSearch(inputArray), expected));
    }

    public static boolean compare(List<String> arr1, String[] arr2) {
        if (arr1.size() != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.size(); i++) {
            if (!arr1.get(i).equals(arr2[i])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        TestCase1();
    }

}
