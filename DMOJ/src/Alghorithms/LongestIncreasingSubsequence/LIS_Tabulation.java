package Alghorithms.LongestIncreasingSubsequence;

import java.nio.Buffer;
import java.util.*;

public class LIS_Tabulation {
    static int[] arr, count;
    static int MAX;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        arr = new int[N];
        for (int i = 0; i < N; i++)
            arr[i] = sc.nextInt();
        count = new int[N];
        count[0] = 1;
        MAX = 1;
        count[N-1] = getMax(N - 1);
        System.out.println(MAX);
    }

    static int getMax(int curr) { //curr is index of current position
        int max = 0;
        int tmp = 0;

        for (int i = curr-1; i >= 0; i--) {
            if (count[i] == 0) //fill any empty slot
                count[i] = getMax(i);
            if (tmp < arr[i]) { //compare with current value
                tmp = arr[i];
                if (count[i] > max)
                    max = count[i];
            }
        }

//        for (int i = 0; i < curr; i++) {
//            if (count[i] == 0) //fill any empty slot
//                count[i] = getMax(i);
//            if (arr[i] < arr[curr]) { //compare with current value
//                if (tmp < arr[i])
//                    tmp = arr[i];
//                if (count[i] > max)
//                    max = count[i];
//            }
//        }

        max++;
        if (max > MAX)
            MAX = max;
        return max;
    }
}
