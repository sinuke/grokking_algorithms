package com.sinuke.grokking.algorithms.chapter3;

/**
 * Factorial
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("25! = " + fact(25));
    }

    private static int fact(int i) {
        if (i == 1) {
            return i;
        } else {
            return i * fact(i - 1);
        }
    }

}
