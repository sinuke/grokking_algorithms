package com.sinapps.main;

import java.util.*;

public class Main {

    public static void main(String[] args) {
	    Map<Person, Person[]> graph = new HashMap<>();

	    Person you = new Person("you", false);
	    Person alice = new Person("alice", false);
	    Person bob = new Person("bob", false);
	    Person claire = new Person("claire", false);
	    Person anuj = new Person("anuj", false);
	    Person peggy = new Person("peggy", true);
	    Person thom = new Person("thom", false);
	    Person jonny = new Person("jonny", false);

	    graph.put(you, new Person[] {alice, bob, claire});
	    graph.put(bob, new Person[] {anuj, peggy});
	    graph.put(alice, new Person[] {peggy});
	    graph.put(claire, new Person[] {thom, jonny});
	    graph.put(anuj, new Person[] {});
	    graph.put(peggy, new Person[] {});
	    graph.put(thom, new Person[] {});
	    graph.put(jonny, new Person[] {});

        Deque<Person> search_queue = new ArrayDeque<>();
        Collections.addAll(search_queue, graph.get(you));

        List<Person> searched = new ArrayList<>();

        while (!search_queue.isEmpty()) {
            Person person = search_queue.pop();
            if (!searched.contains(person)) {
				if (person.isSeller()) {
					System.out.println(person.getName() + " is mango seller!");
					break;
				} else {
					Collections.addAll(search_queue, graph.get(person));
					searched.add(person);
				}
			}
        }
    }
}
