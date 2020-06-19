package DMOPC.Y2013;

import java.io.*;
import java.util.*;

public class DMOPC13_ARomanticDinner {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int M = readInt(), U = readInt(), R = readInt();
        R[] res = new R[R];
        for (int i = 0; i < R; i++) res[i] = new R(readInt(), readInt(), readInt());
        int[][] dp = new int[U+1][M+1];
        for (R r : res) {
            for (int u = U; u >= 0; u--) {
                for (int t = M; t >= 0; t--) {
                    if (u-r.f >= 0 && t-r.t >= 0)
                        dp[u][t] = Math.max(dp[u][t], dp[u-r.f][t-r.t] + r.v);
                }
            }
        }
        System.out.println(dp[U][M]);
    }

    static class R {
        int v, t, f;
        R (int pv, int pt, int pf) { v = pv; t = pt; f = pf; }
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
