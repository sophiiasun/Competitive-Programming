package Olympiads;

import java.util.*;
import java.io.*;

public class BobsAppleShopping {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = readInt(), M = readInt(), min = Integer.MAX_VALUE, dp[] = new int[M<<1];
        Arrays.fill(dp, 1000000000); dp[0] = 0;
        Apple[] arr = new Apple[N];
        for (int i = 0; i < N; i++)
            arr[i] = new Apple(readInt(), readInt());
        for (int i = 1; i < M<<1; i++) {
            for (Apple a : arr) {
                if (i - a.v >= 0) dp[i] = Math.min(dp[i], a.w + dp[i-a.v]);
                if (i >= M) min = Math.min(dp[i], min);
            }
        }
        System.out.println(min);
    }

    static class Apple {
        int v, w;
        Apple (int pv, int pw) { v = pv; w = pw;  }
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
