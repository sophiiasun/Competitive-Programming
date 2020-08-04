package Uncategorized;

import java.util.*;
import java.io.*;

public class CheapestOperationEver2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    static int N, H, arr[];
    static long dp[];

    public static void main(String[] args) throws IOException {
        N = readInt(); H = readInt(); arr = new int[N+1]; dp = new long[N+1];
        for (int i = 1; i <= N; i++) arr[i] = readInt();
        Deque<Integer> dq = new LinkedList<>();
//        dq[1] = 1;
        for (int i = 1; i <= N; i++) {
            dq.addLast(i);
            while (dq.size() >= 2) {
                int first = dq.pollFirst(), second = dq.peekFirst();
                if (calc(first, second) > (double)arr[i]) { dq.addFirst(first); break; }
            }
            int f = dq.peekFirst();
            dp[i] = dp[f-1] + (long)(arr[i]-arr[f])*(arr[i]-arr[f]) + H;
            while (dq.size() >= 2) {
                int first = dq.pollLast(), second = dq.peekLast();
                if (calc(second, first) < calc(first, i)) { dq.addLast(first); break; }
            }
            dq.addLast(i);
        }
        System.out.println(dp[N]);
    }

    static double calc(int b, int a) {
        double tmp = (double)(dp[a-1] - dp[b-1] + arr[a]*arr[a] - arr[b]*arr[b]) / (double)((arr[a]-arr[b])*2);
        System.out.println(tmp);
        return tmp;
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
