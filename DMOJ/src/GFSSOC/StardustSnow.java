package GFSSOC;

import java.util.*;
import java.io.*;

public class StardustSnow {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    static int R, C, S, B, K, M, dp[][][][];
    static ArrayList<C>[] adj;

    public static void main(String[] args) throws IOException {
        R = readInt(); C = readInt(); S = readInt(); B = readInt(); K = readInt(); M = readInt();
        dp = new int[C+1][R+1][K+1][B+1]; adj = new ArrayList[R+1];
        for (int i = 1; i <= R; i++) adj[i] = new ArrayList<>();
        for (int i = 0, t, v, c; i < S; i++) { t = readInt(); v = readInt(); c = readInt(); adj[readInt()].add(new C(c, t, v));  }
        for (int i = 0; i <= C; i++) for (int j = 0; j <= R; j++) for (int k = 0; k <= K; k++) Arrays.fill(dp[i][j][k], -1);
        System.out.println(run(1, 1, 0, 0));
    }

    static int run(int p, int h, int k, int t) {
        if (h == R+1 || k > K || t >= B) return 0;
        if (dp[p][h][k][t] != -1) return dp[p][h][k][t];
        int ret = 0;
        for (C c : adj[h]) {
            if (Math.abs(p-c.p) <= M ) {
                ret = Math.max(ret, run(c.p, h+1, k, t)); // don't take
                if (k < K && t + c.t < B) ret = Math.max(ret, c.v + run(c.p, h+1, k+1, t+c.t));
            }
        }
        return dp[p][h][k][t] = ret;
    }

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
