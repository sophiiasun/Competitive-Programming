package Miscellaneous.Atcoder;

import java.util.*;
import java.io.*;

public class Knapsack1_2 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = readInt(), W = readInt(), arr[][] = new int[N+1][2];
        for (int i = 1; i <= N; i++) {
            arr[i][0] = readInt(); arr[i][1] = readInt();
        }
        Arrays.sort(arr, (int[]a, int[]b)->a[0]-b[0]);

        long[] curr = new long[W+1], next = new long[W+1];
        for (int i = 1; i <= N; i++) {
            int v = arr[i][1], w = arr[i][0];
            for (int j = 1; j <= W; j++) {
                if (w > j) next[j] = curr[j];
                else next[j] = Math.max(v+curr[j-w], curr[j]);
            }
            long[] tmp = curr; curr = next; next = tmp; Arrays.fill(next, 0);
        }
        System.out.println(curr[W]);
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
