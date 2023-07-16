package com.sinuke.grokking.algorithms.chapter8;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Approximate algorithm
 */
public class Main {

    public static void main(String[] args) {
        Set<String> states_needed = new HashSet<>();
        states_needed.add("mt");
        states_needed.add("wa");
        states_needed.add("or");
        states_needed.add("id");
        states_needed.add("nv");
        states_needed.add("ut");
        states_needed.add("ca");
        states_needed.add("az");

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

        Set<String> final_stations = new HashSet<>();

        while (!states_needed.isEmpty()) {
            String best_station = null;
            Set<String> states_covered = new HashSet<>();

            for (String key : stations.keySet()) {
                Set<String> covered = new HashSet<>(states_needed);
                covered.retainAll(stations.get(key));

                if (covered.size() > states_covered.size()) {
                    best_station = key;
                    states_covered = covered;
                }
            }

            states_needed.removeAll(states_covered);
            final_stations.add(best_station);
        }

        System.out.println(final_stations);
    }

}
