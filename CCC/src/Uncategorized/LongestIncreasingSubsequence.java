package Uncategorized;

import java.util.*;
import java.io.*;

public class LongestIncreasingSubsequence {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = readInt(), max = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] dp = new int[N], arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = readInt(); dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) dp[i] = Math.max(dp[i], dp[j]+1);
            }
            if (dp[i] > max) max = dp[i];
        }
        System.out.println(max);
    }

    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens())
            st = new StringTokenizer(br.readLine().trim());
        return st.nextToken();
    }
    static int readInt() throws IOException {
        return Integer.parseInt(next());
    }
}
