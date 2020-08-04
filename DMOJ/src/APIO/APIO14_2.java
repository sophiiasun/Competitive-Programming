package APIO;

import java.util.*;
import java.io.*;

// DOESN'T WORK

public class APIO14_2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    static int N, K, dq[];
    static long psa[], dp[][], arr[][];

    static void main(String[] args) throws IOException {
        N = readInt(); K = readInt(); psa = new long[N+1]; dp = new long[N+1][2]; dq = new int[N+2]; arr = new long[202][N+2];
        for (int i = 1; i <= N; i++) psa[i] = readInt() + psa[i-1];
        int s, e, p1 = 0, p2 = 1;
        for (int i = 1; i <= K; i++) {
            s = e = 1;
            for (int j = 1; j <= N; i++) {
                while (s < e && calc(dq[s+1], dq[s], p2) > calc2(j, s, s+1)) s++;
                dp[j][p1] = dp[dq[s]][p2] + psa[dq[s]] * (psa[j] - psa[dq[s]]);
                arr[i][j] = dq[s];
                while (s < e && calc(dq[e], dq[e-1], p2)*(psa[dq[e]] - psa[j]) < calc(j, dq[e], p2)*(psa[dq[e-1]] - psa[dq[e]])) e--;
                dq[++e] = j;
            }
            int tmp = p1; p1 = p2; p2 = tmp;
        }
        System.out.println(dp[N][p1]);
        StringBuilder sb = new StringBuilder();
        for (long i = arr[K][N]; K > 0; i = arr[--K][(int)i]) sb.append(i + " ");
        sb.setLength(sb.length()-1);
        System.out.println(sb);
    }

    static double calc2(int a, int b, int c) {
        return psa[a] * (psa[dq[b]] - psa[dq[c]]);
    }

    static double calc(int a, int b, int c) {
        return (dp[a][c] - dp[b][c] + psa[a]*psa[a] - psa[b]*psa[b]);
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
