package APIO;

import java.util.*;
import java.io.*;

public class APIO10P2_Patrol {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    static int N, K, par[], maxD1 = 0, maxD2 = 0, maxN1, maxN2 = 0;
    static ArrayList<Integer>[] adj;
    static HashMap<Integer, C> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        N = readInt(); K = readInt(); par = new int[N+1];  adj = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) adj[i] = new ArrayList<>();
        for (int i = 1; i < N; i++) { // init graph
            int a = readInt(), b = readInt();
            adj[a].add(b); adj[b].add(a);
        }
        dfs(-1, 1, 0);
        maxN1 = maxN2; maxN2 = 0; maxD1 = 0;
        Arrays.fill(par, 0);
        dfs(-1, maxN1, 0);
        if (K == 2) {
            int prev = -1;
            for (int i = maxN2; i != maxN1; i = par[i]) {
                map.put(i, new C(prev, par[i])); prev = i;
            }
            map.put(maxN1, new C(prev, -1));
            dfs2(1, 1);
        }
        System.out.println(((N-1)<<1) - maxD2 - maxD1 + K);
    }

    static int dfs2 (int prev, int curr) {
        int high1 = 0, high2 = 0;
        for (int i : adj[curr]) {
            if (i != prev) {
                int tmp = dfs2(curr, i);
                if (!map.containsKey(curr) || (map.get(curr).c != i && map.get(curr).p != i)) tmp++;
                else tmp--;
                if (tmp > high1) { high2 = high1; high1 = tmp; }
                else if (tmp > high2) high2 = tmp;
            }
        }
        maxD2 = Math.max(maxD2, high1 + high2);
        return high1;
    }

    static void dfs (int prev, int curr, int currD) {
        if (currD > maxD1) { maxD1 = currD; maxN2 = curr; }
        for (int i : adj[curr]) {
            if (i != prev) { par[i] = curr; dfs(curr, i, currD+1); }
        }
    }

    static class C {
        int c, p;
        C (int cc, int pp) { c = cc; p = pp; }
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
