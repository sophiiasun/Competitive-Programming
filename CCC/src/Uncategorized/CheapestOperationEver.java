package Uncategorized;

import java.util.*;
import java.io.*;

public class CheapestOperationEver {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    static int N, H, arr[], dq[], s = 0, e = 0, low = -1;
    static long dp[];

    public static void main(String[] args) throws IOException {
        N = readInt(); H = readInt(); arr = new int[N+1]; dp = new long[N+1]; dq = new int[N+2];
        for (int i = 1; i <= N; i++) arr[i] = readInt();
//        dq[1] = 1;
        for (int i = 1; i <= N; i++) {
            double debug = calc(dq[s], dq[s+1]);
            while (s < e && debug < (double)arr[i]) s++;
//            dp[i] = dp[dq[s]] + (long)(arr[i]-arr[dq[s]])*(arr[i]-arr[dq[s]]) + H;
            dp[i] = dp[dq[s]];
            if (s != low) { dp[i] += H; low = s; }
            else dp[i] += (long)(arr[i]-arr[dq[s]])*(arr[i]-arr[dq[s]]);
            while (s < e && calc(dq[e-1], dq[e]) < calc(dq[e], i)) e--;
            dq[++e] = i;
        }
        System.out.println(dp[N]);
    }

    static double calc(int b, int a) {
        return (double)(dp[a] - dp[b] + arr[a]*arr[a] - arr[b]*arr[b]) / (double)((arr[a]-arr[b])*2);
//        return (double)(dp[a] - dp[b]) / (double)(arr[a]-arr[b]);
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
