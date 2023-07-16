package com.sinuke.grokking.algorithms.chapter4;

import java.util.Arrays;

/**
 * Quick sort
 */
public class Main {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(quickSort(new int[]{10, 5, 2, 3, -1, 43, -143, 302})));
    }

    public static int[] quickSort(int[] arr) {
        if (arr.length < 2) {
            return arr;
        } else {
            int pivot = arr[0];
            int lessCount = 0;
            int greaterCount = 0;

            for (int i = 1; i < arr.length; i++) {
                if (arr[i] <= pivot) {
                    lessCount++;
                } else {
                    greaterCount++;
                }
            }

            int[] less = new int[lessCount];
            int[] greater = new int[greaterCount];

            int lessIndex = 0;
            int greaterIndex = 0;

            for (int i = 1; i < arr.length; i++) {
                if (arr[i] <= pivot) {
                    less[lessIndex] = arr[i];
                    lessIndex++;
                } else {
                    greater[greaterIndex] = arr[i];
                    greaterIndex++;
                }
            }

            int[] result = new int[arr.length];
            System.arraycopy(quickSort(less), 0, result, 0, less.length);
            result[less.length] = pivot;
            System.arraycopy(quickSort(greater), 0, result, less.length + 1, greater.length);
            return result;
        }
    }

}