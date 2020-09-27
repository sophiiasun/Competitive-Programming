package CCO.Y2016;

import java.util.*;
import java.io.*;

public class P1_FIeldTrip {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    static int N, M, K, a, b, par[], cnt[], bus = 0, cut = 0;
    static ArrayList<Integer>[] adj;
    static boolean[] vis;
    static boolean cycle = false;
    static int nodes = 0;

    public static void main(String[] args) throws IOException {
        N = readInt(); M = readInt(); K = readInt(); par = new int[N+1]; cnt = new int[N+1]; vis = new boolean[N+1];
        adj = new ArrayList[N+1]; Arrays.fill(cnt, 1);
        for (int i = 1; i <= N; i++) { adj[i] = new ArrayList<>(); par[i] = i; }
        for (int i = 0; i < M; i++) { a = readInt(); b = readInt(); adj[a].add(b); adj[b].add(a); }
        for (int i = 1; i <= N; i++) {
            if (vis[i]) continue;
            vis[i] = true; nodes = 0; cycle = false;
            dfs(i, -1);
            bus += nodes - (nodes % K); cut += nodes / K;
            if (nodes % K == 0) cut--;
            if (cycle && nodes > K) cut++;
        }
        System.out.println(bus + " " + cut);
    }

    static void dfs (int curr, int prev) {
        nodes++;
        for (int i : adj[curr]) {
            if (i == prev) continue;
            if (vis[i]) cycle = true;
            else { vis[i] = true; dfs(i, curr);  }
        }
    }

//    static void bfs (int src) {
//        if (vis[src]) return;
//        Queue<int[]> q = new LinkedList<>();
//        int nodes = 0; boolean isCycle = false;
//        vis[src] = true; q.add(new int[]{src, -1});
//        while (!q.isEmpty()) {
//            int[] curr = q.poll(); nodes++;
//            for (int i : adj[curr[0]]) {
//                if (i == curr[1]) continue;
//                if (vis[i]) isCycle = true;
//                else q.add(new int[]{i, curr[0]});
//                vis[i] = true;
//            }
//        }
//        if (nodes >= K) {
//            bus += nodes - (nodes%K); cut += nodes / K;
//            if (nodes%K == 0) cut--;
//            if (isCycle && nodes > K) cut++;
//        }
//    }

    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens())
            st = new StringTokenizer(br.readLine().trim());
        return st.nextToken();
    }
    static int readInt () throws IOException {
        return Integer.parseInt(next());
    }
}
