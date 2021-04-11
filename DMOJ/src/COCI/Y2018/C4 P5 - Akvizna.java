package COCI.Y2018;

import java.util.*;
import java.io.*;

public class COCI18C4P5_Akvizna {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    static int N, K, pf, pb, seg[];
    static double dp[];

    public static void main(String[] args) throws IOException {
        N = readInt(); K = readInt(); seg = new int[N+3]; dp = new double[N+3];
        double s = 0.0, e = 1.0, m;
        for (int i = 0; i < 40; i++) {
            m = (s + e) / 2.0;
            cht(m);
            if (seg[N] > K) s = m;
            else e = m;
        }
        System.out.println(String.format("%.12f", dp[N] + s*K));
    }

    static void cht (double m) {
        pf = pb = 1;
        int[] dq = new int[N+5];
        for (int i = 1; i <= N; i++) {
            while (pf < pb && c(dq[pf], dq[pf+1]) >= 1.0/i) pf++;
            seg[i] = seg[dq[pf]] + 1;
            dp[i] = dp[dq[pf]] + (double)(i - dq[pf]) - m;
            while (pf < pb && c(dq[pb-1], dq[pb]) <= c(dq[pb], i)) pb--;
            dq[++pb] = i;
        }
    }

    static double c(int a, int b) { return (double)(dp[b] - dp[a]) / (double)(b-a); }

    static double calc(int b, int a) {
        return ( dp[a] - dp[b] - t(a) + t(b) ) / ( b(b) - b(a) );
    }

    static double t(int a) {
        return (double)a / ((double)N - (double)a);
    }

    static double b(int a) {
        return 1.0 / ((double)N - (double)a);
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
