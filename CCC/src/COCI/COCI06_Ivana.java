package COCI;

import java.util.*;
import java.io.*;

public class COCI06_Ivana {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int n = readInt(), dp[][] = new int[n*2 + 1][n*2 + 1];
        for (int i = 1; i <= n; i++) {
            dp[i][i] = dp[n+i][n+i] = readInt() % 2;
        }
        for (int len = 1; len < n; len++) {
            for (int s = 1; s + len <= n*2; s++) {
                int e = s + len;
                dp[s][e] = Math.max(dp[s][s] - dp[s+1][e], dp[e][e] - dp[s][e-1]);
            }
        }
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (dp[i][i] - dp[i+1][i-1+n] > 0) ans++;
        }
        System.out.println(ans);
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
