package CCO.Y2013;

import java.util.*;
import java.io.*;

public class P3_LHC {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    static int n;
    static long ans = 0L, max = 0L, dis[], cnt[];
    static ArrayList<Integer>[] adj;

    public static void main(String[] args) throws IOException {
        n = readInt(); adj = new ArrayList[n+1]; dis = new long[n+1]; cnt = new long[n+1]; int a, b;
        for (int i = 1; i <= n; i++) adj[i] = new ArrayList<>();
        for (int i = 1; i < n; i++) { a = readInt(); b = readInt(); adj[a].add(b); adj[b].add(a); }
        dfs(1, -1);
        System.out.println((max+1) + " " + ans);
    }

    static void dfs(int curr, int prev) {
        dis[curr] = 0; cnt[curr] = 1;
        for (int i : adj[curr]) {
            if (i == prev) continue;
            dfs(i, curr);
            if (max < dis[curr] + dis[i] + 1) {
                max = dis[curr] + dis[i] + 1; ans = cnt[curr] * cnt[i];
            } else if (max == dis[curr] + dis[i] + 1) ans += cnt[curr] * cnt[i];

            if (dis[curr] < dis[i] + 1) {
                dis[curr] = dis[i] + 1; cnt[curr] = cnt[i];
            } else if (dis[curr] == dis[i] + 1) cnt[curr] += cnt[i];
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
