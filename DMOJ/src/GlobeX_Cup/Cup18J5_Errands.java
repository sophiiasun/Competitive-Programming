package GlobeX_Cup;

import java.util.*;
import java.io.*;

public class Cup18J5_Errands {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = readInt(), M = readInt(), Q = readInt(), C = readInt(), a, b;
        int[] bfs = new int[N+1]; Arrays.fill(bfs, -1); bfs[C] = 0; // Stores distance from C to all other nodes
        ArrayList<Integer>[] arr = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) arr[i] = new ArrayList<>(); // Initialize
        for (int i = 0; i < M; i++) { // Build graph
            a = readInt(); b = readInt();
            arr[a].add(b); arr[b].add(a);
        }

        Queue<Integer> queue = new LinkedList<>(); queue.add(C);
        boolean[] vis = new boolean[N+1]; vis[C] = true;
        while (!queue.isEmpty()) { // BFS From C to all other nodes
            int curr = queue.poll();
            for (int i : arr[curr]) {
                if (!vis[i]) {
                    bfs[i] = bfs[curr] + 1; vis[i] = true; queue.add(i);
                }
            }
        }

        for (int i = 0; i < Q; i++) { // Run queries
            a = readInt(); b = readInt();
            if (bfs[a] == -1 || bfs[b] == -1) System.out.println("This is a scam!");
            else System.out.println(bfs[a] + bfs[b]);
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
