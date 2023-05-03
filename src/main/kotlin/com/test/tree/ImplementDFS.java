
//https://www.algoexpert.io/questions/Depth-first%20Search
package com.test.tree;

import java.util.ArrayList;
import java.util.List;

public class ImplementDFS {

    static class Node {
        String name;
        List<Node> children = new ArrayList<Node>();

        public Node(String name) {
            this.name = name;
        }

        public List<String> depthFirstSearch(List<String> array) {
            // Write your code here.
            return solveItDFS(this,array);
        }

        public Node addChild(String name) {
            Node child = new Node(name);
            children.add(child);
            return this;
        }
    }

    public static List<String> solveItDFS(Node node, List<String> array){
        // BC
        if(node == null && node.children.isEmpty())
            return array;
        // Hypo & Choices
        array.add(node.name);
        for (Node child: node.children) {
             solveItDFS(child,array);
        }
        return array;
    }

    public static void main(String[] args) {
        ImplementDFS.Node graph = new ImplementDFS.Node("A");
        graph.addChild("B").addChild("C").addChild("D");
        graph.children.get(0).addChild("E").addChild("F");
        graph.children.get(2).addChild("G").addChild("H");
        graph.children.get(0).children.get(1).addChild("I").addChild("J");
        graph.children.get(2).children.get(0).addChild("K");
        String[] expected = {"A", "B", "E", "F", "I", "J", "C", "D", "G", "K", "H"};
        List<String> inputArray = new ArrayList<String>();
        List<String> outputArray = graph.depthFirstSearch(inputArray);
        for (String item: outputArray) {
            System.out.printf("%s ", item);
        }
    }
}
