package CCO.Y2012;

import java.util.*;
import java.io.*;

public class P2_TheHungaryGames {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    static int N, M, A, B, W;

    public static void main(String[] args) throws IOException {
        N = readInt(); M = readInt();
        ArrayList<Edge>[] arr1 = new ArrayList[N+1], arr2 = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) { // Initialize
            arr1[i] = new ArrayList<>(); arr2[i] = new ArrayList<>();
        }
        Edge2[] edges = new Edge2[M];
        for (int i = 0; i < M; i++) { // Build Graph
            A = readInt(); B = readInt(); W = readInt();
            arr1[A].add(new Edge(B, W)); arr2[B].add(new Edge(A, W)); edges[i] = new Edge2(A, B, W);
        }

        int[] dis1 = new int[N+1], dis2 = new int[N+1];
        sssp(1, arr1, dis1); sssp(N, arr2, dis2); // Find shortest distance from start and end node to every other node

        int min = Integer.MAX_VALUE;
        for (Edge2 e : edges) { // min is the shortest distance, ans is the second shortest
            if (dis1[e.a] != Integer.MAX_VALUE && dis2[e.b] != Integer.MAX_VALUE) {
                int len = dis1[e.a] + dis2[e.b] + e.w;
                if (len > dis1[N]) min = Math.min(min, len);
            }
        }

        if (min == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(min);
    }

    static void sssp (int src, ArrayList<Edge>[] arr, int[] dis) { // Dijkstra
        PriorityQueue<Integer> queue = new PriorityQueue<>(); queue.add(src);
        boolean[] vis = new boolean[N+1]; vis[src] = true;
        Arrays.fill(dis, Integer.MAX_VALUE); dis[src] = 0;
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            vis[curr] = false;
            for (Edge e : arr[curr]) {
                if (dis[curr] + e.w < dis[e.n]) {
                    dis[e.n] = dis[curr] + e.w;
                    if (!vis[e.n]) {
                        queue.add(e.n);
                        vis[e.n] = true;
                    }
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
