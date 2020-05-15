package Miscellaneous.Atcoder_DP;

import java.util.*;
import java.io.*;

public class Slimes {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = readInt();
        long[][] cost = new long[N][N], sum = new long[N][N];
        for (int i = 0; i < N; i++)
            sum[i][i] = readInt();

        int c; long min;
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < N-i; j++) {
                c = j+i; min=Long.MAX_VALUE;
                sum[j][c] = sum[j][c-1] + sum[c][c];
                for (int k = j+i-1; k >= j; k--)
                    min = Math.min(min, cost[j][k]+cost[k+1][c]);
                cost[j][c] = min+sum[j][c];
            }
        }
        System.out.println(cost[0][N-1]);
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
