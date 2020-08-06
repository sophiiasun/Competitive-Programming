package GFSSOC;

import java.util.*;
import java.io.*;

public class Raider {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    static int N, M, in[], low[], id[], dfn[], cnt=1, idx=1, c[], mod = 1000000007;
    static C dp[][];
    static boolean inStack[], vis[];
    static ArrayList<Integer>[] adj, dag;
    static Stack<Integer> stk = new Stack<>();

    public static void main(String[] args) throws IOException {
        N = readInt(); M = readInt(); adj = new ArrayList[N+1]; dag = new ArrayList[N+1]; dp = new C[N+1][2]; c = new int[N+1];
        low = new int[N+1]; id = new int[N+1]; dfn = new int[N+1]; inStack = new boolean[N+1]; vis = new boolean[N+1]; in = new int[N+1];
        for (int i = 1; i <= N; i++) { // initialize
            adj[i] = new ArrayList<>(); dag[i] = new ArrayList<>(); in[i] = readInt();
            dp[i][0] = new C(-1, -1); dp[i][1] = new C(-1, -1);
        }
        for (int i = 1; i <= M; i++) adj[readInt()].add(readInt()); // build initial graph
        Arrays.fill(low, -1); Arrays.fill(dfn, -1);
        for (int i = 1; i <= N; i++) { if (!vis[i]) tarjan(i); } // find scc
        build();
        for (int i = 1; i <= N; i++) c[id[i]] += in[i]; // merge costs based on scc
        C ans = dfs(id[1], 1);
        System.out.println(ans.n + " " + ans.c);
    }

    static C dfs(int cur, int take) { // cur node, takeable or not
        if (dp[cur][take].n != -1 && dp[cur][take].c != -1) return new C (dp[cur][take].n, dp[cur][take].c);
        if (cur == id[N]) { // reached end
//            return new C(take==1 ? c[cur] : 0, 1);
            dp[cur][take] = new C(take==1 ? c[cur] : 0, 1);
            return new C (dp[cur][take].n, dp[cur][take].c);
        }
        C cc = new C(0, 0);
        for (int i : dag[cur]) {
            for (int j = take^1; j <= 1; j++) {
                C d = dfs(i, j);
                if (j==0) d.n += c[cur]; // take
                if (d.n > cc.n) { cc.n = d.n; cc.c = d.c; } // new high
                else if (d.n == cc.n) cc.c = (cc.c + d.c) % mod; // increase count
            }
        }
        dp[cur][take] = cc;
        return new C(cc.n, cc.c);
    }

    static void build () {
        for (int i = 1; i <= N; i++) {
            for (int j : adj[i]) { if (id[i] != id[j]) dag[id[i]].add(id[j]); }
//            adj[i].clear();
        }
    }

    static void tarjan (int src) {
        stk.push(src);
        low[src] = dfn[src] = idx++;
        inStack[src] = vis[src] = true;
        for (int i : adj[src]) {
            if (dfn[i] == -1) { tarjan(i); low[src] = Math.min(low[src], low[i]); }
            else if (inStack[i]) low[src] = Math.min(low[src], dfn[i]);
        }
        if (dfn[src] == low[src]) {
            while (stk.peek() != src) {
                int tmp = stk.peek(); stk.pop();
                id[tmp] = cnt; inStack[tmp] = false;
            }
            int tmp = stk.peek(); stk.pop();
            id[tmp] = cnt++; inStack[tmp] = false;
        }
    }

    static class C{
        long n, c;
        C (long nn, long cc) { n = nn; c = cc; }
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
