package com.sinapps.main;

import java.util.*;

public class Main {
    public static final int INFINITY = Integer.MAX_VALUE;
    private static final List<String> processed = new ArrayList<>();

    public static void main(String[] args) {
        Map<String, Integer> graphStart = new HashMap<>();
        graphStart.put("a", 6);
        graphStart.put("b", 2);

        Map<String, Map<String, Integer>> graph = new HashMap<>();
        graph.put("start", graphStart);

        Map<String, Integer> graphA = new HashMap<>();
        graphA.put("fin", 1);
        graph.put("a", graphA);

        Map<String, Integer> graphB = new HashMap<>();
        graphB.put("a", 3);
        graphB.put("fin", 5);
        graph.put("b", graphB);

        Map<String, Integer> graphFin = new HashMap<>();
        graph.put("fin", graphFin);

        Map<String, Integer> costs = new HashMap<>();
        costs.put("a", 6);
        costs.put("b", 2);
        costs.put("fin", INFINITY);

        Map<String, String> parents = new HashMap<>();
        parents.put("a", "start");
        parents.put("b", "start");
        parents.put("fin", null);

        String node = findLowestCostNode(costs);
        while (node != null) {
            int cost = costs.get(node);
            Map<String, Integer> neighbors = graph.get(node);
            for (String n : neighbors.keySet()) {
                int newCost = cost + neighbors.get(n);
                if (costs.get(n) > newCost) {
                    costs.replace(n, newCost);
                    parents.replace(n, node);
                }
            }
            processed.add(node);
            node = findLowestCostNode(costs);
        }

        System.out.println(processed);
        System.out.println(parents);
        System.out.println(costs);
    }

    private static String findLowestCostNode(Map<String, Integer> costs) {
        int lowestCost = INFINITY;
        String lowestCostNode = null;
        for (String node : costs.keySet()) {
            int cost = costs.get(node);
            if (cost < lowestCost && !processed.contains(node)) {
                lowestCost = cost;
                lowestCostNode = node;
            }
        }
        return lowestCostNode;
    }
}
