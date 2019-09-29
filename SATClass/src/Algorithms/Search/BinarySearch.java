package Algorithms.Search;

import java.util.*;

public class BinarySearch {

    private static int T;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); //N = number of elements
        T = sc.nextInt(); //T = target
        int[] arr = new int[N];
        for (int i = 0; i < N; i++)
            arr[i] = sc.nextInt();
        Arrays.sort(arr);
        int iMax = N - 1;
        int iMin = 0;
        int out = doBinarySearch(arr, iMax, iMin);
        if (out == -1)
            System.out.println("Not Found.");
        else {
            System.out.println("Found. Position (after sort): " + (out + 1));
        }
    }

    private static int doBinarySearch (int[] arr, int iMax, int iMin) {
        int iMid = (iMax + iMin) / 2;
        if (arr[iMid] == T) {
            return iMid;
        } else if (arr[iMid] > T) {
            return doBinarySearch (arr, iMid, iMin);
        } else if (arr[iMid] < T) {
            return doBinarySearch (arr, iMax, iMid);
        }
        return -1;
    }


}
