package Alghorithms;

import java.util.*;

/* Array Permutation: Recursion
 * 1. Swap index i with every index >= i.
 * 2. Call recursion until index SIZE - 1 is reached.
 * 3. Print out Array.
 */

public class ArrayPermutation {

    static final int SIZE = 5;
    static int count = 0;

    public static void main(String[] args) {
        int[] arr = new int[SIZE];

        for (int i = 1; i <= SIZE; i++) { // Fill with random values
            arr[i-1] = i;
        }

        permutate(arr, 0);
        System.out.println(count);
    }

    static void permutate (int[] arr, int index) {
        if (index == SIZE - 1) {
            System.out.println(Arrays.toString(arr));
            count++; return;
        }
        for (int i = index; i < SIZE; i++) {
            int tmp = arr[index]; arr[index] = arr[i]; arr[i] = tmp;
            permutate(arr, index + 1);
            tmp = arr[index]; arr[index] = arr[i]; arr[i] = tmp;
        }
    }


}
