package com.test.graph;

import java.util.ArrayList;
import java.util.List;

public class CycleInGraph {

    public static void main(String[] args) {
        testcase1();
        testcase2();
        testcase3();
    }

    private static void testcase3() {
        //"edges": [
        //    [1, 2],
        //    [2],
        //    [1]
        //  ]

        int[][] edges = {{1, 2},
                {2},
                {1}};

//        System.out.println(CycleInGraph.cycleInGraph(edges));
        System.out.println(CycleInGraph.isCycleInGraph(edges));
    }

    private static void testcase2() {
        //"edges": [
        //    [1, 2],
        //    [2],
        //    []
        //  ]
        int[][] edges = {{1, 2},
                {2},
                {}};

//        System.out.println(CycleInGraph.cycleInGraph(edges));
        System.out.println(CycleInGraph.isCycleInGraph(edges));
    }

    private static void testcase1() {
        int[][] edges = {{1, 3},
                {2, 3, 4},
                {0},
                {},
                {2, 5},
                {}};

//        System.out.println(CycleInGraph.cycleInGraph(edges));
        System.out.println(CycleInGraph.isCycleInGraph(edges));
    }

    public static boolean isCycleInGraph(int[][] edges) {
        boolean[] visited = new boolean[edges.length];
        boolean[] currentlyInStack = new boolean[edges.length];

        for (int idx = 0; idx < edges.length; idx++) {
            if (visited[idx])
                continue;

            boolean isNodeInCycle = isNodeInCycle(edges, idx, visited, currentlyInStack);
            if (isNodeInCycle)
                return true;
        }
        return false;
    }

    private static boolean isNodeInCycle(int[][] edges, int node, boolean[] visited, boolean[] currentlyInStack) {
        visited[node]  = currentlyInStack[node] = true;
        int[] currentNode = edges[node];
        for (int idx = 0; idx < currentNode.length; idx++) {
            boolean isNodeInCycle = false;
            if (!visited[currentNode[idx]]) {
                isNodeInCycle = isNodeInCycle(edges, currentNode[idx], visited, currentlyInStack);
            }
            if (isNodeInCycle || currentlyInStack[currentNode[idx]] ){
                return true;
            }
//            else if (currentlyInStack[currentNode[idx]]) {
//                return true;
//            }
        }
         currentlyInStack[node] = false;
        return false;
    }

    public static boolean cycleInGraph(int[][] edges) {
        // Write your code here.
        // Create an list of routes
        // Iterate over the routes and find the cycle
        List<List<Integer>> routes = new ArrayList<>();
        List<Integer> currentRoute = new ArrayList<>();
        routes.add(currentRoute);
        boolean[][] visitedEdges = getVisitedEdges(edges);
        return getRoutes(edges, routes, currentRoute, visitedEdges, 0, 0);
    }

    private static boolean[][] getVisitedEdges(int[][] edges) {
        boolean[][] visitedEdges = new boolean[edges.length][];
        for (int idx = 0; idx < edges.length; idx++) {
            boolean[] currentVisitedEdge = new boolean[edges[idx].length];
            visitedEdges[idx] = currentVisitedEdge;
        }
        return visitedEdges;
    }

    private static boolean getRoutes(int[][] edges,
                                     List<List<Integer>> routes,
                                     List<Integer> currentRoute,
                                     boolean[][] visitedEdges,
                                     int idx, int jdx) {
        // BC
//        if (idx == edges.length - 1 && jdx == edges[edges.length - 1].length-1)
        VisitedEdgeInfo visitedEdgeInfo = visitedAllEdges(visitedEdges);
        if (visitedEdgeInfo.isVisited)
            return false;
        // Hypo & Induction

        int currentValue;

        int nextRouteIndex = edges[edges.length - 1].length > 0 ? edges[edges.length - 1].length - 1 : 0;
//        int nextRouteIndex = visitedEdgeInfo.jdx; // TODO: fix here
        if (idx == edges.length - 1 && jdx == nextRouteIndex) {
            // Check if jdx+1 exists
            if (nextRouteIndex == 0) {
                if (visitedEdges[idx].length != 0 && visitedEdges[idx][jdx] && isCycle(currentRoute)) {
                    return true;
                }
            } else {
                currentValue = edges[idx][jdx + 1];
                currentRoute = new ArrayList<>();
                currentRoute.add(currentValue);
                routes.add(currentRoute);
            }

            if (visitedEdges[idx].length >= jdx + 1) {
                visitedEdges[idx][jdx] = true;
                return getRoutes(edges, routes, currentRoute, visitedEdges, idx, edges[idx][jdx + 1]);
            }
            return false; // TODO fix this, this should increment to next possible visitedEdges which is false

        } else {
            currentValue = edges[idx][jdx];
            currentRoute.add(currentValue);
            // Check 4 cycle
            if (visitedEdges[idx][jdx] && isCycle(currentRoute)) {
                return true;
            }
            visitedEdges[idx][jdx] = true;
            return getRoutes(edges, routes, currentRoute, visitedEdges, edges[idx][jdx], jdx);
        }
    }

    private static VisitedEdgeInfo visitedAllEdges(boolean[][] visitedEdges) {
        for (int idx = 0; idx < visitedEdges.length; idx++) {
            for (int jdx = 0; jdx < visitedEdges[idx].length; jdx++) {
                if (!visitedEdges[idx][jdx]) {
                    return new VisitedEdgeInfo(false, idx, jdx);
                }
            }
        }
        return new VisitedEdgeInfo(true,
                visitedEdges.length - 1,
                visitedEdges[visitedEdges.length - 1].length - 1);
    }


    private static boolean isCycle(List<Integer> currentRoute) {
        for (int idx = 0; idx < currentRoute.size(); idx++) {
            int currentValue = currentRoute.get(idx);
            for (int jdx = idx + 1; jdx < currentRoute.size(); jdx++) {
                if (currentValue == currentRoute.get(jdx))
                    return true;
            }
        }
        return false;
    }

    static class VisitedEdgeInfo {
        boolean isVisited;
        int idx;
        int jdx;

        public VisitedEdgeInfo(boolean isVisited, int idx, int jdx) {
            this.isVisited = isVisited;
            this.idx = idx;
            this.jdx = jdx;
        }
    }
}
