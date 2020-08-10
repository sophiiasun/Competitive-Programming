package Atcoder_DP;

import java.util.*;
import java.io.*;

public class Tower {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    static int N;
    static long ans = 0;
    static C a[];

    public static void main(String[] args) throws IOException {
        N = readInt(); a = new C[N+1]; int W = 0;
        a[0] = new C(0, 0, 0);
        for (int i = 1; i <= N; i++) { a[i] = new C (readInt(), readInt(), readInt()); W = Math.max(Math.max(W, a[i].w), a[i].s); }
        Arrays.sort(a);
        long dp[][] = new long[N+1][W+1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= W; j++) dp[i][j] = dp[i-1][j]; // don't take
            for (int j = a[i].w; j <= a[i].s; j++)
                dp[i][j] = Math.max(dp[i][j], dp[i-1][j-a[i].w] + a[j].v);
            for (int j = 1; j <= W; j++) ans = Math.max(ans, dp[i][j]);
        }
        System.out.println(ans);
    }

    static class C implements Comparable<C> {
        int w, s; long v;
        C (int ww, int ss, long vv) { w = ww; s = ss; v = vv; }
        public int compareTo(C c) { return (w+s) - (c.w+c.s); }
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
