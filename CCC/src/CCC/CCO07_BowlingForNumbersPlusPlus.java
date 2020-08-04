package CCC;

import java.util.*;
import java.io.*;

public class CCO07_BowlingForNumbersPlusPlus {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int T = readInt(), k, n, w, ans, dp[][], psa[];
        for (int t = 0; t < T; t++) {
            n = readInt(); k = readInt(); w = readInt(); ans = 0; n += w<<1;
            dp = new int[k+1][n+1]; psa = new int[n+1];
            for (int i = w+1; i <= n-w; i++) psa[i] = readInt() + psa[i-1];
            for (int i = n-w+1; i <= n; i++) psa[i] = psa[i-1];
            for (int i = 1; i <= k; i++) {
                for (int j = 1, p; j <= n; j++) {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                    p = Math.max(0, j-w);
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][p] + psa[j] - psa[p]);
                    if (i >= 2) {
                        for (int l = Math.max(0, p-w); l <= j-w; l++) {
                            dp[i][j] = Math.max(dp[i][j], dp[i-2][l] + psa[j] - psa[l]);
                        }
                    }
                    ans = Math.max(ans, dp[i][j]);
                }
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
