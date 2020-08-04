package Atcoder_DP;

import java.util.*;
import java.io.*;

public class UnboundedKnapsack {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = readInt(), W = readInt(); long[] dp = new long[W+1];
        for (int i = 1; i <= N; i++) {
            int w = readInt(), v = readInt();
            for (int j = w; j <= W; j++)
                dp[j] = Math.max(dp[j], v + dp[j-w]);
        }
        System.out.println(dp[W]);
    }

    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens())
            st = new StringTokenizer(br.readLine().trim());
        return st.nextToken();
    }
    static int readInt() throws IOException {
        return Integer.parseInt(next());
    }
}
