package CCC.Y2019;

import java.io.*;
import java.util.*;

public class S19Q4_Tourism {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = ri(), K = ri(), in[] = new int[N+5], pma[] = new int[N+5], sma[] = new int[N+5], day[] = new int[N+5];
        long dp[] = new long[N+5], tmp[] = new long[N+5], sdp[] = new long[N+5];
        for (int i = 1; i <= N; i++) {
            in[i] = ri(); day[i] = (i + K - 1) / K;
            pma[i] = (day[i] == day[i-1]) ? Math.max(in[i], pma[i-1]) : in[i];
        }
        for (int i = N; i >= 1; i--) { sma[i] = (day[i] == day[i+1]) ? Math.max(in[i], sma[i+1]) : in[i]; }
        for (int i = 1; i <= K; i++) dp[i] = pma[i];

        for (int i = 2; i <= day[N]; i++) {
            int s = (i-2) * K, e = (i-1) * K; // previous day activity range
            for (int j = e; j > s; j--) {
                tmp[j] = dp[j] + ((j == e) ? 0 : sma[j+1]);
                sdp[j] = dp[j];
                tmp[j] = (j == e) ? tmp[j] : Math.max(tmp[j], tmp[j+1]);
                sdp[j] = (j == e) ? sdp[j] : Math.max(sdp[j], sdp[j+1]);
            }
            for (int j = e + 1; j <= Math.min(N, i*K); j++)
                dp[j] = Math.max(tmp[j - K], pma[j] + sdp[j-K]);
        }

        System.out.println(dp[N]);
    }

    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens())
            st = new StringTokenizer(br.readLine().trim());
        return st.nextToken();
    }
    static int ri () throws IOException {
        return Integer.parseInt(next());
    }
}
