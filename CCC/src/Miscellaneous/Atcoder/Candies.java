package Miscellaneous.Atcoder;

import java.io.*;
import java.util.*;

public class Candies {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = readInt(), K = readInt(), mod = (int)1e9+7;
        int[][] dp = new int[N+1][K+1];
        dp[0][0] = 1;
        for (int i = 1; i <= N; i++) {
            int next = readInt(); dp[i][0] = 1;
            for (int j = 1; j <= K; j++) {
                if (j > next) dp[i][j] = (dp[i-1][j]-dp[i-1][j-next-1])%mod;
                else dp[i][j] = dp[i-1][j];
                dp[i][j] = (dp[i][j] + dp[i][j-1]) % mod;
            }
        }
        System.out.println(dp[N][K]);
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
