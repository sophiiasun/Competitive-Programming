package DMOPC;

import java.util.*;
import java.io.*;

public class DMOPC17_Quests {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = readInt(), H = readInt(), g, h, q, t, p1=0, p2=1, tmp;
        long[][] dp = new long[2][H+1];
        for (int i = 0; i < N; i++) {
            g = readInt(); h = readInt(); q = readInt(); t = readInt();
            for (int j = h; j <= H; j++) dp[1][j] = dp[0][j-h] + g;
            for (int j = h+t; j <= H; j++) dp[1][j] = Math.max(dp[1][j], dp[1][j-t] + q);
            for (int j = 1; j <= H; j++) dp[0][j] = Math.max(dp[0][j], dp[1][j]);
        }
        System.out.println(dp[0][H]);
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
