package WK191005;

import java.util.*;

public class DiamondCollector {
    private static Scanner sc = new Scanner(System.in);
    private static int N;
    private static int K;
    private static int[] arr;
    public static void main(String[] args) {
        arr = new int[N];
        for (int i = 0; i < N; i++) arr[i] = sc.nextInt();
        Arrays.sort(arr);
        N = sc.nextInt();
        K = sc.nextInt();
        System.out.println ("How many cases?");
        int in = sc.nextInt();
        if (in == 1) oneCase();
        else if (in == 2) twoCase();
        else System.out.println("Error. Please re-run.");
    }

    private static void twoCase() {
        int[] data = new int[N];
        int mrk = 0;
        for (int i = 0; i < N; i++) {
            mrk = i + 1;
            int cnt = 1;
            while (mrk < N) {
                if (arr[mrk] - arr[i] <= K)
                    cnt++;
                else break; //mrk reaches the closet but unavailable int
                mrk++;
            }
            data[i] = cnt;
        }
        int max = 0, mrk2 = 0; //mrk2 stores the starting position of the largest sub-arr
        for (int i = 0; i < N; i++)
            if (data[i] > max) {
                max = data[i];
                mrk2 = i;
            }
        for (int i = 0; i < mrk; i++) {
            
        }
        for (int i = 0; i < mrk2; i++) {

        }
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
}
