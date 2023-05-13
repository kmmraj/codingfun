package com.test.graph;

import org.jetbrains.annotations.NotNull;

public class UnDirectedEdge implements Comparable<UnDirectedEdge> {
    WeightedGraph.WeightedNode first;
    WeightedGraph.WeightedNode second;

    int weight;

    public UnDirectedEdge(WeightedGraph.WeightedNode first, WeightedGraph.WeightedNode second, int weight) {
        this.first = first;
        this.second = second;
        this.weight = weight;
    }

    @Override
    public String toString(){
        return "Edge ( "+ first.data + " , " + second.data + " ) : " + weight;
    }

    @Override
    public int compareTo(@NotNull UnDirectedEdge o) {
        return this.weight - o.weight;
    }
}
