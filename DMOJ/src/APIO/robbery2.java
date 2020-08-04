package APIO;

import java.util.*;
import java.io.*;

public class robbery2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    static int N, M, S, P, c[], cash[], low[], arr[], dfn[], ans = 0, cnt = 1, idx = 1;
    static boolean vis[], inStack[], p[], taken[];
    static ArrayList<Integer>[] adj, dag;
    static Deque<Integer> stack = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        N = ri(); M = ri(); c = new int[N+1]; low = new int[N+1]; cash = new int[N+1]; arr = new int[N+1]; dfn = new int[N+1];
        vis = new boolean[N+1]; inStack = new boolean[N+1]; p = new boolean[N+1]; taken = new boolean[N+1];
        adj = new ArrayList[N+1]; dag = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) { adj[i] = new ArrayList<>(); dag[i] = new ArrayList<>(); }
        for (int i = 1; i <= M; i++) adj[ri()].add(ri());
        Arrays.fill(dfn, -1); Arrays.fill(arr, -1);
        for (int i = 1; i <= N; i++) {
            if (!vis[i]) scc(i);
        } dag();
        for (int i = 1; i <= N; i++) { c[low[i]] += ri(); }
        S = ri(); P = ri();
        for (int i = 1; i <= P; i++) p[low[ri()]] = true;
        bfs();
        System.out.println(ans);
    }

    static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        S = low[S]; q.add(S); cash[S] = c[S];
        Arrays.fill(vis, false); vis[S] = true;
        while (!q.isEmpty()) {
            int curr = q.poll(); vis[curr] = false;
            if (p[curr]) ans = Math.max(ans, cash[curr]);
            for (int i : dag[curr]) {
                if (cash[curr] + c[i] <= cash[i]) continue;
                cash[i] = cash[curr] + c[i];
                if (!vis[i]) { vis[i] = true; q.add(i); }
            }
        }
    }

    static void dag() {
        for (int i = 1; i <= N; i++) {
            for (int j : adj[i]) { if (low[i] != low[j]) dag[low[i]].add(low[j]); }
            adj[i].clear();
        }
    }

    static void scc(int src) {
        stack.addLast(src);
        arr[src] = dfn[src] = idx++;
        inStack[src] = vis[src] = true;
        for (int i : adj[src]) {
            if (dfn[i] == -1) {
                scc(i); arr[src] = Math.min(arr[src], arr[i]);
            } else if (inStack[i]) arr[src] = Math.min(arr[src], dfn[i]);
        }

        if (dfn[src] == arr[src]) {
            while (stack.peekLast() != src) {
                // from same
                int tmp = stack.pollLast();
                low[tmp] = cnt; inStack[tmp] = false;
            }
            // from new
            int tmp = stack.pollLast();
            low[tmp] = cnt++; inStack[tmp] = false;
        }
    }

    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens())
            st = new StringTokenizer(br.readLine().trim());
        return st.nextToken();
    }
    static int ri () throws IOException {
        return Integer.parseInt(next());
    }
}
