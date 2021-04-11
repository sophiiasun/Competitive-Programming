package CCO.Y2010;

import java.util.*;
import java.io.*;

public class P4_ComputerPurchaseReturn {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int T = readInt(), N = readInt(), a, b;
        ArrayList<C>[] adj = new ArrayList[T+1];
        for (int i = 1; i <= T; i++) adj[i] = new ArrayList<>();
        for (int i = 0; i < N; i++) { a = readInt(); b = readInt(); adj[readInt()].add(new C(a, b)); }
        int B = readInt(), dp[][] = new int[T+1][B+1];

        for (int i = 1; i <= T; i++) {
            boolean flag = false;
            for (int j = 1; j <= B; j++) {
                for (C c : adj[i]) {
                    if (j - c.c >= 0) {
                        dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - c.c] + c.v);
                        flag = true;
                    }
                }
            }
            if (!flag) { System.out.println(-1); return; }
        }
        System.out.println(dp[T][B]);
    }

    static class C {
        int c, v;
        C (int cc, int vv) { c = cc; v = vv; }
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
