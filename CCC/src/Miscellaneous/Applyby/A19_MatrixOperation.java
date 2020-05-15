package Miscellaneous.Applyby;

import sun.awt.image.ImageWatched;

import java.util.*;
import java.io.*;

public class A19_MatrixOperation {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    static int N, start, max;
    static int[][] arr, dp;

    public static void main(String[] args) throws IOException {
        N = readInt(); start = Integer.MIN_VALUE; max = 0;
        arr = new int[N][N]; dp = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], -1);
            for (int j = 0; j < N; j++)
                arr[i][j] = readInt();
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                max = Math.max(max, get(i, j));
            }
        }
        System.out.println(max);
    }

    static int get(int r, int c) {
        if (dp[r][c] != -1) return dp[r][c];
        else {
            dp[r][c] = 0;
            if (r-1 >= 0 && arr[r-1][c] < arr[r][c]) dp[r][c] = Math.max(dp[r][c], get(r-1, c)+1);
            if (r+1 < N && arr[r+1][c] < arr[r][c]) dp[r][c] = Math.max(dp[r][c], get(r+1, c)+1);
            if (c-1 >= 0 && arr[r][c-1] < arr[r][c]) dp [r][c] = Math.max(dp[r][c], get(r, c-1)+1);
            if (c+1 < N && arr[r][c+1] < arr[r][c]) dp[r][c] = Math.max(dp[r][c], get(r, c+1)+1);
            return dp[r][c];
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
