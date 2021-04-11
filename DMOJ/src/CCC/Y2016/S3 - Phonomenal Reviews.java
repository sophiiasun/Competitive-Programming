package CCC.Y2016;

import java.util.*;
import java.io.*;

public class S16Q3_PhonomenalReviews {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    static int N, M, a, b, diam = 0, cnt = 0, lastNode, firstNode;
    static ArrayList<Integer>[] adj;
    static boolean pho[], val[];

    public static void main(String[] args) throws IOException {
        N = readInt(); M = readInt(); adj = new ArrayList[N]; pho = new boolean[N]; val = new boolean[N];
        for (int i = 0; i < N; i++) adj[i] = new ArrayList<>();
        firstNode = readInt(); pho[firstNode] = true;
        for (int i = 1; i < M; i++) { pho[readInt()] = true; }
        for (int i = 1; i < N; i++) { a = readInt(); b = readInt(); adj[a].add(b); adj[b].add(a); }
        dfs(firstNode, -1);
        diam(firstNode, -1, 0);
        diam(lastNode, -1, 0);
        System.out.println(2*(cnt-1) - diam);
    }

    static void diam(int curr, int prev, int currDiam) {
        if (currDiam > diam) { diam = currDiam; lastNode = curr; }
        for (int i : adj[curr]) {
            if (i == prev || !val[i]) continue;
            diam(i, curr, currDiam+1);
        }
    }

    static void dfs(int curr, int prev) {
        val[curr] = pho[curr];
        for (int i : adj[curr]) {
            if (i == prev) continue;
            dfs(i, curr);
            val[curr] |= val[i];
        }
        if (val[curr]) cnt++;
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
