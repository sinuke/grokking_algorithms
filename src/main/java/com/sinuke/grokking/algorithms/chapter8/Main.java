package com.sinuke.grokking.algorithms.chapter8;

import java.util.HashMap;
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

        Set<String> statesKOne = new HashSet<>();
        statesKOne.add("id");
        statesKOne.add("nv");
        statesKOne.add("ut");

        Set<String> statesKTwo = new HashSet<>();
        statesKTwo.add("wa");
        statesKTwo.add("id");
        statesKTwo.add("mt");

        Set<String> statesKThree = new HashSet<>();
        statesKThree.add("or");
        statesKThree.add("nv");
        statesKThree.add("ca");

        Set<String> statesKFour = new HashSet<>();
        statesKFour.add("nv");
        statesKFour.add("ut");

        Set<String> statesKFive = new HashSet<>();
        statesKFive.add("ca");
        statesKFive.add("az");

        Map<String, Set<String>> stations = new HashMap<>();
        stations.put("kone", statesKOne);
        stations.put("ktwo", statesKTwo);
        stations.put("kthree", statesKThree);
        stations.put("kfour", statesKFour);
        stations.put("kfive", statesKFive);

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
