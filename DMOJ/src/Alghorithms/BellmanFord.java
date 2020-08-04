package Alghorithms;

import java.util.*;
import java.io.*;

// PSEUDO CODE:
/*
 * dist[] : dis[i] = infinity
 * for each edge: (S, E, W)
 *      if dist[S] + W < dist[E]
 *          then dis[E] = dis[S] + W
 *
 */

public class BellmanFord {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = readInt(), M = readInt(), P = readInt();
        Edge[] arr = new Edge[N];
        for (int i = 0; i < N; i++) arr[i] = new Edge(readInt(), readInt(), readInt());
        int[] dis = new int[N]; Arrays.fill(dis, Integer.MAX_VALUE);
        int S, E, W;
        for (int i = 0; i < N-1; i++) {
            for (int j = 0; j < M; j++) {
                S = arr[j].S; E = arr[j].E; W = arr[j].W;
                if (dis[S] != Integer.MAX_VALUE && dis[S]+W < dis[E])
                    dis[E] = dis[S] + W;
            }
        }
    }

    static class Edge {
        int S, E, W;
        Edge (int s, int e, int w) {
            S = s; E = e; W = w;
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
