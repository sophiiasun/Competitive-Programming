package Classics;

import java.util.*;
import java.io.*;

public class LongestCommonSubsequence {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = readInt(), M = readInt(), an[] = new int[N+1], am[] = new int[M+1], dp[][] = new int[2][M+1], pos = 0;
        for (int i = 1; i <= N; i++) an[i] = readInt(); // n as row
        for (int i = 1; i <= M; i++) am[i] = readInt(); // m as col
        for (int i = 1; i <= N; i++, pos^=1) {
            int tmp = pos^1;
            for (int j = 1; j <= M; j++) {
                if (an[i] == am[j]) dp[pos][j] = dp[tmp][j-1] + 1;
                dp[pos][j] = Math.max(Math.max(dp[pos][j], dp[pos][j-1]), dp[tmp][j]);
            }
        }
        System.out.println(dp[pos^1][M]);
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
