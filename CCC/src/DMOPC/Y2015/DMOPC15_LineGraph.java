package DMOPC.Y2015;

import java.util.*;
import java.io.*;

public class DMOPC15_LineGraph {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = readInt(), K = readInt();
        PriorityQueue<Edge> arr = new PriorityQueue<>();
        for (int i = 1; i < N; i++) { // Build Graph
            arr.add(new Edge(i, i+1, readInt()));
            if (i + K <= N) arr.add(new Edge(i, i+K, 0));
        }
        int edgeCount = 0, weight = 0;
        int[] par = new int[N+1];
        for (int i = 1; i <= N; i++) par[i] = i;
        while (edgeCount < N-1) {
            Edge e = arr.poll();
            if (par[e.n1] != par[e.n2]) {
                edgeCount++; weight += e.d;
                merge(e.n1, e.n2, par, N);
            }
        }
        System.out.println(weight);
    }

    static void merge (int A, int B, int[] par, int N) {
        int a = Math.min(A, B), b = Math.max(A, B);
        for (int i = 1; i <= N; i++) {
            if (par[i] == b) par[i] = a;
        }
    }

    static class Edge implements Comparable<Edge> {
        int n1, n2, d; // destination node, distance
        Edge (int pn1, int pn2, int pd) { n1 = pn1; n2 = pn2; d = pd; }
        public int compareTo (Edge other) { return d - other.d; }
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
