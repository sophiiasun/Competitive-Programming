package GFSSOC;

import java.util.*;
import java.io.*;

public class StardustSnow {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    static int R, C, S, B, K, M, dp[][][][];
//    static C a[][]; a[readInt()][readInt()] = new C(t, v);
     static ArrayList<C>[] adj;

    public static void main(String[] args) throws IOException {
        R = readInt(); C = readInt(); S = readInt(); B = readInt(); K = readInt(); M = readInt();
        dp = new int[C+1][R+1][K+1][B+1]; /*a = new C[R+1][C+1];*/ adj = new ArrayList[R+1];
        for (int i = 1; i <= R; i++) adj[i] = new ArrayList<>();
        for (int i = 0, t, v; i < S; i++) { t = readInt(); v = readInt(); adj[readInt()].add(new C(readInt(), t, v));  }
        for (int i = 1; i <= R; i++) for (int j = 0; j <= C; j++) for (int k = 0; k <= K; k++) Arrays.fill(dp[i][j][k], -1);
        run(1, 1, 0, 0);
    }

    static int run(int p, int h, int k, int t) {
        if (dp[p][h][k][t] != -1) return dp[p][h][k][t];
        int ret = 0;
        for (C c : adj[h]) {
            if (Math.abs(p-c.p) <= M) {

            }
        }

        for (int i = Math.max(0, -M); i <= M; i++) {
            ret = Math.max(ret, run(p+i, h+1, k, t)); // don't take cur
            ret = Math.max(ret, run(p+i, h+1, k+)); // take cur
        }
        return dp[p][h][k][t] = ret;
    }

//    static class C {
//        int t, v;
//        C (int tt, int vv) { t = tt; v = vv; }
//    }

    static class C {
        int p, t, v;
        C (int pp, int tt, int vv) { p = pp; t = tt; v = vv; }
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
