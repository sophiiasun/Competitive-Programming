package WK191005;

import java.util.*;

public class DiamondCollector {
    private static Scanner sc = new Scanner(System.in);
    private static int N;
    private static int K;
    private static int[] arr;

    public static void main(String[] args) {
        N = sc.nextInt();
        K = sc.nextInt();
        arr = new int[N];
        for(int i = 0; i < N; i++) arr[i] = sc.nextInt();
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        twoCase();
    }

    private static void oneCase() {
        int[] data = new int[N];
        for (int i = 0; i < N; i++) {
            int mrk = i + 1;
            int cnt = 1;
            while (mrk < N) {
                if (arr[mrk] - arr[i] <= K)
                    cnt++;
                else break;
                mrk++;
            }
            data[i] = cnt;
        }
        int max = 0;
        for (int i = 0; i < N; i++) {
            if (data[i] > max) max = data[i];
        }
        System.out.println(max); // 1 1 3 4 6
    }

    private static void twoCase() {
        int max = 0;
        int[] scan1 = new int[N];
        int[] scan2 = new int[N];
        for (int i = 1; i < N - 1; i++) { // i is the beginning index of the second half
            int cnt = 0;
            for (int j = i - 1; j >= 0; j--) { // check for i-1 as the largest value
                if (arr[i - 1] - arr[j] <= K) cnt++;
                else {
                    scan1[i - 1] = cnt;
                    break;
                }
            }
            cnt = 0;
            for (int j = i; j < N; j++) { //check for i as the smallest value
                if (arr[j] - arr[i] <= K) cnt++;
                else {
                    scan2[i] = cnt;
                    break;
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for(int j = i + 1; j < N; j++) {
                if (i + 1 > max) max = i + j;
            }
        }
        System.out.println(max);
    }
}