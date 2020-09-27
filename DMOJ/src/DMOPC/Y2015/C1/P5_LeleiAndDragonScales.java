package DMOPC.Y2015.C1;

import java.io.*;
import java.util.*;

public class P5_LeleiAndDragonScales {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int W = readInt(), H = readInt(), N = readInt(), b, ans = 0, psa[][] = new int[H+1][W+1];
        for (int r = 1; r <= H; r++) { // 2-D psa
            for (int c = 1; c <= W; c++) {
                psa[r][c] = readInt() + psa[r-1][c] + psa[r][c-1] - psa[r-1][c-1];
                for (int a = 1; a <= r; a++) {
                    b = Math.min(c, N / a);
                    ans = Math.max(ans, psa[r][c] - psa[r-a][c] - psa[r][c-b] + psa[r-a][c-b]);
                }
            }
        }
        System.out.println(ans);
    }

    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens())
            st = new StringTokenizer(br.readLine().trim());
        return st.nextToken();
    }
    static int readInt () throws IOException {
        return Integer.parseInt(next());
    }
}
