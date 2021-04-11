package CCO.Mock;

import java.util.*;
import java.io.*;

public class Y18C4P3_Counterattack {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    static int N, M, A, B, W;
    static ArrayList<Edge>[] arr;

    public static void main(String[] args) throws IOException {
        N = readInt(); M = readInt();
        arr = new ArrayList[N+1];
        Edge2[] edges = new Edge2[M];
        for (int i = 1; i <= N; i++) arr[i] = new ArrayList<>(); // Initialize
        for (int i = 0; i < M; i++) { // Build graph
            A = readInt(); B = readInt(); W = readInt();
            arr[A].add(new Edge(B, W)); arr[B].add(new Edge(A, W));
            edges[i] = new Edge2(A, B, W);
        }

        int[] dis1 = new int[N+1], dis2 = new int[N+1]; Arrays.fill(dis1, Integer.MAX_VALUE); Arrays.fill(dis2, Integer.MAX_VALUE);
        sssp(1, dis1); sssp(N, dis2); // Find shortest distance from start and end nodes to every other nodes

        int min = Integer.MAX_VALUE, ans = Integer.MAX_VALUE;
        for (Edge2 e : edges) { // Go through each combination and find second shortest
            int len = dis1[e.a] + dis2[e.b] + e.w;
            if (len < min) { ans = min; min = len; } // min always takes shortest
            else if (len < ans && len > min) ans = len; // ans takes second shortest
            len = dis1[e.b] + dis2[e.a] + e.w;
            if (len < min) { ans = min; min = len; } // min always takes shortest
            else if (len < ans && len > min) ans = len; // ans takes second shortest
        }
        System.out.println(ans);
    }

    static void sssp (int src, int[] dis) { // Dijkstra
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        boolean[] vis = new boolean[N+1];
        queue.add(src); dis[src] = 0;
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            vis[curr] = true;
            for (Edge e : arr[curr]) {
                if (dis[curr] + e.w < dis[e.n]) {
                    dis[e.n] = dis[curr] + e.w;
                    if (!vis[e.n]) queue.add(e.n);
                }
            }
        }
    }

    static class Edge2 {
        int a, b, w;
        Edge2 (int pa, int pb, int pw) { a = pa; b = pb; w = pw; }
    }

    static class Edge {
        int n, w;
        Edge (int pn, int pw) { n = pn; w = pw; }
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
