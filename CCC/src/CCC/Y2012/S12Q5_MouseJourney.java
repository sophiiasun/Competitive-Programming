package CCC.Y2012;

import java.util.*;

public class S12Q5_MouseJourney {
    static int[][] arr;
    static int R, C;

    public static void main(String[] args) {
        init();
        System.out.println(run());
    }

    static int run() {
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (r == 0 && c == 0)
                    arr[r][c] = 1;
                else if (arr[r][c] != -1){
                    if (safe(r, c - 1))
                        arr[r][c] += arr[r][c - 1];
                    if (safe(r - 1, c))
                        arr[r][c] += arr[r - 1][c];
                    if (r == R-1 && c == C-1)
                        return arr[r][c];
                }
            }
        }
        return -1;
    }

    static boolean safe(int r, int c) {
        return (r >= 0 && c >= 0 && r < R && c < C && arr[r][c] != -1);
    }

    static void init() {
        Scanner sc = new Scanner(System.in);
        R = sc.nextInt();
        C = sc.nextInt();
        arr = new int[R][C];
        int x = sc.nextInt();
        for (int i = 0; i < x; i++)
            arr[sc.nextInt() - 1][sc.nextInt() - 1] = -1;
    }
}
