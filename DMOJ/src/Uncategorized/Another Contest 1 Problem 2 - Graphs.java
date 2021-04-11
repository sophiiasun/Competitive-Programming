package Uncategorized;

import java.util.*;
import java.io.*;

public class AnotherContest1Problem2_Graphs {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    static int N, M, Q, MAX;
    static ArrayList<Integer>[] adj;

    public static void main(String[] args) throws IOException {
        N = readInt(); M = readInt(); Q = readInt(); MAX = Integer.MAX_VALUE;
        adj = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) adj[i] = new ArrayList<>();
        int a, b;
        for (int i = 0; i < M; i++) { a = readInt(); b = readInt(); adj[a].add(b); adj[b].add(a); }

        for (int q = 0; q < Q; q++) {
            bfs(readInt(), readInt());
        }
    }

    static void bfs (int a, int b) {
        Queue<Integer> q1 = new LinkedList<>(); Queue<Integer> q2 = new LinkedList<>();
        int[] d1 = new int[N+1], d2 = new int[N+1];
        Arrays.fill(d1, MAX); Arrays.fill(d2, MAX);
        q1.add(a); q2.add(b); d1[a] = 0; d2[b] = 0;
        while (!q1.isEmpty() || !q2.isEmpty()) {
            if (!q1.isEmpty()) {
                int curr = q1.poll();
                for (int i : adj[curr]) {
                    if (d2[i] != MAX) { System.out.println(d1[curr] + d2[i] + 1); return; }
                    if (d1[i] != MAX) continue;
                    d1[i] = d1[curr] + 1; q1.add(i);
                }
            }
            if (!q2.isEmpty()) {
                int curr = q2.poll();
                for (int i : adj[curr]) {
                    if (d1[i] != MAX) { System.out.println(d1[i] + d2[curr] + 1); return; }
                    if (d2[i] != MAX) continue;
                    d2[i] = d2[curr] + 1; q2.add(i);
                }
            }
        }
        System.out.println(-1);
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
