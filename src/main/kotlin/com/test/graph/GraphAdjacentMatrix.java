package com.test.graph;

import java.util.*;

public class GraphAdjacentMatrix {

    static class GraphNode {

        GraphNode parent;
        String data;
        int index;

        boolean visited;

        public GraphNode(String data, int index) {
            this.data = data;
            this.index = index;
        }
    }

    List<GraphNode> graphNodeList;

    int[][] matrix;

    public GraphAdjacentMatrix(List<GraphNode> graphNodeList) {
        this.graphNodeList = graphNodeList;
        this.matrix = new int[graphNodeList.size()][graphNodeList.size()];
    }

    public void addUndirectedEdge(int firstIndex, int secondIndex) {
        matrix[firstIndex][secondIndex] = 1;
        matrix[secondIndex][firstIndex] = 1;
    }

    public void addDirectedEdge(int firstIndex, int secondIndex) {
        matrix[firstIndex][secondIndex] = 1;
        // matrix[secondIndex][firstIndex] = 1;
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("   ");
        for (GraphNode graphNode : graphNodeList) {
            s.append(graphNode.data).append(" ");
        }
        s.append("\n");
        for (int i = 0; i < graphNodeList.size(); i++) {
            s.append(graphNodeList.get(i).data).append(": ");
            for (int j : matrix[i]) {
                s.append(j).append(" ");
            }
            s.append("\n");
        }
        return s.toString();
    }

    private String breathFirstTraversal() {
        StringBuilder sb = new StringBuilder();
        Queue<GraphNode> queue = new LinkedList<>();
        queue.add(this.graphNodeList.get(0));
        while (!queue.isEmpty()) {
            GraphNode nextNode = queue.poll();
//            if (!nextNode.visited) {
//                nextNode.visited = true;
//                sb.append(nextNode.data).append("-> ");
//            }
            sb.append(nextNode.data).append("-> ");
            nextNode.visited = true;

            List<GraphNode> neighboursList = getNeighbours(nextNode);
            for (GraphNode graphNode : neighboursList) {
                if (!graphNode.visited) {
                    graphNode.visited = true;
                    queue.add(graphNode);
                }
            }
        }
        return sb.toString();
    }

    private String depthFirstTraversal() {
        StringBuilder sb = new StringBuilder();
        Deque<GraphNode> stack = new ArrayDeque<>();
        stack.push(this.graphNodeList.get(0));
        while (!stack.isEmpty()) {
            GraphNode nextNode = stack.pop();
//            if (!nextNode.visited) {
//                nextNode.visited = true;
//                sb.append(nextNode.data).append("-> ");
//            }
            sb.append(nextNode.data).append("-> ");
            nextNode.visited = true;

            List<GraphNode> neighboursList = getNeighbours(nextNode);
            for (GraphNode graphNode : neighboursList) {
                if (!graphNode.visited) {
                    graphNode.visited = true;
                    stack.push(graphNode);
                }
            }
        }
        return sb.toString();
    }

    private List<GraphNode> getNeighbours(GraphNode nextNode) {
        int nextNodeIndex = nextNode.index;
        List<GraphNode> neighboursList = new ArrayList<>();
        for (int indx = 0; indx < graphNodeList.size(); indx++) {
            if (matrix[nextNodeIndex][indx] == 1) {
                neighboursList.add(graphNodeList.get(indx));
            }
        }
        return neighboursList;
    }

    private void updateIsVisited() {
        graphNodeList.stream().map(node -> node.visited = false).toList();
    }

    public static void main(String[] args) {
        //testcase_A();
        testcase_directed_graph_dfs_bfs_topologicalsort();
    }

