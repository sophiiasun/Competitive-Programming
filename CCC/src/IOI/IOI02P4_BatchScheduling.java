package IOI;

import java.util.*;
import java.io.*;

public class IOI02P4_BatchScheduling {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    static int N, S, sumT[], sumF[], dp[];
    static Deque<Integer> dq = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        N = ri(); S = ri(); sumT = new int[N+2]; sumF = new int[N+2]; dp = new int[N+2];
        for (int i = N; i >= 1; i--) { sumT[i] = ri() + sumT[i+1]; sumF[i] = ri() + sumF[i+1]; }
        Arrays.fill(dp, 0x3f); dp[N+1] = 0; dq.add(N+1);
        for (int i = N; i >= 1; i--) {
            while (dq.size() >= 2) {
                int a = dq.pollFirst(), b = dq.peekFirst();
                if (calc(a, b) >= (double)sumF[i]) { dq.addFirst(a); break;}
            }
            int f = dq.peekFirst();
            dp[i] = dp[f] + (S + sumT[i] - sumT[f]) * sumF[i];
            while (dq.size() >= 2) {
                int z = dq.pollLast(), y = dq.peekLast();
                if (calc(y, z) <= calc(z, i)) { dq.addLast(z); break; }
            }
            dq.addLast(i);
        }
        System.out.println(dp[1]);
    }

    static double calc(int i, int j) {
        return (double)(dp[i] - dp[j]) / (double)(sumT[i] - sumT[j]);
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
