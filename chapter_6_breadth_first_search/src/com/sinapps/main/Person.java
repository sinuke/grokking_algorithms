package com.sinapps.main;

public class Person {
    private final String name;
    private final boolean seller;

    public Person(String name, boolean seller) {
        this.name = name;
        this.seller = seller;
    }

    public String getName() {
        return name;
    }

    public boolean isSeller() {
        return seller;
    }
}