    private static void testcase_directed_graph_dfs_bfs_topologicalsort() {
        GraphNode graphNodeA = new GraphNode("A", 0);
        GraphNode graphNodeB = new GraphNode("B", 1);
        GraphNode graphNodeC = new GraphNode("C", 2);
        GraphNode graphNodeD = new GraphNode("D", 3);
        GraphNode graphNodeE = new GraphNode("E", 4);

        List<GraphNode> graphNodeList = new ArrayList<>();
        graphNodeList.add(graphNodeA);
        graphNodeList.add(graphNodeB);
        graphNodeList.add(graphNodeC);
        graphNodeList.add(graphNodeD);
        graphNodeList.add(graphNodeE);

        GraphAdjacentMatrix graphAdjacentMatrix = new GraphAdjacentMatrix(graphNodeList);


        graphAdjacentMatrix.addDirectedEdge(0, 1);
        graphAdjacentMatrix.addDirectedEdge(0, 2);
        graphAdjacentMatrix.addDirectedEdge(0, 3);
        graphAdjacentMatrix.addDirectedEdge(1, 4);
        graphAdjacentMatrix.addDirectedEdge(2, 3);
        graphAdjacentMatrix.addDirectedEdge(3, 4);

        System.out.println(graphAdjacentMatrix.toString());
        System.out.println(graphAdjacentMatrix.breathFirstTraversal());
        graphAdjacentMatrix.updateIsVisited();
        System.out.println(graphAdjacentMatrix.depthFirstTraversal());
        graphAdjacentMatrix.updateIsVisited();
        System.out.println(graphAdjacentMatrix.topologicalSort());
        graphAdjacentMatrix.updateIsVisited();
        System.out.println(graphAdjacentMatrix.bFS4SSSP(graphNodeA));
    }


    private String bFS4SSSP(GraphNode graphNode) {
        StringBuilder sb = new StringBuilder();
        Queue<GraphNode> queue = new LinkedList<>();
        queue.add(graphNode);
        sb.append("\n");
        while (!queue.isEmpty()) {
            GraphNode currentNode = queue.poll();
            if (!currentNode.visited) {
                currentNode.visited = true;
            }

            sb
                    .append("Printing path for node# ")
                    .append(currentNode.data)
                    .append(": ")
                    .append(printPathUsingStack(currentNode))
                    .append("\n");

            for (int index = 0; index < matrix.length; index++) {
                if (matrix[currentNode.index][index] == 1) {
                    GraphNode neighbourNode = graphNodeList.get(index);
                    if (!neighbourNode.visited) {
                        queue.add(neighbourNode);
                        neighbourNode.visited = true;
                        neighbourNode.parent = currentNode;
                    }
                }
            }
        }
        return sb.toString();
    }

    private String printPathUsingStack(GraphNode node) {
        Stack<GraphNode> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
      //  stack.add(node);
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

    private String topologicalSort() {
        StringBuilder sb = new StringBuilder();
        Deque<GraphNode> stack = new ArrayDeque<>();
        graphNodeList.forEach(node -> topologicalSort(node, stack));

        while (!stack.isEmpty()) {
            GraphNode node = stack.pop();
            if (!node.visited) {
                sb.append(node.data).append(" ");
                node.visited = true;
            }
        }
        return sb.toString();
    }

    private void topologicalSort(GraphNode node, Deque<GraphNode> stack) {
        if (!node.visited) {
            stack.push(node);
        }
        int currentNodeIndex = node.index;
        for (int index = 0; index < matrix.length; index++) {
            if (matrix[currentNodeIndex][index] == 1) {
                GraphNode neighbourNode = graphNodeList.get(index);
                if (!neighbourNode.visited) {
                    stack.push(neighbourNode);
                }
            }
        }
    }

    private static void testcase_UnDirectedEdges() {
        GraphNode graphNodeA = new GraphNode("A", 0);
        GraphNode graphNodeB = new GraphNode("B", 1);
        GraphNode graphNodeC = new GraphNode("C", 2);
        GraphNode graphNodeD = new GraphNode("D", 3);
        GraphNode graphNodeE = new GraphNode("E", 4);

        List<GraphNode> graphNodeList = new ArrayList<>();
        graphNodeList.add(graphNodeA);
        graphNodeList.add(graphNodeB);
        graphNodeList.add(graphNodeC);
        graphNodeList.add(graphNodeD);
        graphNodeList.add(graphNodeE);

        GraphAdjacentMatrix graphAdjacentMatrix = new GraphAdjacentMatrix(graphNodeList);


        graphAdjacentMatrix.addUndirectedEdge(0, 1);
        graphAdjacentMatrix.addUndirectedEdge(0, 2);
        graphAdjacentMatrix.addUndirectedEdge(0, 3);
        graphAdjacentMatrix.addUndirectedEdge(1, 4);
        graphAdjacentMatrix.addUndirectedEdge(2, 3);
        graphAdjacentMatrix.addUndirectedEdge(3, 4);

        System.out.println(graphAdjacentMatrix.toString());
        System.out.println(graphAdjacentMatrix.breathFirstTraversal());
        graphAdjacentMatrix.updateIsVisited();
        System.out.println(graphAdjacentMatrix.depthFirstTraversal());
        graphAdjacentMatrix.updateIsVisited();
    }


}
