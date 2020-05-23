package Uncategorized;

import java.util.*;
import java.io.*;

public class FunInForag {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    static int N, M, A, B, start, end, mid;
    static long C;
    static ArrayList<Edge>[] list;
    static long[] dis;

    public static void main(String[] args) throws IOException {
        N = readInt(); M = readInt(); int a, b, c;
        list = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) list[i] = new ArrayList<>();
        for (int i = 1; i <= M; i++) { // Obtain input
            a = readInt(); b = readInt(); c = readInt();
            list[a].add(new Edge(b, c, i)); list[b].add(new Edge(a, c, i));
        }
        A = readInt(); B = readInt(); C = readLong();
        mid = M;

        dis = new long[N+1];

        int min = -1;
        start = 1; end = M;
        while (start <= end) {
            mid = (start + end) >> 1;
            dijkstra();
            if (dis[B] <= C) {
                end = mid - 1; min = mid;
            } else start = mid + 1;
        }

        System.out.println(min);
    }

    static void dijkstra(){
        PriorityQueue<Edge> queue = new PriorityQueue<>();
        Arrays.fill(dis, Integer.MAX_VALUE); dis[A] = 0;

        // Queue int[]: { node, distance, pass }
        //  List int[]: { node, distance, pass }

        queue.add(new Edge(A, 0, 0));
        while (!queue.isEmpty()) {
            Edge curr = queue.poll();
            if (curr.d > dis[curr.n] || curr.d > C) continue;
            for (Edge e : list[curr.n]) {
                if (e.p <= mid && dis[e.n] > dis[curr.n] + e.d) {
                    dis[e.n] = e.d + dis[curr.n];
                    queue.add(new Edge(e.n, dis[e.n], e.p));
                    if (dis[B] <= C) return;
                }
            }
        }
    }

    static class Edge implements Comparable<Edge> {
        int n, p; // node, distance, pass
        long d;
        public Edge(int node, long distance, int pass) { n = node; d = distance; p = pass; }
        public int compareTo(Edge a){
            return Long.compare(p, a.p);
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
}
