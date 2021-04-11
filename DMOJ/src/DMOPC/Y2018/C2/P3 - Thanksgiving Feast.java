package DMOPC.Y2018.C2;

import java.util.*;
import java.io.*;

public class P3_ThanksgivingFeast {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = readInt(), M = readInt(), K = readInt(), A = readInt(), B = readInt(), storeCount = 0, ans = Integer.MAX_VALUE;
        int storeNode[] = new int[K], dis[] = new int[N+1], dis2[] = new int[N+2];
        boolean[] stores = new boolean[N+1]; ArrayList<Integer>[] adj = new ArrayList[N+1]; Queue<Integer> queue = new LinkedList<>();
        for (int i = 0, x; i < K; i++) { x = readInt(); stores[x] = true; storeNode[i] = x; }
        for (int i = 1; i <= N; i++) adj[i] = new ArrayList<>(); // init adj
        for (int i = 0, a, b; i < M; i++) { a = readInt(); b = readInt(); adj[a].add(b); adj[b].add(a); } // build adj
        if (stores[A]) storeCount = 1;
        Arrays.fill(dis, -1); Arrays.fill(dis2, -1); dis[A] = dis2[B] = 0; queue.add(A);
        while(!queue.isEmpty() && storeCount != K) {
            int curr = queue.poll();
            for (int i : adj[curr]) {
                if (dis[i] == -1) {
                    dis[i] = dis[curr] + 1;
                    if (stores[i]) storeCount++;
                    queue.add(i);
                }
            }
        }
        storeCount = 0; queue.clear(); queue.add(B);
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            for (int i : adj[curr]) {
                if (dis2[i] == -1) {
                    dis2[i] = dis2[curr] + 1;
                    if (stores[i]) storeCount++;
                    queue.add(i);
                }
            }
        }
        for (int i = 0; i < K; i++) ans = Math.min(ans, dis[storeNode[i]] + dis2[storeNode[i]]);
        System.out.println(ans);
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
