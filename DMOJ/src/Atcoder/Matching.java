package Atcoder_DP;

import java.util.*;
import java.io.*;

public class Matching {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    static int n, dp[], a[][], mod = (int)1e9 + 7;


    public static void main(String[] args) throws IOException {
        n = readInt(); dp = new int[1<<21]; a = new int[21][21];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                a[i][j] = readInt();
        }
        Arrays.fill(dp, -1);
        System.out.println(run(0, 0));
    }

    static int run (int man, int mask) {
        if (man == n) return 1;
        if (dp[mask] != -1) return dp[mask];
        dp[mask] = 0;
        for (int i = 0; i < n; i++) {
            if ((mask & 1<<i) == 0 && a[man][i] == 1) {
                dp[mask] = (dp[mask] + run(man + 1, mask | (1<<i))) % mod;
            }
        }
        return dp[mask];
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
