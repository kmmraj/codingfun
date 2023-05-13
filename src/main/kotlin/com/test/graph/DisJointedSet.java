package com.test.graph;

import java.util.ArrayList;
import java.util.List;

public class DisJointedSet {
    List<WeightedGraph.WeightedNode> weightedNodeList = new ArrayList<>();

    public static void makeSet(List<WeightedGraph.WeightedNode> weightedNodeList) {
        for (WeightedGraph.WeightedNode weightedNode : weightedNodeList) {
            DisJointedSet disJointedSet = new DisJointedSet();
            disJointedSet.weightedNodeList.add(weightedNode);
            weightedNode.disJointedSet = disJointedSet;
        }
    }

    public static DisJointedSet findSet(WeightedGraph.WeightedNode weightedNode) {
        return weightedNode.disJointedSet;
    }

    public static DisJointedSet union(WeightedGraph.WeightedNode first, WeightedGraph.WeightedNode second) {
        if (first.disJointedSet.equals(second.disJointedSet)) {
            return null;
        }

        DisJointedSet firstSet = first.disJointedSet;
        DisJointedSet secondSet = second.disJointedSet;

        if (firstSet.weightedNodeList.size() > secondSet.weightedNodeList.size()) {
            for (WeightedGraph.WeightedNode weightedNode : secondSet.weightedNodeList) {
                weightedNode.disJointedSet = firstSet;
                firstSet.weightedNodeList.add(weightedNode);
            }
            return firstSet;
        } else {
            for (WeightedGraph.WeightedNode weightedNode : firstSet.weightedNodeList) {
                weightedNode.disJointedSet = secondSet;
                secondSet.weightedNodeList.add(weightedNode);
            }
            return secondSet;
        }
    }

}
