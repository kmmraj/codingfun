package com.test.hashing;

import java.util.TreeMap;


public class HashRing {
    private final TreeMap<Integer, String> nodes = new TreeMap<>();
    private static final int NUM_REPLICAS = 3; // Number of replicas per node

    // Add a node to the hash ring
    public void addNode(String node) {
        for (int i = 0; i < NUM_REPLICAS; i++) {
            int hash = computeHash(node + i); // Compute hash for each replica
            nodes.put(hash, node);
        }
    }

    // Remove a node from the hash ring
    public void removeNode(String node) {
        for (int i = 0; i < NUM_REPLICAS; i++) {
            int hash = computeHash(node + i);
            nodes.remove(hash);
        }
    }

    // Get the node responsible for storing the data
    public String getNode(String dataKey) {
        int dataHash = computeHash(dataKey);
        Integer nodeHash = nodes.ceilingKey(dataHash); // Find the node hash greater than or equal to dataHash
        if (nodeHash == null) {
            // Wrap around to the first node if dataHash is greater than the largest node hash
            nodeHash = nodes.firstKey();
        }
        return nodes.get(nodeHash);
    }

    // Dummy hash function for illustration purposes
    private int computeHash(String key) {
        return key.hashCode() % 360; // 360 is used as the ring size in this example
    }

    public static void main(String[] args) {
        HashRing hashRing = new HashRing();
        hashRing.addNode("NodeA");
        hashRing.addNode("NodeB");
        hashRing.addNode("NodeC");

        String dataKey = "DataKey1";
        String dataNode = hashRing.getNode(dataKey);
        System.out.println("Data " + dataKey + " is assigned to " + dataNode);

        String dataKey2 = "383755iiyeyyeDataKey2";
        String dataNode2 = hashRing.getNode(dataKey2);
        System.out.println("Data " + dataKey2 + " is assigned to " + dataNode2);

        String dataKey3 = "D**&D73773737373737465454tedfdfdfdf3344sddsdssxsx55HDHDHDHDHataKey3";
        String dataNode3 = hashRing.getNode(dataKey3);
        System.out.println("Data " + dataKey3 + " is assigned to " + dataNode3);

        String dataKey4 = "973366DataKey4";
        String dataNode4 = hashRing.getNode(dataKey4);
        System.out.println("Data " + dataKey4 + " is assigned to " + dataNode4);

        String dataKey5 = "abaefefefefe63636633hhhdhdhdhhdhdhdUUUUUEUEUEUEUEUEUEUUEHDHDHDHDHDHDHDH";
        String dataNode5 = hashRing.getNode(dataKey5);
        System.out.println("Data " + dataKey5 + " is assigned to " + dataNode5);


        hashRing.removeNode("NodeB");
        dataNode5 = hashRing.getNode(dataKey5);
        System.out.println("Data " + dataKey5 + " is assigned to " + dataNode5);


    }
}

