package Uncategorized;

import java.util.*;
import java.io.*;

public class PickIt {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = readInt(), c;
        while (N != 0) {
            int[] arr = new int[N+1]; int[][] dp = new int[N+1][N+1];
            for (int i = 1; i <= N; i++) arr[i] = readInt();
            for (int i = 2; i < N; i++) {
                for (int j = 1; j < N-i+1; j++) {
                    c = i+j;
                    for (int k = j+1; k < c; k++)
                        dp[j][c] = Math.max(dp[j][c], arr[j]+arr[c]+arr[k]+dp[j][k]+dp[k][c]);
                }
            }
            System.out.println(dp[1][N]);
            N = readInt();
        }
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
