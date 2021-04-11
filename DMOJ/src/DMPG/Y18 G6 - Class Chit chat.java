package DMPG;

import java.util.*;
import java.io.*;

public class DMPG18_ClassChitchat {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    static int N, C, K;
    static long a[], dis[];
    static ArrayList<Integer>[] adj, adj2;

    public static void main(String[] args) throws IOException {
        N = readInt(); C = readInt(); K = readInt(); a = new long[N+1]; dis = new long[N+1];
        adj = new ArrayList[N+1]; adj2 = new ArrayList[C+1];
        for (int i = 1; i <= N; i++) adj[i] = new ArrayList<>();
        for (int i = 1; i <= C; i++) adj2[i] = new ArrayList<>();
        for (int i = 1; i <= N; i++) a[i] = readLong();
        for (int i = 1, x; i <= N; i++) {
            x = readInt();
            for (int j = 0, y; j < x; j++) { y = readInt(); adj[i].add(y); adj2[y].add(i); }
        } // adj : students -> { classes }
        // adj2 : class -> { students }

        Queue<Integer> q = new LinkedList<>(); q.add(1); // contains students
        Arrays.fill(dis, Long.MAX_VALUE); dis[1] = 0;
        while (!q.isEmpty()) {
            int curr = q.poll();
            for (int c : adj[curr]) { // classes of curr
                for (int i : adj2[c]) { // students of classes of curr
                    if (i == curr || dis[curr] + Math.abs(a[i] - a[curr]) + K >= dis[i]) continue;
                    dis[i] = Math.abs(a[i] - a[curr]) + K + dis[curr];
                    q.add(i);
                }
            }
        }

        for (int i = 1; i <= N; i++) System.out.println(dis[i]==Long.MAX_VALUE ? -1 : dis[i]);
    }

    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens())
            st = new StringTokenizer(br.readLine().trim());
        return st.nextToken();
    }
    static int readInt () throws IOException {
        return Integer.parseInt(next());
    }
    static long readLong () throws IOException {
        return Long.parseLong(next());
    }
}
