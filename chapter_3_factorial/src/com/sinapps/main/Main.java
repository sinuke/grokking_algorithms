package com.sinapps.main;

public class Main {

    public static void main(String[] args) {
        System.out.println("25! = " + fact(25));
    }

    public static int fact(int i) {
        if (i == 1) {
            return i;
        } else {
            return i * fact(i - 1);
        }
    }
}
