package DMOPC.Y2014;

import java.util.*;
import java.io.*;

public class DMOPC14_NotEoughTime {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = readInt(), T = readInt(), dp[] = new int[T+1]; P arr[][] = new P[N][3];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 3; j++) arr[i][j] = new P(readInt(), readInt());
        }
        for (int i = 0; i < N; i++) {
            for (int t = T; t >= 0; t--) {
                for (P p : arr[i]) {
                    if (t - p.t >= 0)
                        dp[t] = Math.max(dp[t], dp[t-p.t] + p.v);
                }
            }
        }
        System.out.println(dp[T]);
    }

    static class P {
        int t, v;
        P (int pt, int pv) { t = pt; v = pv; }
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
