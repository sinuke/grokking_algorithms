package com.sinuke.grokking.algorithms.chapter8;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Approximate algorithm
 */
public class Main {

    public static void main(String[] args) {
        Set<String> statesNeeded = new HashSet<>();
        statesNeeded.add("mt");
        statesNeeded.add("wa");
        statesNeeded.add("or");
        statesNeeded.add("id");
        statesNeeded.add("nv");
        statesNeeded.add("ut");
        statesNeeded.add("ca");
        statesNeeded.add("az");

        Set<String> statesKOne = Set.of("id", "nv", "ut");
        Set<String> statesKTwo = Set.of("wa", "id", "mt");
        Set<String> statesKThree = Set.of("or", "nv", "ca");
        Set<String> statesKFour = Set.of("nv", "ut");
        Set<String> statesKFive = Set.of("ca", "az");

        Map<String, Set<String>> stations = Map.of(
                "kone", statesKOne,
                "ktwo", statesKTwo,
                "kthree", statesKThree,
                "kfour", statesKFour,
                "kfive", statesKFive
        );

        Set<String> finalStations = new HashSet<>();

        while (!statesNeeded.isEmpty()) {
            String bestStation = null;
            Set<String> statesCovered = new HashSet<>();

            for (var key : stations.keySet()) {
                Set<String> covered = new HashSet<>(statesNeeded);
                covered.retainAll(stations.get(key));

                if (covered.size() > statesCovered.size()) {
                    bestStation = key;
                    statesCovered = covered;
                }
            }

            statesNeeded.removeAll(statesCovered);
            finalStations.add(bestStation);
        }

        System.out.println(finalStations);
    }

}
