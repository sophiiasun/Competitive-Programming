package Atcoder_DP;

import java.util.*;
import java.io.*;

public class Sushi {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    static int n, f[] = new int[4];
    static double[][][] dp;

    public static void main(String[] args) throws IOException {
        n = readInt(); dp = new double[n+1][n+1][n+1];
        for (int i = 0; i < n; i++) f[readInt()]++;
        System.out.printf("%.9f\n", run(f[1], f[2], f[3]));
    }

    static double run(int d1, int d2, int d3) {
        if (d1==0 && d2==0 && d3==0) return 0;
        if (dp[d1][d2][d3] > 0.0) return dp[d1][d2][d3];
        double ret = n; int t = d1+d2+d3;
        if (d1 > 0) ret += d1 * run(d1-1, d2, d3);
        if (d2 > 0) ret += d2 * run(d1+1, d2-1, d3);
        if (d3 > 0) ret += d3 * run(d1, d2+1, d3-1);
        return dp[d1][d2][d3] = ret/t;
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
