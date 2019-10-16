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
    public static void main(String[] args) {
        init();
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                chkFill(r, c);
                if (arr[r][c] == 0) run(r, c);
            }
        }
    }

    static void run(int r, int c) {
        if (arr[r][c] != 0) return;
        else {
            
        }
    }

    static void chkFill(int R, int C) {
        int tmpC = cnt;
        do {
            for (int r=0; r<9; r++) {
                for(int c=0; c<9; c++) {
                    if (arr[r][c] == 0) {
                        if (cntR[r] == 8) {
                            arr[r][c] = 45 - sumR[r];
                            tmpC++;
                        } else if (cntC[c] == 8) {
                            arr[r][c] = 45 - sumC[c];
                            tmpC++;
                        } else if (cntB[r/3][c/3] == 8) {
                            arr[r][c] = 45 - sumB[r/3][c/3];
                            tmpC++;
                        }
                    }
                }
            }
        } while (tmpC != cnt);
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
