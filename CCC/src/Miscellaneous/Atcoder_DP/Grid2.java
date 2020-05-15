package Miscellaneous.Atcoder_DP;

import java.util.*;
import java.io.*;

public class Grid2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int R = readInt(), C = readInt(), N = readInt(), arr[] = new int[C+1], mod = (int)1e9+7;
        boolean[][] wall = new boolean[R+1][C+1];
        for (int i = 0; i < N; i++)
            wall[readInt()][readInt()] = true;
        arr[1] = 1;
        for (int i = 1; i <= R; i++) {
            for (int j = 1; j <= C; j++) {
                if (!wall[i][j]) {
                    arr[j] = (!wall[i-1][j]) ? arr[j] : 0;
                    arr[j] += (!wall[i][j-1]) ? arr[j-1] : 0;
                } else arr[j] = 0;
            }
        }
        System.out.println(arr[C]);
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
