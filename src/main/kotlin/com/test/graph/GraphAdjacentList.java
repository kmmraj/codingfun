package com.test.graph;
//Adjacency lists are a common way to represent graphs in computer science.
// They efficiently store information about which vertices (nodes) are connected by edges in a graph.
//
//Key Concepts:
//
//Graph: A collection of vertices (nodes) and edges that connect them, representing relationships or connections.
//Vertices: Individual entities in the graph (e.g., people in a social network, cities on a map).
//Edges: Connections between vertices (e.g., friendships, roads).
//Adjacency List Structure:
//
//List of lists: Each vertex has its own list, storing the vertices it's directly connected to (its neighbors).
//Sparse graphs: Adjacency lists are particularly efficient for graphs with relatively few edges compared to vertices.
//Example:
//
//Consider this graph:
//
//A -- B
//|    |
//C -- D
//Adjacency list representation:
//
//A: [B, C]
//B: [A, D]
//C: [A, D]
//D: [B, C]

import java.util.*;
import java.util.stream.Collectors;

public class GraphAdjacentList {

    static class GraphNode {
        public GraphNode parent;
        String data;

        int index;
        List<GraphNode> neighbours;

        boolean visited;

        public GraphNode(String data, int index) {
            this.data = data;
            this.index = index;
            neighbours = new ArrayList<>();
        }
    }

    List<GraphNode> graphNodeList;

    public GraphAdjacentList() {
        this.graphNodeList = new ArrayList<>();
    }

    public void addUndirectedEdge(int firstIndex, int secondIndex) {
        GraphNode firstNode = graphNodeList.get(firstIndex);
        GraphNode secondNode = graphNodeList.get(secondIndex);
        firstNode.neighbours.add(secondNode);
        secondNode.neighbours.add(firstNode);
    }

