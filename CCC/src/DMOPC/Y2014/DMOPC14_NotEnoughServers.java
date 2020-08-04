package DMOPC.Y2014;

import java.util.*;
import java.io.*;

public class DMOPC14_NotEnoughServers {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int n = readInt(), m = readInt(), bit[] = new int[m], res = 0;
        for (int i = 0; i < n; i++) {
            char[] c = readLine().toCharArray();
            boolean ac = true;
            for (int j = 0; j < m; j++) {
                bit[j] <<= 1;
                if (c[j] =='X') {
                    ac = false; bit[j] |= 1;
                }
            }
            res = res<<1 | (ac ? 0 : 1);
        }
        if (res == 0) { System.out.println("1\n1"); return; }
        int[] dp = new int[1<<n], prev = new int[1<<n], use = new int[1<<n];
        Arrays.fill(dp, (int)1e9); dp[0] = 0;
        for (int i = 0; i < m; i++) { // Knapsack logic
            for (int mask = 0; mask < (1<<n); mask++) {
                int nmask = mask | bit[i];
                if (dp[nmask] > 1 + dp[mask]) {
                    dp[nmask] = 1 + dp[mask]; prev[nmask] = mask; use[nmask] = i + 1;
                }
            }
        }
        System.out.println(dp[res]);
        for (int mask = res; mask != 0; mask = prev[mask]) {
            System.out.print(use[mask] + " ");
        }
        System.out.println();
    }

    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens())
            st = new StringTokenizer(br.readLine().trim());
        return st.nextToken();
    }
    static int readInt () throws IOException {
        return Integer.parseInt(next());
    }
    static String readLine () throws IOException {
        return br.readLine().trim();
    }
}
