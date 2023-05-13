package com.test.graph;

import com.test.heap.ImplementHeap;
import org.graalvm.collections.Pair;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class WeightedGraph {


    static class WeightedNode implements Comparable<WeightedNode> {
        String data;
        int distance;
        int index;

        boolean visited;

        WeightedNode parent;

        List<Pair<WeightedNode, Integer>> neighbours;

        public DisJointedSet disJointedSet;

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

    private List<WeightedNode> weightedNodeList;
    private List<UnDirectedEdge> edgeList;

    public WeightedGraph(List<WeightedNode> weightedNodeList) {
        this.weightedNodeList = weightedNodeList;
        this.edgeList = new ArrayList<>();
    }

    public void addWeightedEdge(int firstIndex, int secondIndex, int distance) {
        WeightedNode first = weightedNodeList.get(firstIndex);
        WeightedNode second = weightedNodeList.get(secondIndex);
        first.neighbours.add(Pair.create(second, distance));
    }


    public void addWeightedUndirectedEdge(int firstIndex, int secondIndex, int weight) {
        UnDirectedEdge edge = new UnDirectedEdge(
                weightedNodeList.get(firstIndex),
                weightedNodeList.get(secondIndex),
                weight);
        WeightedNode first = edge.first;
        WeightedNode second = edge.second;
        first.neighbours.add(Pair.create(second, weight));
        second.neighbours.add(Pair.create(first, weight));
        edgeList.add(edge);
    }


    public static void main(String[] args) {

        // WeightedGraph weightedGraph = Test_Case_Dijkstra_BellManFord_FloydMarshall();
        WeightedNode nodeA = new WeightedNode("A", 0);
        WeightedNode nodeB = new WeightedNode("B", 1);
        WeightedNode nodeC = new WeightedNode("C", 2);
        WeightedNode nodeD = new WeightedNode("D", 3);
        WeightedNode nodeE = new WeightedNode("E", 4);

        WeightedGraph weightedGraph = new WeightedGraph(List.of(nodeA, nodeB, nodeC, nodeD, nodeE));
        weightedGraph.addWeightedUndirectedEdge(0, 1, 5);
        weightedGraph.addWeightedUndirectedEdge(0, 2, 13);
        weightedGraph.addWeightedUndirectedEdge(0, 4, 15);
        weightedGraph.addWeightedUndirectedEdge(1, 2, 10);
        weightedGraph.addWeightedUndirectedEdge(1, 3, 8);
        weightedGraph.addWeightedUndirectedEdge(2, 3, 6);
        weightedGraph.addWeightedUndirectedEdge(2, 4, 20);
        // weightedGraph.kruskal();
        weightedGraph.prims(nodeA);

    }

    private void prims(WeightedNode nodeA) {
        weightedNodeList.forEach(node -> {
            node.visited = false;
            node.parent = null;
            node.distance = Integer.MAX_VALUE;
        });
        nodeA.distance = 0;
        PriorityQueue<WeightedNode> priorityQueue = new PriorityQueue<>();
        priorityQueue.addAll(weightedNodeList);
        while (!priorityQueue.isEmpty()) {
            WeightedNode currentNode = priorityQueue.poll();
            currentNode.neighbours.forEach(pair -> {
                WeightedNode neighbourNode = pair.getLeft();
                int distance = pair.getRight();
                if (priorityQueue.contains(neighbourNode)) {
                    if (neighbourNode.distance > distance) {
                        neighbourNode.distance = distance;
                        neighbourNode.parent = currentNode;
                        priorityQueue.remove(neighbourNode);
                        priorityQueue.add(neighbourNode);
                    }
                }
            });
        }

        int cost = 0;
        // print table of node with minimum distance and shortest path from source
        for (WeightedNode nodeToCheck : weightedNodeList) {
            System.out.println("Node " + nodeToCheck.data + ", key: " + nodeToCheck.distance + ", Parent: "
                    + (nodeToCheck.parent != null ? nodeToCheck.parent.data :"null"));
            cost = cost + nodeToCheck.distance;
        }//end of for loop

        System.out.println("\nTotal cost of MST: " + cost);

    }

    @NotNull
    private static WeightedGraph Test_Case_Dijkstra_BellManFord_FloydMarshall() {
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

        //weightedGraph.dijkstra(nodeA);
        // weightedGraph.bellmanFord(nodeA);
//        weightedGraph.floydMarshall();
        return weightedGraph;
    }

    private void kruskal() {
        DisJointedSet.makeSet(weightedNodeList);
        Collections.sort(edgeList);
        int cost = 0;
        for (UnDirectedEdge edge : edgeList) {
            WeightedNode first = edge.first;
            WeightedNode second = edge.second;
            if (DisJointedSet.findSet(first) != DisJointedSet.findSet(second)) {
                DisJointedSet.union(first, second);
                cost += edge.weight;
                System.out.println("Edge taken ( " + first.data + " , " + second.data + " ) : " + edge.weight);
            }
        }
        System.out.println("\nTotal cost of MST: " + cost);

    }

    private void floydMarshall() {
        int[][] matrix = new int[weightedNodeList.size()][weightedNodeList.size()];

        for (int source = 0; source < matrix.length; source++) {
            for (int destination = 0; destination < matrix.length; destination++) {
                if (source == destination) {
                    matrix[source][destination] = 0;
                } else {
                    WeightedNode sourceNode = weightedNodeList.get(source);
                    WeightedNode destinationNode = weightedNodeList.get(destination);
                    int distance = sourceNode.neighbours
                            .stream()
                            .filter(weightedNodeIntegerPair -> destinationNode.equals(weightedNodeIntegerPair.getLeft()))
                            .map(Pair::getRight)
                            .findAny().orElse(Integer.MAX_VALUE / 10);

                    matrix[source][destination] = distance;
                }
            }
        }


        for (int intermediate = 0; intermediate < matrix.length; intermediate++) {
            for (int source = 0; source < matrix.length; source++) {
                for (int destination = 0; destination < matrix.length; destination++) {
                    if (matrix[source][destination] > matrix[source][intermediate] + matrix[intermediate][destination]) {
                        matrix[source][destination] = matrix[source][intermediate] + matrix[intermediate][destination];
                    }
                }
            }
        }


        System.out.println("\nPrinting distance list for node       A              B             C             D           E");
        System.out.println("-------------------------------------------------------------------------------------------------");
        // Print table of node with minimum distance and shortest path from each source
        for (int source = 0; source < matrix.length; source++) {
            System.out.print("Printing distance list for node " + weightedNodeList.get(source).data + ": ");
            for (int destination = 0; destination < matrix.length; destination++) {
                System.out.printf("%11d ", matrix[source][destination]);
            }
            System.out.println();
        }

    }

    private void bellmanFord(WeightedNode nodeA) {
        nodeA.distance = 0;
        nodeA.parent = null;
        for (int index = 0; index < weightedNodeList.size(); index++) {
            WeightedNode currentNode = weightedNodeList.get(index);
            currentNode.neighbours.forEach(neigbourNodeAndDistancePair -> {
                WeightedNode neighbourNode = neigbourNodeAndDistancePair.getLeft();
                int distanceFromNeighbourNode = neigbourNodeAndDistancePair.getRight();
                if (neighbourNode.distance > currentNode.distance + distanceFromNeighbourNode) {
                    neighbourNode.distance = currentNode.distance + distanceFromNeighbourNode;
                    neighbourNode.parent = currentNode;
                }
            });
        }

        for (int index = 0; index < weightedNodeList.size(); index++) {
            WeightedNode currentNode = weightedNodeList.get(index);
            currentNode.neighbours.forEach(neigbourNodeAndDistancePair -> {
                WeightedNode neighbourNode = neigbourNodeAndDistancePair.getLeft();
                int distanceFromNeighbourNode = neigbourNodeAndDistancePair.getRight();
                if (neighbourNode.distance > currentNode.distance + distanceFromNeighbourNode) {
                    System.out.println("Negative Cycle detected!");
                    return;
                }
            });

            System.out.println("No Negative Cycle detected!");
        }

        for (int index = 0; index < weightedNodeList.size(); index++) {
            WeightedNode currentNode = weightedNodeList.get(index);
            System.out.println("Path for the node" + currentNode.data + " total distance is  " + currentNode.distance + " path is :");
            pathPrint(currentNode);
            System.out.println();
        }


    }

    private void dijkstra(WeightedNode nodeA) {
        nodeA.distance = 0;
        nodeA.parent = null;
        PriorityQueue<WeightedNode> queue = new PriorityQueue<>(weightedNodeList);
        while (!queue.isEmpty()) {
            WeightedNode currentNode = queue.poll();
            List<Pair<WeightedNode, Integer>> neighbours = currentNode.neighbours;
            neighbours.forEach(pairOfNodeAndDistance -> {
                WeightedNode neighbourNode = pairOfNodeAndDistance.getLeft();
                if (queue.contains(neighbourNode)) {
                    int distanceToNeighbourNode = pairOfNodeAndDistance.getRight();
                    if (neighbourNode.distance > currentNode.distance + distanceToNeighbourNode) {
                        neighbourNode.distance = currentNode.distance + distanceToNeighbourNode;
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

            System.out.println("\nNode :" + weightedNode.data + " distance: " + weightedNode.distance + " Path : ");
            pathPrint(weightedNode);
            System.out.println();
        });

    }

    public static void pathPrint(WeightedNode node) {
        if (node.parent != null) {
            pathPrint(node.parent);
        }
        System.out.print(node.data + " ");
    }


}
