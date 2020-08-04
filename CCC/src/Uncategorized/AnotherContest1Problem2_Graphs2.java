package Uncategorized;

import java.util.*;
import java.io.*;

public class AnotherContest1Problem2_Graphs2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    static Queue<Integer> q1 = new LinkedList<>(), q2 = new LinkedList<>();
    static int[] d1, d2;
    static ArrayList<Integer>[] arr;

    public static void main(String[] args) throws IOException {
        int N = readInt(), M = readInt(), Q = readInt(), a, b, par[] = new int[N+1];
        for (int i = 1; i <= N; i++) par[i] = i; // Initialize unions
        arr = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) arr[i] = new ArrayList<>();
        for (int i = 0; i < M; i++) { // Build graph
            a = readInt(); b = readInt();
            arr[a].add(b); arr[b].add(a);
            merge(a, b, par);
        }
        d1 = new int[N+1]; d2 = new int[N+1];
        for (int n = 0; n < Q; n++) { // Q queries
            a = readInt(); b = readInt();
            if (par[a] != par[b]) { System.out.println(-1); continue; } // Not part of the same tree
            System.out.println(doBFS(a, b));
        }
    }

    static int doBFS(int a, int b) {
        Arrays.fill(d1, -1); Arrays.fill(d2, -1); q1.clear(); q2.clear();
        q1.add(a); q2.add(b); d1[a] = 0; d2[b] = 0;
        while (!q1.isEmpty() || !q2.isEmpty()) { // RUN BFS SIMULTANEOUSLY FROM BOTH ENDS
            // Run from start node
            if (!q1.isEmpty()) {
                int curr = q1.poll();
                for (int i : arr[curr]) {
                    if (d1[i] == -1) { // not visited
                        d1[i] = d1[curr] + 1; q1.add(i);
                    }
                    if (d2[i] != -1) { // reached from both ends
                        return d1[i] + d2[i];
                    }
                }
            }

            // Run from end node
            if (!q2.isEmpty()) {
                int curr = q2.poll();
                for (int i : arr[curr]) {
                    if (d2[i] == -1) { // not visited
                        d2[i] = d2[curr] + 1;
                    }
                    if (d1[i] != -1) { // reached from both sides
                        return d1[i] + d2[i];
                    }
                }
            }
        }
        return -1;
    }

    static void merge (int a, int b, int[] arr) {
        int A = Math.min(a, b), B = Math.max(a, b);
        for (int i = 1; i < arr.length; i++) { // Always take smaller value
            if (arr[i] == B) arr[i] = A;
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
