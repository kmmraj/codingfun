package com.test.graph;

import java.util.*;

// Leet code - 1971. Find if Path Exists in Graph
public class FindPathExistsInGraph {

    static class GraphNode {
        int index;
        boolean visited;
        List<GraphNode> neighbours;

        public GraphNode(int index) {
            this.index = index;
            neighbours = new ArrayList<>();
        }
    }

    public static boolean validPath(int n, int[][] edges, int source, int destination) {

        if (source == destination) {
            return true;
        }
        Map<Integer, GraphNode> graph = new HashMap<>();
        for (int[] edge : edges) {
            addUndirectedEdge(graph, edge);
        }

        GraphNode sourceNode = graph.get(source);
        GraphNode targetNode = graph.get(destination);


        if (sourceNode == null || targetNode == null) {
            return false;
        }

        Queue<GraphNode> queue = new LinkedList<>();
        queue.offer(sourceNode);

        while (!queue.isEmpty()) {
            GraphNode currentNode = queue.poll();
            if (currentNode == targetNode) {
                return true;
            }

            for (GraphNode neighbourNode : currentNode.neighbours) {
                if (!neighbourNode.visited) {
                    neighbourNode.visited = true;
                    queue.add(neighbourNode);
                }
            }

        }

        return false;
    }

    private static void addUndirectedEdge(Map<Integer, GraphNode> graph, int[] edge) {
        int origin = edge[0];
        int target = edge[1];

        graph.computeIfAbsent(origin, integer -> new GraphNode(origin));
        graph.computeIfAbsent(target, integer -> new GraphNode(target));
        GraphNode originNode = graph.get(origin);
        GraphNode targetNode = graph.get(target);

        originNode.neighbours.add(targetNode);
        targetNode.neighbours.add(originNode);
    }

    public static void main(String[] args) {
        int[][] matrix = {{0, 1}, {1, 2}, {2, 0}};
        int[][] matrixA = {{0, 1}, {0, 2}, {3, 5}, {5, 4}, {4, 3}};

        System.out.println("Path exists between 0 and 2 ? "
                + FindPathExistsInGraph.validPath(3, matrix, 0, 2));
        System.out.println("Path exists between 0 and 5 ? "
                + FindPathExistsInGraph.validPath(5, matrixA, 0, 5));
    }

}
