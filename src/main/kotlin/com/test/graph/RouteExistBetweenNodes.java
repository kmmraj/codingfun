package com.test.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RouteExistBetweenNodes {

    static class GraphNode {
        public String name;
        public int index;
        public boolean isVisited = false;
        public GraphNode parent;
        public Graph.State state;

        public ArrayList<GraphNode> neighbors = new ArrayList<>();

        public GraphNode(String name, int index) {
            this.name = name;
            this.index = index;
        }
    }

    static class Graph {


        static List<GraphNode> nodeList = new ArrayList<>();

        public enum State {
            Unvisited, Visited, Visiting;
        }

        public Graph(List<GraphNode> nodeList) {
            this.nodeList = nodeList;
        }


        public void addDirectedEdge(int i, int j) {
            GraphNode first = nodeList.get(i);
            GraphNode second = nodeList.get(j);
            first.neighbors.add(second);
        }

        //  Route Between Nodes
        //TODO
        public boolean validPath(int source, int destination) {
            GraphNode sourceNode = nodeList.get(source);
            GraphNode targetNode = nodeList.get(destination);

            return isValidPathExist(sourceNode, targetNode, false);


        }

        public static boolean search(GraphNode start, GraphNode end){
            return isValidPathExist(start, end, false);
        }

        private static boolean isValidPathExist(GraphNode sourceNode, GraphNode targetNode, boolean validPath) {
            // BC

            // H & I
            for (int index = 0; index < sourceNode.neighbors.size(); index++) {
                GraphNode neighborNode = sourceNode.neighbors.get(index);
                if (neighborNode == targetNode) {
                    return true;
                } else {
                    neighborNode.isVisited = true;
                }
            }

            for (int index = 0; index < sourceNode.neighbors.size(); index++) {
                GraphNode neighborNode = sourceNode.neighbors.get(index);
                validPath = isValidPathExist(neighborNode, targetNode, validPath);
                if (validPath) {
                    return true;
                }

            }
            return validPath;
        }
    }

    public static void main(String[] args) {
        GraphNode nodeA = new GraphNode("A", 0);
        GraphNode nodeB = new GraphNode("B", 1);
        GraphNode nodeC = new GraphNode("C", 2);
        GraphNode nodeD = new GraphNode("D", 3);
        GraphNode nodeE = new GraphNode("E", 4);
        List<GraphNode> nodeList = Arrays.asList(nodeA, nodeB, nodeC, nodeD, nodeE);
        Graph graph = new Graph(nodeList);

        graph.addDirectedEdge(0, 1);
        graph.addDirectedEdge(0, 2);
        graph.addDirectedEdge(0, 4);
        graph.addDirectedEdge(1, 2);
        graph.addDirectedEdge(1, 3);
        graph.addDirectedEdge(2, 3);
        graph.addDirectedEdge(2, 4);

        System.out.println("is graph.validPath(1,2) ?: " + graph.validPath(1, 2));
        System.out.println("is graph.validPath(2,1) ?: " + graph.validPath(2, 1));
        System.out.println("is graph.validPath(0,3) ?: " + graph.validPath(0, 3));

    }
}
