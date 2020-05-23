package CCC.Y2007;

import java.util.*;
import java.io.*;

public class S07Q5_BowlingForNumbers {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int t = readInt();
        for (int T = 0; T < t; T++) {
            int n = readInt(), k = readInt(), w = readInt();
            int[] psa = new int[n+1], val = new int[n+1];
            int[][] dp = new int[2][n+1];
            for (int i = 1; i <= n; i++) { // Input
                val[i] = readInt();
            }
            for (int i = 1; i <= k; i++) {
                for (int j = n; j > 0; j--) {
                    if (j < n-w) {
//                        score
                    }
                }
            }
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
    static long readLong () throws IOException {
        return Long.parseLong(next());
    }
    static double readDouble () throws IOException {
        return Double.parseDouble(next());
    }
    static char readCharacter () throws IOException {
        return next().charAt(0);
    }
    static String readLine () throws IOException {
        return br.readLine().trim();
    }
}
