package com.sinapps.main;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] arr = {5, 3, 6, 2, 10};
        System.out.println(Arrays.toString(selectionSort(arr)));
    }

    public static int[] selectionSort(int[] arr) {
        int[] newArr = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            int smallestIndex = findSmallest(arr);
            newArr[i] = arr[smallestIndex];

            // Т.к. в Java нет array.pop, то нужно массив преобразовать так, чтобы в нем не оказалось наименьшего элемента
            if (arr.length - 1 - smallestIndex >= 0)
                System.arraycopy(arr, smallestIndex + 1, arr, smallestIndex, arr.length - 1 - smallestIndex);
        }

        return newArr;
    }

    public static int findSmallest(int[] arr) {
        int smallest = arr[0];
        int smallestIndex = 0;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < smallest) {
                smallest = arr[i];
                smallestIndex = i;
            }
        }

        return smallestIndex;
    }
}
