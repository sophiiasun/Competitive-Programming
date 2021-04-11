package CCC.Y2017;

import java.io.*;
import java.util.*;

public class S17Q4_MinimumCostFlow {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    static int N, M, D, par[];
    static ArrayList<Pipe> adj;

    public static void main(String[] args) throws IOException {
        N = readInt(); M = readInt(); D = readInt();
        adj = new ArrayList<>();
        for (int i = 1; i < N; i++) // First N-1 pipes (old)
            adj.add(new Pipe(readInt(), readInt(), readInt(), 0));
        for (int i = N; i <= M; i++) // Next N-M pipes (new)
            adj.add(new Pipe(readInt(), readInt(), readInt(), 1));
        Collections.sort(adj);

        par = new int[N+1];
        for (int i = 1; i <= N; i++) par[i] = i;
        int idx = 0, edges = 0, days = 0;
        for (; edges < N-1; idx++) { // Kruskal
            int n1f = find(adj.get(idx).n1), n2f = find(adj.get(idx).n2);
            if (n1f != n2f) {
                par[n1f] = n2f; edges++;
                if (adj.get(idx).s == 1) days++;
            }
        }
        idx--;

        if (D != 0 && adj.get(idx).s == 1 && adj.get(idx).c < D) { // MUST BE A NEW PIPE AND LESS THAN D
            int maxC = adj.get(idx).c;
            par = new int[N+1];
            for (idx = 1; idx <= N; idx++) par[idx] = idx; // Initialize all node-parents as self
            for (idx = 0; adj.get(idx).c < maxC || (adj.get(idx).c == maxC && adj.get(idx).s == 0); idx++) { // Build new graph
                int n1f = find(adj.get(idx).n1), n2f = find(adj.get(idx).n2);
                if (n1f != n2f) par[n1f] = n2f; // Merge
            }
            for (; idx < M && adj.get(idx).c <= D; idx++) {
                if (adj.get(idx).s == 0 && find(adj.get(idx).n1) != find(adj.get(idx).n2)) { // Old pipe can be used
                    System.out.println(days - 1); return;
                }
            }
        }
        System.out.println(days);
    }

    static int find(int A) {
        return par[A] = (par[A]==A) ? A : find(par[A]);
    }

    static class Pipe implements Comparable<Pipe> { // node1, node2, cost, status (old=0/new=1)
        int n1, n2, c, s;
        Pipe (int pn1, int pn2, int pc, int ps) { n1 = pn1; n2 = pn2; c = pc; s = ps; }
        public int compareTo (Pipe p) {
            if (c == p.c) return s - p.s;
            return c - p.c;
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
