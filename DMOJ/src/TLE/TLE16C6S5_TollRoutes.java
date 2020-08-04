package TLE;

import java.util.*;
import java.io.*;

public class TLE16C6S5_TollRoutes {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    static int N, M, D, L = Integer.MAX_VALUE;
    static long dis[][];
    static ArrayList<C> adj1[], adj2[];

    public static void main(String[] args) throws IOException {
        N = readInt(); M = readInt(); D = readInt(); adj1 = new ArrayList[N+1]; adj2 = new ArrayList[N+1]; dis = new long[N+1][M+1];
        for (int i = 0, x, y, z; i < M; i++) {
            x = readInt(); y = readInt(); z = readInt();
            adj1[x].add(new C(y, z)); adj2[y].add(new C(x, z));
        }
        for (int i = 1; i <= N; i++) Arrays.fill(dis[i], L);
        dis[1][0] = 0;
        dfs(1, 0);

    }

    static void cht() {}

    static void dfs(int curr, int cnt) {
        for (C i : adj1[curr]) {
            dis[i.n][cnt+1] = Math.min(dis[i.n][cnt+1], dis[curr][cnt] + i.c);
            dfs(i.n, cnt+1);
        }
    }

    static class C {
        int n; long c;
        C (int nn, int cc) { n = nn; c = cc; }
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
