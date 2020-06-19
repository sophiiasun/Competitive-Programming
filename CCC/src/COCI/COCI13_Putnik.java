package COCI;

import java.util.*;
import java.io.*;

public class COCI13_Putnik {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    static int n, adj[][], dp[][];

    public static void main(String[] args) throws IOException {
        n = readInt(); adj = new int[n+1][n+1]; dp = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) adj[i][j] = readInt();
        }
        System.out.println(run(1, 1));
    }

    static int run(int s, int e) {
        if (s == n || e == n) return 0;
        if (dp[s][e] > 0) return dp[s][e];
        int next = Math.max(s, e) + 1; // next left..right or left..right next
        dp[s][e] = Math.min(adj[next][s] + run(next, e), adj[e][next] + run(s, next));
        return dp[s][e];
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
