package com.sinuke.grokking.algorithms.chapter1;

/**
 * Binary search
 */
public class Main {

    public static void main(String[] args) {

        int[] arr = {1, 4, 6, 9, 12, 54, 424, 568, 3452, 6753, 34124, 234642};
        System.out.println(binarySearch(arr, 34124));
        System.out.println(binarySearch(arr, 234));
    }

    private static int binarySearch(int[] arr, int value) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int guess = arr[mid];
            if (guess == value) {
                return mid;
            } else if (guess > value) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }

}