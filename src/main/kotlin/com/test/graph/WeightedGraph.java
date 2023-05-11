package com.test.graph;

import org.graalvm.collections.Pair;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class WeightedGraph {

    static class WeightedNode implements Comparable<WeightedNode> {
        String data;
        int distance;
        int index;

        boolean visited;

        WeightedNode parent;

        List<Pair<WeightedNode, Integer>> neighbours;

        public WeightedNode(String data, int index) {
            this.data = data;
            this.index = index;
            this.distance = Integer.MAX_VALUE;
            this.neighbours = new ArrayList<>();
        }

        @Override
        public int compareTo(@NotNull WeightedNode other) {
            return this.distance - other.distance;
        }
    }

    List<WeightedNode> weightedNodeList;

    public WeightedGraph(List<WeightedNode> weightedNodeList) {
        this.weightedNodeList = weightedNodeList;
    }

    public void addWeightedEdge(int firstIndex, int secondIndex, int distance) {
        WeightedNode first = weightedNodeList.get(firstIndex);
        WeightedNode second = weightedNodeList.get(secondIndex);
        first.neighbours.add(Pair.create(second, distance));
    }


    public static void main(String[] args) {

        WeightedNode nodeA = new WeightedNode("A", 0);
        WeightedNode nodeB = new WeightedNode("B", 1);
        WeightedNode nodeC = new WeightedNode("C", 2);
        WeightedNode nodeD = new WeightedNode("D", 3);
        WeightedNode nodeE = new WeightedNode("E", 4);

        WeightedGraph weightedGraph = new WeightedGraph(List.of(nodeA, nodeB, nodeC, nodeD, nodeE));
        weightedGraph.addWeightedEdge(0, 1, 7);
        weightedGraph.addWeightedEdge(0, 2, 2);
        weightedGraph.addWeightedEdge(0, 3, 2);
        weightedGraph.addWeightedEdge(1, 4, 4);
        weightedGraph.addWeightedEdge(2, 1, 1);
        weightedGraph.addWeightedEdge(2, 4, 3);
        weightedGraph.addWeightedEdge(3, 2, 1);

        weightedGraph.djikstra(nodeA);

    }

    private void djikstra(WeightedNode nodeA) {
        nodeA.distance = 0;
        nodeA.parent = null;
        nodeA.visited = true;
        PriorityQueue<WeightedNode> queue = new PriorityQueue<>(weightedNodeList);
        while (!queue.isEmpty()) {
            WeightedNode currentNode = queue.poll();
            List<Pair<WeightedNode, Integer>> neighbours = currentNode.neighbours;
            neighbours.forEach(pairOfNodeAndDistance -> {
                WeightedNode neighbourNode = pairOfNodeAndDistance.getLeft();
                if (queue.contains(neighbourNode)) {
                    int distance = pairOfNodeAndDistance.getRight();
                    if (neighbourNode.distance > currentNode.distance + distance) {
                        neighbourNode.distance = currentNode.distance + distance;
                        neighbourNode.parent = currentNode;
                        // We need to remove & add the elements to the queue, so that
                        // priority queue will order it naturally according to the comparator
                        queue.remove(neighbourNode);
                        queue.add(neighbourNode);
                    }
                }
            });
        }

        weightedNodeList.forEach(weightedNode -> {

            System.out.println("\nNode :" + weightedNode.data + " distance: "+weightedNode.distance+ " Path : ");
            pathPrint(weightedNode);
            System.out.println();
        });

    }
    public static void pathPrint(WeightedNode node) {
        if (node.parent  != null) {
            pathPrint(node.parent);
        }
        System.out.print(node.data + " ");
    }


}
