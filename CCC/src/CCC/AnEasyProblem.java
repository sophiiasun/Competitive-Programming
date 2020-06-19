package CCC;

import java.util.*;
import java.io.*;

public class AnEasyProblem {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = readInt(), dp[] = new int[32], max, ans = 0;
        for (int i = 0; i < N; i++) {
            int n = readInt(); max = 0;
            for (int j = 0; j < 31; j++) {
                if (((n >> j) & 1) != 0) max = Math.max(max, dp[j] + 1);
            }
            for (int j = 0; j < 31; j++) {
                if (((n >> j) & 1) != 0) dp[j] = max;
            }
        }
        for (int i = 0; i < 31; i++) ans = Math.max(ans, dp[i]);
        System.out.println(ans);
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
