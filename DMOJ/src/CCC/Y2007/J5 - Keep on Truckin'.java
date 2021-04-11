package CCC.Y2007;

import java.util.*;
import java.io.*;

public class J07Q5_KeepOnTruckin {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int A = readInt(), B = readInt(), N = readInt(), ans = 0;
        long dp[] = new long[7001], psa[] = new long[7001];
        boolean a[] = new boolean[7001]; dp[0] = psa[0] = 1;
        a[0] = a[990] = a[1010] = a[1970] = a[2030] = a[2940] = a[3060] = a[3930] = a[4060] = a[4970] = a[5030] = a[5990] = a[6010] = a[7000] = true;
//        dp[0] = dp[990] = dp[1010] = dp[1970] = dp[2030] = dp[2940] = dp[3060] = dp[3930] = dp[4060] = dp[4970] = dp[5030] = dp[5990] = dp[6010] = dp[7000] = 1;
        for (int i = 0, x; i < N; i++) { x = readInt(); a[x] = true; /*dp[x] = 1;*/ }
        for (int i = 1; i <= 7000; i++) {
            if (a[i] && i >= A) dp[i] += psa[i-A] - (i-B <= 0 ? 0 : psa[i-B-1]);// psa[Math.max(0, i-B-1)];
            psa[i] = dp[i] + psa[i-1];
        }
        System.out.println(dp[7000]);
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
