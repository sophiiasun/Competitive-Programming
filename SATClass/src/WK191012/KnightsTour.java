package WK191012;

import java.util.*;

public class KnightsTour {
    static int[][] arr = new int[8][8];
    static int[] aR = {1, 2, 2, 1, -1, -2, -2, -1};
    static int[] aC = {2, 1, -1, -2, -2, -1, 1, 2};

    public static void main(String[] args) {
        init();
        run(0, 0, 1);
    }

    static void run(int ir, int ic, int in) {
        if (in == 64) {
            out();
            System.exit(0);
        }
        int nc = 0, nr = 0;
        for (int i = 0; i < 8; i++) {
            nr = ir + aR[i];
            nc = ic + aC[i];
            if (nc < 0 || nr < 0 || nc > 7 || nr > 7) {
                continue;
            } else if (arr[nr][nc] != -1) {
                continue;
            } else {
                arr[nr][nc] = in;
                run(nr, nc, in + 1);
                arr[nr][nc] = -1;
            }
        }
    }

    static void out() {
        StringBuilder sb = new StringBuilder();
        for (int r = 0; r < 8; r++) {
            for (int c = 0; c < 8; c++) {
                if (c != 0)
                    sb.append(" ");
                sb.append(arr[r][c]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void init() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                arr[i][j] = -1;
            }
        }
        arr[0][0] = 0;
    }
}
