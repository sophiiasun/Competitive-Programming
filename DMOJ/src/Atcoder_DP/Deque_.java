package Atcoder_DP;

import java.util.*;
import java.io.*;

public class Deque_ {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = readInt(); long[] psa = new long[N+1]; long[][] dp = new long[N+1][N+1];
        for (int i = 1; i <= N; i++) {
            psa[i] = readLong(); dp[i][i] = psa[i];
            psa[i] += psa[i-1];
        }
        for (int len = 1; len < N; len++) {
            for (int lft=1; lft+len <= N; lft++) {
                int rit = lft+len;
                dp[lft][rit] = psa[rit] - psa[lft-1] - Math.min(dp[lft+1][rit], dp[lft][rit-1]);
            }
        }
        System.out.println(2*dp[1][N] - psa[N]);
    }

    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens())
            st = new StringTokenizer(br.readLine().trim());
        return st.nextToken();
    }
    static long readLong () throws IOException {
        return Long.parseLong(next());
    }
    static int readInt() throws IOException {
        return Integer.parseInt(next());
    }
}
