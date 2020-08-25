package APIO;

import java.io.*;
import java.util.*;

public class APIO14_SplitTheSequence {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    static int N, K, order[][], out[], pos, pf, pb, dq[];
    static long dp[][], a[];

    public static void main(String[] args) throws IOException {
        N = readInt(); K = readInt();
        order = new int[K+1][N+1]; out = new int[K+1]; dp = new long[2][N+1]; a = new long[N+1]; dq = new int[N+2];
        for (int i = 1; i <= N; i++) a[i] = readInt() + a[i-1]; // build suffix

        for (int i = 1; i <= K; i++, pos^=1) {
            pf = pb = 1; int tmp = pos^1;
            for (int j = 1; j <= N; j++) {
                while (pf < pb && calc(tmp, dq[pf], dq[pf+1]) <= a[j]*(a[dq[pf+1]] - a[dq[pf]])) pf++;
                int s = dq[pf];
                dp[pos][j] = dp[tmp][s] + a[s] * (a[j] - a[s]);
                order[i][j] = s;
                while (pf < pb && calc(tmp, dq[pb], dq[pb-1])*(a[dq[pb]]-a[j]) >= calc(tmp, j, dq[pb])*(a[dq[pb-1]]-a[dq[pb]])) pb--;
                dq[++pb] = j;
            }
//            debug(pos, dq[pf]);
        }
        int k = K;
        System.out.println(dp[pos^1][N]);
        for (int i = order[k][N]; i > 0; i = order[--k][i]) out[k] = i;
        for (int i = 1; i <= K; i++) System.out.print(out[i] + " ");
        System.out.println();
    }

    static long calc(int i, int j, int k) {
        return dp[i][j] - dp[i][k] - a[j]*a[j] + a[k]*a[k];
    }

    static void debug(int k, int front) {
        for (int i = 1; i <= N; i++) System.out.print(dp[k][i] + " ");
        System.out.println("           " + front);
        System.out.println();
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