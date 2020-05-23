package COCI;

import java.util.*;
import java.io.*;

public class COCI06_Bicikli {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    static int N, M;
    static ArrayList<Integer>[] arr;
    static boolean run = true;

    public static void main(String[] args) throws IOException {
        N = readInt(); M = readInt();
        arr = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) arr[i] = new ArrayList<>(); // Initialize
        for (int i = 0; i < M; i++) arr[readInt()].add(readInt()); // Input
        dfs(1, new BitSet(N+1));
        if (!run) { System.out.println("inf"); return; } // Infinite paths : cyclic

    }

    static void dfs(int start, BitSet bs) { // return true if no cycle, false if cycle
        if (!run) return;
        for (int i : arr[start]) {
            BitSet next = new BitSet(N+1); next.or(bs); next.set(start, true);
            dfs(i, next);
            if (!bs.get(i)) dfs(i, next);
            else run = false;
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
