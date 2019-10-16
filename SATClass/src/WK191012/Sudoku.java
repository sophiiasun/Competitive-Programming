package WK191012;

import java.util.*;

public class Sudoku {
    static int[][] arr = new int[9][9];
    static int[] cntR = new int[9];
    static int[] cntC = new int[9];
    static int[][] cntB = new int[3][3];
    static int[] sumR = new int[9];
    static int[] sumC = new int[9];
    static int[][] sumB = new int[3][3];
    static int cnt = 0;

    static boolean debug = true;
    static void log(Object o) {
        if (debug)
            System.out.println(o.toString());
    }

    public static void main(String[] args) {
        init();
        run(0, 0);

    }
    static void print() {
        for(int i = 0; i < 9; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
    }
    static void run(int r, int c) {
        log("run");
        chkFill();
        if (cnt == 0) {
            print();
            System.exit(0);
        }
        if (arr[r][c] != 0) {
            if (c + 1 < 9) run(r, c + 1);
            else run(r + 1, 0);
        } else {
            boolean[] aB = getOne(r, c);
            for (int i = 1; i < 10; i++) {
                log("37");
                if (aB[i]) {
                    arr[r][c] = i;
                    addOne(r, c, i);
                    if (c + 1 < 9) run(r, c + 1);
                    else if (r + 1 < 9) run(r + 1, 0);
                    else {
                        print();
                        System.exit(0);
                    }
                    arr[r][c] = 0; cnt++;
                    cntR[r]--; cntC[c]--; cntB[r / 3][c / 3]--;
                    sumR[r] -= i; sumC[c] -= i; sumB[r / 3][c / 3] -= i;
                }
            }
        }
    }
    static boolean[] getOne(int r, int c) {
        boolean[] aR = new boolean[10]; //default false; set to true if number is found
        boolean[] aC = new boolean[10];
        boolean[] aB = new boolean[10];
        boolean[] aRet = new boolean[10];
        int tmpR = (r/3) * 3;
        int tmpC = (c/3) * 3;
        for (int i = 0; i < 9; i++) {
            if (arr[r][i] >= 1) aR[arr[r][i]] = true;
            if (arr[i][c] >= 1) aR[arr[r][i]] = true;
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 0 && j == 0) continue;
                else {
                    if (arr[tmpR + i][tmpC + j] >= 1) aB[arr[tmpR + i][tmpC + j]] = true;
                }
            }
        }
        for(int i = 1; i <= 9; i++) {
            if (!aR[i] && !aC[i] && !aB[i]) aRet[i] = true; // returned arr[] has true for each not found number
        }
        return aRet;
    }
    static void chkFill() {
        int tmpC;
        do {
            tmpC = cnt;
            System.out.println("78");
            for (int r=0; r<9; r++) {
                for(int c=0; c<9; c++) {
                    if (arr[r][c] == 0) {
                        if (cntR[r] == 8) {
                            arr[r][c] = 45 - sumR[r];
                            addOne(r, c, 45 - sumR[r]);
                        } else if (cntC[c] == 8) {
                            arr[r][c] = 45 - sumC[c];
                            addOne(r, c, 45 - sumC[c]);
                        } else if (cntB[r/3][c/3] == 8) {
                            arr[r][c] = 45 - sumB[r/3][c/3];
                            addOne(r, c, 45 - sumB[r/3][c/3]);
                        }
                    }
                }
            }
        } while (tmpC != cnt);
    }
    static void addOne(int r, int c, int add) {
        cnt--; cntR[r]++; cntC[c]++; cntB[r/3][c/3]++; sumR[r] += add; sumC[c] += add; sumB[r/3][c/3] += add;
    }
    static void init() {
        Scanner sc = new Scanner(System.in);
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                int tmp = sc.nextInt();
                arr[r][c] = tmp;
                if (tmp >= 1) {
                    cntR[r]++;
                    cntC[c]++;
                    cntB[r/3][c/3]++;
                    sumR[r] += tmp;
                    sumC[c] += tmp;
                    sumB[r/3][c/3] += tmp;
                } else cnt++;
            }
        }
    }
}