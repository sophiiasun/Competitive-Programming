package DWITE;

import java.util.*;
import java.io.*;

public class DWITE10_DominosTiling {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    static int[][] dp;
    static int mod = 1000000;

    public static void main(String[] args) throws IOException {
        for (int t = 0; t < 5; t++) {
            int n = readInt();
            dp = new int[35][8];
            for (int i = 0; i < 35; i++) Arrays.fill(dp[i], -1);
            System.out.println(run(n, 7));
        }
    }

    static int run (int curr, int mask) {
        if (curr < 1) return 0;
        else if (curr == 1 && mask == 0) return 1;
        else if (dp[curr][mask] != -1) return dp[curr][mask];
        int val = 0;
        if (mask == 0) return run(curr-1, 7);
        val = (val + run(curr-1, ~mask & 7)) % mod;
        for (int i = 1; i < 3; i++) {
            if (isSet(mask, i) && isSet(mask, i-1)) {
                val = (val + run(curr, flipBit(flipBit(mask, i), i-1))) % mod;
            }
        }
        return val;
    }

    static int flipBit(int x, int b) { return (x ^ (1<<b)); }
    static boolean isSet(int x, int b) { return ((x>>b) & 1) == 1; }

    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens())
            st = new StringTokenizer(br.readLine().trim());
        return st.nextToken();
    }
    static int readInt () throws IOException {
        return Integer.parseInt(next());
    }
}
