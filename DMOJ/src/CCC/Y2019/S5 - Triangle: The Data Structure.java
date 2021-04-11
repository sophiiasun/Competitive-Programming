package CCC.Y2019;

import java.util.*;

public class S19Q5_Triangle {
    static int[][] arr;
    static int N, K;
    static int rEnd;
    public static void main(String[] args) {
        init();
        run();
        out();
    }

    static void run() {
        int n = K - 1; // n is the number of times i need to shorten the array
        rEnd = N - 1;
        for (int i = 0; i < n; i++) {
            for (int r = 0; r < rEnd; r++) {
                for (int c = 0; c <= r; c++) {
                    arr[r][c] = Math.max(arr[r][c], Math.max(arr[r + 1][c], arr[r + 1][c + 1]));
                }
            }
        }
    }

    static void init() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        arr = new int[N][];
        for (int r = 0; r < N; r++) {
            arr[r] = new int[r + 1];
            for (int c = 0; c <= r; c++) {
                arr[r][c] = sc.nextInt();
            }
        }
    }

    static void out() {
        int out = 0;
        for (int r = 0; r < rEnd; r++) {
            for (int c = 0; c <= r; c++) {
                out += arr[r][c];
            }
        }
        System.out.println(out);
    }
}
