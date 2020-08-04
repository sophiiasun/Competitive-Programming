package CCC.Y2007;

// Same concept as Knapsack DP Solution

import java.util.*;
import java.io.*;

public class S07Q5_BowlingForNumbers {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int t = readInt();
        for (int T = 0; T < t; T++) {
            int n = readInt(), k = readInt(), w = readInt();
            int[] psa = new int[n+1]; int[][] dp = new int[k+1][n+1]; // Initialize
            for (int i = 1; i <= n; i++) { // Input
                psa[i] = psa[i-1] + readInt(); // Prefix Sum Array
            }
            for (int i = 1; i <= k; i++) { // Scan row by row
                for (int j = 1; j <= n; j++) { // Scan col by col
                    if (j <= w) dp[i][j] = psa[j]; // Get default value from PSA
                    else dp[i][j] = Math.max(dp[i][j-1], psa[j]-psa[j-w] + dp[i-1][j-w]); // Either take it or don't take it
                }
            }
            System.out.println(dp[k][n]);
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
