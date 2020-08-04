package CCO;

import java.util.*;
import java.io.*;

public class CCO07_BowlingForNumbersPlusPlus {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int T = readInt(), k, n, w, ans, dp[][], psa[], psa2[];
        for (int t = 0; t < T; t++) {
            n = readInt(); k = readInt(); w = readInt(); ans = 0;
            dp = new int[k+1][n+1]; psa = new int[n+1]; psa2 = new int[n+1];
            for (int i = 1; i <= n; i++) psa[i] = readInt() + psa[i-1];
            for (int i = 1; i <= k; i++) Arrays.fill(dp[i], 0);
            dp[0][0] = 0;
            for (int i = 1; i <= k; i++) {
                for (int j = 1; j <= n; j++) {
                    for (int l = Math.max(0, j-w); l <= j; l++) {
                        dp[i][j] = Math.max(dp[i][j], dp[i-1][l] + psa[j] - psa[l]);
                    }
                    if (j >= w) {
                        dp[i][j] = Math.max(dp[i][j], psa2[j-w] + psa[j] - psa[j-w]);
                    }
                }
                for (int l = Math.max(0, n-w); l <= n; l++) {
                    dp[i][n] = Math.max(dp[i][n], psa2[l] + psa[n] - psa[l]);
                }
                Arrays.fill(psa2, 0);
                for (int j = 1; j <= n; j++) {
                    psa2[j] = Math.max(psa2[j-1], dp[i][j]);
                }
            }
            for (int i = 1; i <= n; i++) {
                ans = Math.max(ans, dp[k][i]);
            }
            System.out.println(ans);
        }
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
