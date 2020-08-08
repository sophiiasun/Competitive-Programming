package Atcoder_DP;

import java.util.*;
import java.io.*;

public class Tower {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    static int N;
    static C a[];

    public static void main(String[] args) throws IOException {
        N = readInt(); a = new C[N+1];
        for (int i = 1; i <= N; i++) a[i] = new C (readInt(), readInt(), readInt());

    }

    static class C {
        int w, s; long v;
        C (int ww, int ss, long vv) { w = ww; s = ss; v = vv; }
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
