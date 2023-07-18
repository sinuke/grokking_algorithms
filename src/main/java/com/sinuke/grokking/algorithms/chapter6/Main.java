package com.sinuke.grokking.algorithms.chapter6;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Breadth first search
 */
public class Main {

    public static void main(String[] args) {
        Person you = new Person("you", false);
        Person alice = new Person("alice", false);
        Person bob = new Person("bob", false);
        Person claire = new Person("claire", false);
        Person anuj = new Person("anuj", false);
        Person peggy = new Person("peggy", true);
        Person thom = new Person("thom", false);
        Person jonny = new Person("jonny", false);

        Map<Person, Person[]> graph = new HashMap<>();
        graph.put(you, new Person[] {alice, bob, claire});
        graph.put(bob, new Person[] {anuj, peggy});
        graph.put(alice, new Person[] {peggy});
        graph.put(claire, new Person[] {thom, jonny});
        graph.put(anuj, new Person[] {});
        graph.put(peggy, new Person[] {});
        graph.put(thom, new Person[] {});
        graph.put(jonny, new Person[] {});

        Deque<Person> searchQueue = new ArrayDeque<>();
        Collections.addAll(searchQueue, graph.get(you));

        List<Person> searched = new ArrayList<>();

        while (!searchQueue.isEmpty()) {
            Person person = searchQueue.pop();
            if (!searched.contains(person)) {
                if (person.seller()) {
                    System.out.println(person.name() + " is mango seller!");
                    break;
                } else {
                    Collections.addAll(searchQueue, graph.get(person));
                    searched.add(person);
                }
            }
        }
    }

}
