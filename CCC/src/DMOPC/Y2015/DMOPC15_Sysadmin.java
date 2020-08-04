package DMOPC.Y2015;

import java.util.*;
import java.io.*;

public class DMOPC15_Sysadmin {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    static int N, Q, M[], B[], q[], max=0;
    static long dp[];

    public static void main(String[] args) throws IOException {
        N = readInt(); Q = readInt(); M = new int[N+1]; B = new int[N+1]; q = new int[N+1];
        for (int i = 1; i <= N; i++) { M[i] = readInt(); B[i] = readInt(); }
        for (int i = 1; i <= Q; i++) { q[i] = readInt(); max = Math.max(max, q[i]); }
        dp = new long[max+1];
        Deque<Integer> dq = new LinkedList<>(); dq.add(1);
        for (int i = 1; i <= Q; i++) {
            while (dq.size() >= 2) {
                int first = dq.pollFirst(), second = dq.peekFirst();
                if (calc(first, second) > B[i]) { dq.addFirst(first); break; }
            }
            int f = dq.peekFirst();
            dp[i] = dp[f] + (long)(M[i] - M[f]) * B[i];
            while (dq.size() >= 2) {
                int first = dq.pollLast(), second = dq.peekLast();
                if (calc(second, first) < calc(first, i)) { dq.addLast(first); break; }
            }
            dq.addLast(i);
        }
        for (int i = Q+1; i <= max; i++) {

        }

        for (int i = 1; i <= Q; i++) System.out.println(dp[q[i]]);
    }

    static double calc(int a, int b) {
        return (double)(dp[a] - dp[b]) / (double)(M[a] - M[b]);
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
