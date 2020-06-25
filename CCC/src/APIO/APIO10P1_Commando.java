package APIO;

import java.util.*;
import java.io.*;

public class APIO10P1_Commando {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    static int N, a, b, c, pf, pb;
    static long arr[], dp[], dq[];

    public static void main(String[] args) throws IOException {
        N = readInt(); a = readInt(); b = readInt(); c = readInt();
        arr = new long[N+1]; dp = new long[N+1]; dq = new long[N+2];
        for (int i = 1; i <= N; i++) arr[i] = readInt() + arr[i-1];
        pf = 1; pb = 1;
        for (int i = 1; i <= N; i++) {
            while (pf < pb && calc(dq[pf], dq[pf+1]) < arr[i]) pf++;
            long first = dq[pf], tmp = arr[i] - arr[(int)first];
            dp[i] = dp[(int)first] + a*tmp*tmp + b*tmp + c;
            while (pf < pb && calc(dq[pb-1], dq[pb]) > calc(dq[pb], i)) pb--;
            dq[++pb] = i;
        }
        System.out.println(dp[N]);
    }

    static double calc(long m, long n) {
        int i = (int)m, j = (int)n;
        return (double)(dp[i]-dp[j]+a*arr[i]*arr[i] - a*arr[j]*arr[j] - b*arr[i] + b*arr[j]) / (double)(2*a*(arr[i]-arr[j]));
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
