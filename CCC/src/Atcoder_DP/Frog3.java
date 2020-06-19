package Atcoder_DP;

import java.io.*;
import java.util.*;

public class Frog3 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    static long C, dp[];
    static long N, first, second, arr[];

    public static void main(String[] args) throws IOException {
        N = readInt(); C = readLong(); arr = new long[(int)N+1]; dp = new long[(int)N+1];
        for (int i = 1; i <= N; i++) arr[i] = readInt();
        Deque<Long> dq = new LinkedList<>();
        dq.add((long)1);
        for (int i = 2; i <= N; i++) {
            while (dq.size() >= 2) {
                first = dq.pollFirst(); second = dq.peekFirst();
                if (calc(second, first) >= (double)arr[i]) { dq.addFirst(first); break; }
            }
            first = dq.peekFirst();
            dp[i] = C + dp[(int)first] + (arr[i]-arr[(int)first])*(arr[i]-arr[(int)first]);
            while (dq.size() >= 2) {
                first = dq.pollLast(); second = dq.peekLast();
                if (calc(second, first) <= calc(first, i)) { dq.addLast(first); break; }
            }
            dq.addLast((long)i);
        }
        System.out.println(dp[(int)N]);
    }

    static double calc(long A, long B) {
        int a = (int)A, b = (int)B;
        return (dp[a] + (double)(arr[a]*arr[a]) - dp[b] - (double)(arr[b]*arr[b])) / ((double)(arr[a]-arr[b])*2);
    }

    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens())
            st = new StringTokenizer(br.readLine().trim());
        return st.nextToken();
    }
    static int readInt () throws IOException {
        return Integer.parseInt(next());
    }
    static long readLong () throws IOException {
        return Long.parseLong(next());
    }
}
