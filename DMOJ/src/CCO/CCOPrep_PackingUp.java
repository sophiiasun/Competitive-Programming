package CCO;

import java.util.*;
import java.io.*;

public class CCOPrep_PackingUp {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    static int N, L, pf=0, pb=0;
    static long arr[], dp[], dq[];

    public static void main(String[] args) throws IOException {
        N = readInt(); L = readInt() + 1; arr = new long[N+1]; dp = new long[N+1]; dq = new long[N+2];
        for (int i = 1; i <= N; i++) arr[i] = readInt() + arr[i-1] + 1;
        for (int i = 1; i <= N; i++) {
            while (pf < pb && calc(dq[pf], dq[pf+1]) < arr[i] - L) pf++;
            dp[i] = dp[(int)dq[pf]] + (arr[i]-arr[(int)dq[pf]] - L) * (arr[i]-arr[(int)dq[pf]] - L);
            while (pf < pb && calc(dq[pb-1], dq[pb]) > calc(dq[pb], i)) pb--;
            dq[++pb] = i;
        }
        System.out.println(dp[N]);
    }

    static double calc(long a, long b) {
        return top(b, a) / bot(b, a);
    }

    static double bot (long a, long b) {
        return (double)(2*(arr[(int)a]-arr[(int)b]));
    }

    static double top (long a, long b) {
        return (double)(dp[(int)a] - dp[(int)b] + arr[(int)a]*arr[(int)a] - arr[(int)b]*arr[(int)b]);
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
