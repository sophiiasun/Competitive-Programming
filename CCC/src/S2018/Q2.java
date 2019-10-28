package S2018;

import java.util.*;

public class Q2 {
    static int N;
    static int[][] arr;
    public static void main(String[] args) {
        init();
        run();
        out();
    }

    static void run() {
        while (!chk()) {
            for (int i = 0; i < N/2; i++) {
                for (int j = i; j < N - 1 - i; j++) {
                    int tmp = arr[i][j];
                    arr[i][j] = arr[j][N - 1 - i];
                    arr[j][N - 1 - i] = arr[N - 1 - i][N - 1 - j];
                    arr[N - 1 - i][N - 1 - j] = arr[N - 1 - j][i];
                    arr[N - 1 - j][i] = tmp;
                }
            }
        }
    }

    static void out() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            if (i > 0)
                sb.append('\n');
            for (int j = 0; j < N; j++) {
                if (j > 0)
                    sb.append(' ');
                sb.append(arr[i][j]);
            }
        }
        System.out.println(sb);
    }

    static boolean chk() {
        for (int i = 0; i < N - 1; i++) {
            if (arr[0][i] >= arr[0][i + 1])
                return false;
            if (arr[i][0] >= arr[i + 1][0])
                return false;
        }
        return true;
    }

    static void init() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
    }
}
