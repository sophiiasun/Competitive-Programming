package S2018;

import java.util.*;

public class Q2_2 {
    static int N;
    static int[][] arr;
    static int[][] tmpA;
    public static void main(String[] args) {
        init();
        for (int i = 0; i < 4; i++) {
            rotate();
        }
        compare();
    }
    static void rotate() {
        for (int i = 0; i < N/2; i++) {
            for (int j = 0; j < N - 1 - i; j++) {
                int tmp = arr[i][j];
                arr[i][j] = arr[j][N - 1 - i];
                arr[j][N - 1 - i] = arr[N-1-i][N-1-j];
                arr[N-1-i][N-1-j] = arr[N-1-j][i];
                arr[N-1-j][i] = tmp;
            }
        }
    }
    static void compare() {
        boolean out = true;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] != tmpA[i][j])
                    out = false;
                break;
            }
        }
        if (out)
            System.out.println("rotate successful.");
        else
            System.out.println("rotate unsuccessful.");
    }
    static void init() {
        N = (int)Math.round(Math.random() * 100);
        tmpA = new int[N][N];
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                tmpA[r][c] = (int)Math.round(Math.random() * 1000000);
            }
        }
        arr = tmpA;
    }
}