    public void addDirectedEdge(int firstIndex, int secondIndex) {
        GraphNode firstNode = graphNodeList.get(firstIndex);
        GraphNode secondNode = graphNodeList.get(secondIndex);
        firstNode.neighbours.add(secondNode);
        // secondNode.neighbours.add(firstNode);
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int index = 0; index < graphNodeList.size(); index++) {
            s.append(graphNodeList.get(index).data).append(": ");
            for (int neighnoursIndex = 0; neighnoursIndex < graphNodeList.get(index).neighbours.size(); neighnoursIndex++) {
                if (neighnoursIndex == graphNodeList.get(index).neighbours.size() - 1) {
                    s.append((graphNodeList.get(index).neighbours.get(neighnoursIndex).data));
                } else {
                    s.append(graphNodeList.get(index).neighbours.get(neighnoursIndex).data).append(" -> ");
                }
            }
            s.append("\n");
        }
        return s.toString();
    }

    private String breathFirstTraversal() {
        StringBuilder sb = new StringBuilder();

        Queue<GraphNode> queue = new LinkedList<>();

        queue.add(graphNodeList.get(0));
        while (!queue.isEmpty()) {
            GraphNode nextNode = queue.poll();

            if (!nextNode.visited) {
                sb.append(nextNode.data).append(" ");
                nextNode.visited = true;
            }
            nextNode.neighbours.stream()
                    .filter(node -> !node.visited)
                    .collect(Collectors.toCollection(() -> queue));
        }
        return sb.toString();
    }

    private String depthFirstTraversal() {
        StringBuilder sb = new StringBuilder();

        Stack<GraphNode> stack = new Stack<>();

//        Deque<GraphNode> stack = new ArrayDeque<>();

        stack.add(graphNodeList.get(0));
        while (!stack.isEmpty()) {
            GraphNode nextNode = stack.pop();

            if (!nextNode.visited) {
                sb.append(nextNode.data).append(" ");
                nextNode.visited = true;
            }
            nextNode.neighbours.stream()
                    .filter(node -> !node.visited)
                    .collect(Collectors.toCollection(() -> stack));
        }
        return sb.toString();
    }

    private void updateVisited() {
        this.graphNodeList.stream().map(node -> node.visited = false).toList();
    }


    public static void main(String[] args) {
        //   test_1();

        GraphAdjacentList graphAdjacentList = new GraphAdjacentList();
        graphAdjacentList.graphNodeList.add(new GraphNode("A", 0));
        graphAdjacentList.graphNodeList.add(new GraphNode("B", 1));
        graphAdjacentList.graphNodeList.add(new GraphNode("C", 2));
        graphAdjacentList.graphNodeList.add(new GraphNode("D", 3));
        graphAdjacentList.graphNodeList.add(new GraphNode("E", 4));

        graphAdjacentList.addDirectedEdge(0, 1);
        graphAdjacentList.addDirectedEdge(0, 2);
        graphAdjacentList.addDirectedEdge(0, 3);
        graphAdjacentList.addDirectedEdge(1, 4);
        graphAdjacentList.addDirectedEdge(2, 3);
        graphAdjacentList.addDirectedEdge(3, 4);

        /**
         *                 A --------- B
         *                 |  \       / \
         *                 |    \  /      \  -- E
         *                 |  /   \     /
         *                 C        \ D
         *
         */

        System.out.println(graphAdjacentList.toString());
        System.out.println(graphAdjacentList.breathFirstTraversal());
        graphAdjacentList.updateVisited();
        System.out.println(graphAdjacentList.depthFirstTraversal());
        graphAdjacentList.updateVisited();

        System.out.println("Topological Sort : " +graphAdjacentList.topologicalSort());
        graphAdjacentList.updateVisited();
        System.out.println(graphAdjacentList.bFS4SSSP(graphAdjacentList.graphNodeList.get(0)));
        graphAdjacentList.updateVisited();
        graphAdjacentList.BFSForSSSPP(graphAdjacentList.graphNodeList.get(0));
    }

    private String bFS4SSSP(GraphNode graphNode) {
        StringBuilder sb = new StringBuilder();
        Queue<GraphNode> queue = new LinkedList<>();
        queue.add(graphNode);
        sb.append("\n");
        while (!queue.isEmpty()) {
            GraphNode node = queue.poll();
            if (!node.visited) {
                node.visited = true;
            }
//            System.out.print("Printing path for node# " + node.data + ": ");
//            printPath(node);
            sb
                    .append("Printing path for node# ")
                    .append(node.data)
                    .append(": ")
                    .append(printPathUsingStack(node))
                    .append("\n");
//            System.out.println();
            node.neighbours.forEach(neighbourNode -> {
                if (!neighbourNode.visited) {
                    queue.add(neighbourNode);
                    neighbourNode.visited = true;
                    neighbourNode.parent = node;
                }
            });

        }
        return sb.toString();
    }

    private void printPath(GraphNode node) {
        if (node.parent != null) {
            printPath(node.parent);
        }
        System.out.print(node.data + " ");
    }

    private String printPathUsingStack(GraphNode node) {
        Stack<GraphNode> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        while (node.parent != null) {
            stack.add(node);
            node = node.parent;
        }
        stack.add(node);
        while (!stack.isEmpty()) {
            GraphNode tempNode = stack.pop();
            sb.append(tempNode.data).append(" ");
        }
        return sb.toString();
    }

    public static void pathPrint(GraphNode node) {
        if (node.parent != null) {
            pathPrint(node.parent);
        }
        System.out.print(node.data + " ");
    }

    public void BFSForSSSPP(GraphNode node) {
        LinkedList<GraphNode> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            GraphNode currentNode = queue.remove(0);
            currentNode.visited = true;
            System.out.print("Printing path for node " + currentNode.data + ": ");
            pathPrint(currentNode);
            System.out.println();
            for (GraphNode neighbor : currentNode.neighbours) {
                if (!neighbor.visited) {
                    queue.add(neighbor);
                    neighbor.visited = true;
                    neighbor.parent = currentNode;
                }
            }

        }
    }

    private String topologicalSort() {
        StringBuilder sb = new StringBuilder();
        Stack<GraphNode> stack = new Stack<>();
        graphNodeList.forEach(graphNode -> topologicalSortIt(graphNode, stack));

        while (!stack.isEmpty()) {
            GraphNode node = stack.pop();
            if (!node.visited) {
                sb.append(node.data).append(" ");
                node.visited = true;
            }
        }

        return sb.toString();
    }

    private void topologicalSortIt(GraphNode graphNode, Stack<GraphNode> stack) {
        if (!graphNode.visited) {
            stack.push(graphNode);
        }
        List<GraphNode> neighbours = graphNode.neighbours;
        neighbours.forEach(node -> {
            if (!node.visited) {
                stack.push(node);
            }
        });
    }

    private static void test_1() {
        GraphAdjacentList graphAdjacentList = new GraphAdjacentList();
        graphAdjacentList.graphNodeList.add(new GraphNode("A", 0));
        graphAdjacentList.graphNodeList.add(new GraphNode("B", 1));
        graphAdjacentList.graphNodeList.add(new GraphNode("C", 2));
        graphAdjacentList.graphNodeList.add(new GraphNode("D", 3));
        graphAdjacentList.graphNodeList.add(new GraphNode("E", 4));

        graphAdjacentList.addUndirectedEdge(0, 1);
        graphAdjacentList.addUndirectedEdge(0, 2);
        graphAdjacentList.addUndirectedEdge(0, 3);
        graphAdjacentList.addUndirectedEdge(1, 4);
        graphAdjacentList.addUndirectedEdge(2, 3);
        graphAdjacentList.addUndirectedEdge(3, 4);

        System.out.println(graphAdjacentList.toString());
        System.out.println(graphAdjacentList.breathFirstTraversal());
        graphAdjacentList.updateVisited();
        System.out.println(graphAdjacentList.depthFirstTraversal());
    }


}
