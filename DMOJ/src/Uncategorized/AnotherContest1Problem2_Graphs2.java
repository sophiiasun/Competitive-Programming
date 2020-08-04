package Uncategorized;

import java.util.*;
import java.io.*;

public class AnotherContest1Problem2_Graphs {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = readInt(), M = readInt(), Q = readInt(), a, b, par[] = new int[N+1];
        for (int i = 1; i <= N; i++) par[i] = i; // Initialize unions
        ArrayList<Integer>[] arr = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) arr[i] = new ArrayList<>();
        for (int i = 0; i < M; i++) { // Build graph
            a = readInt(); b = readInt();
            arr[a].add(b); arr[b].add(a);
            merge(a, b, par);
        }


        for (int n = 0; n < Q; n++) { // Q queries
            a = readInt(); b = readInt(); boolean found = false;

            if (a == b) { System.out.println(0); continue; }
            else if (par[a] != par[b]) { System.out.println(-1); continue; }

            Queue<Integer> queue = new LinkedList<>(); queue.add(a); queue.add(b);
            

//            while (!q1.isEmpty() || !q2.isEmpty()) { // RUN BFS SIMULTANEOUSLY FROM BOTH ENDS
                // Run from start node

//            }
            if (!found) System.out.println(-1);
        }
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
