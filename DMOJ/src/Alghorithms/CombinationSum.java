package Alghorithms;

// Supports repeating values

import java.util.*;
import java.io.*;

public class CombinationSum {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    static int N, arr[], M;

    public static void main(String[] args) throws IOException {
        N = readInt(); arr = new int[N+1]; M = readInt();
        for (int i = 0; i < N; i++) arr[i] = readInt();
        run (0, 0, new ArrayList<>());
    }

    static void run (int idx, int sum, ArrayList<Integer> list) {
        if (sum == M) {
            for (int i : list) System.out.println(i);
            return;
        }
        ArrayList<Integer> newlist = new ArrayList<>();
        newlist.addAll(list);
        for (int i = idx; i < M; i++) {
            if (sum + arr[i] <= M) {
                newlist.add(arr[i]);
                run(i, sum + arr[i], newlist);
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
