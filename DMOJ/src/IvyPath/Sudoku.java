package IvyPath;

import java.util.*;

public class Sudoku {
    static int[][] arr = new int[9][9];
    static int cnt = 0;
    static long s;
    public static void main(String[] args) {
        init();
        s = System.currentTimeMillis();
        run(0, 0);
    }
    static void print() {
        for(int i = 0; i < 9; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
        System.out.println("--------------------------------------------");
        long e = System.currentTimeMillis();
        System.out.println("Time (ms): " + (e - s));
        System.out.println("============================================");
        System.exit(0);
    }
    static void run(int r, int c) {
        if (cnt == 0) print();
        if (arr[r][c] != 0) check(r, c);
        else {
            boolean[] aB = fillVal(r, c);
            for (int i = 1; i < 10; i++) {
                if (aB[i]) continue;
                arr[r][c] = i; cnt--;
                check(r, c);
                arr[r][c] = 0; cnt++;
            }
        }
    }

    static void check (int r, int c) {
        if (c + 1 < 9) run(r, c + 1);
        else if (r + 1 < 9) run(r + 1, 0);
        else print();
    }

    static boolean[] fillVal(int r, int c) {
        boolean[] aRet = new boolean[10];
        int R = (r/3) * 3, C = (c/3) * 3;
        for (int i = 0; i < 9; i++) {
            if (arr[r][i] >= 1) aRet[arr[r][i]] = true;
            if (arr[i][c] >= 1) aRet[arr[i][c]] = true;
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (arr[R + i][C + j] >= 1) aRet[arr[R + i][C + j]] = true;
            }
        }
        return aRet;
    }

    static void init() {
        Scanner sc = new Scanner(System.in);
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                arr[r][c] = sc.nextInt();
                cnt++;
            }
        }
    }
}