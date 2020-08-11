package WAC;

import java.util.*;
import java.io.*;

public class P4 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    static int N, Q;
    static ArrayList<Integer>[] adj;

    public static void main(String[] args) throws IOException {
        N = readInt(); Q = readInt(); adj = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) adj[i] = new ArrayList<>();
        for (int i = 1, x, y; i < N; i++) { x = readInt(); y = readInt(); adj[x].add(y); adj[y].add(x); }
        for (int q = 0; q < Q; q++) {
            int a = readInt(), b = readInt(), c = readInt(), d = readInt();
            bsf (a, b, c, d);
        }
    }

    static void bsf (int a, int b, int c, int d) {
        if (a == c) { System.out.println(0); return; }
        PriorityQueue<C> pq1 = new PriorityQueue<>(), pq2 = new PriorityQueue<>();
        int d1[] = new int[N+1], d2[] = new int[N+1]; d1[a] = d2[c] = 0;
        Arrays.fill(d1, -1); Arrays.fill(d2, -1);
        pq1.add(new C(a, 0)); pq2.add(new C(c, 0));
        while (!pq1.isEmpty() || !pq2.isEmpty()) {
            if (!pq1.isEmpty()) {
                // run wesley
                C cur = pq1.poll();
                for (int i : adj[cur.n]) {
                    if (i == b) { System.out.println(-1); return; }
                    if (d2[i] == cur.d + 1) { System.out.println(d2[i]); return; }
                    if (d1[i] != -1) continue;
                    d1[i] = cur.d + 1; pq1.add(new C(i, d1[i]));
                }
            }
            if (!pq2.isEmpty()) {
                // run guard
                C cur = pq2.poll();
                for (int i : adj[cur.n]) {
                    if (i == d) { d2[i] = cur.d + 1; pq2.clear(); }
                    if (d1[i] == cur.d + 1) { System.out.println(d1[i]); return; }
                    if (d2[i] != -1) continue;
                    d2[i] = cur.d + 1; pq2.add(new C(i, d2[i]));
                }
            }
        }
        System.out.println(-1);
    }

    static class C implements Comparable<C> {
        int n, d;
        C (int nn, int dd) { n = nn; d = dd; }
        public int compareTo(C o) { return d = o.d; }
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
