package APIO;

import java.util.*;
import java.io.*;

public class Commando {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    static int N, a, b, c, arr[], dp[], dq[], pf, pb;

    public static void main(String[] args) throws IOException {
        N = readInt(); a = readInt(); b = readInt(); c = readInt();
        arr = new int[N+1]; dp = new int[N+1]; dq = new int[N+1];
        for (int i = 1; i <= N; i++) arr[i] = readInt() + arr[i-1];

        for (int i = 1; i <= N; i++) {
//            while (pf < pb && calc(pf, pf+1) )
        }
    }

    static double calc(int a, int b) {

//        return (dp[a]-dp[b]+a*arr[a]*arr[a] - a*arr[b]*arr[b])
        return 0;
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
