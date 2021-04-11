import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    static int R, C, S, B, K, M, dp[][][][], av[][], at[][];

    public static void main(String[] args) throws IOException {
        R = readInt(); C = readInt(); S = readInt(); B = readInt(); K = readInt(); M = readInt();
        dp = new int[C+1][R+1][K+1][B+1]; av = new int[C+1][R+1]; at = new int[C+1][R+1];
        for (int i = 0, t, v, c, r; i < S; i++) { t = readInt(); v = readInt(); c = readInt(); r = readInt(); av[c][r] = v; at[c][r] = t; }
        System.out.println(run(1, 1, 0, 0));
    }

    static int run(int p, int h, int k, int t) {
        if (h == R+1 || k >= K || t >= B) return 0;
        if (dp[p][h][k][t] > 0) return dp[p][h][k][t];
        int ret = 0;
        for (int i = Math.max(p-M, 0); i <= Math.min(p+M, C); i++) { // keep within bounds : i=p
            ret = Math.max(ret, run(i, h+1, k, t)); // don't take
            if (k < K && t + at[i][h] < B) ret = Math.max(ret, av[i][h] + run(i, h+1, k+1, t+at[i][h]));
        }
        return dp[p][h][k][t] = ret;
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