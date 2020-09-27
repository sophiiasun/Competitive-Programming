package DMOPC.Y2014.C5;

import java.util.*;
import java.io.*;

public class P6_SaveNagato {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    static int N, max;
    static ArrayList<Integer>[] adj;

    public static void main(String[] args) throws IOException {
        N = readInt(); int a , b, dis1[] = new int[N+1], dis2[] = new int[N+1];
        adj = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) adj[i] = new ArrayList<>();
        for (int i = 1; i < N; i++) { // Input
            a = readInt(); b = readInt(); adj[a].add(b); adj[b].add(a);
        }
        BFS(1, dis1); // Find furthest node from 1
        int tmp1 = max; BFS(tmp1, dis1); // Calculates distance to every node from furthest node in graph
        int tmp2 = max; BFS(tmp2, dis2);
        for (int i = 1; i <= N; i++) System.out.println(Math.max(dis1[i], dis2[i]) + 1);
    }

    static void BFS (int root, int[] dis) {
        Arrays.fill(dis, -1); dis[root] = 0;
        Queue<Integer> queue = new LinkedList<>();
        int high = 0; queue.add(root);
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            if (dis[curr] > high) { high = dis[curr]; max = curr; }
            for (int i : adj[curr]) {
                if (dis[i] == -1) {
                    queue.add(i); dis[i] = dis[curr] + 1;
                }
            }
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
