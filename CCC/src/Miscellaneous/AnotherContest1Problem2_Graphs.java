package Miscellaneous;

import java.util.*;
import java.io.*;

public class AnotherContest1Problem2_Graphs {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = readInt(), M = readInt(), Q = readInt();
        ArrayList<Integer>[] arr = new ArrayList[N+1];
        for (int i = 0; i < N; i++) arr[i] = new ArrayList<>();
        int a, b;
        for (int i = 0; i < M; i++) {
            a = readInt(); b = readInt();
            arr[a].add(b); arr[b].add(a);
        }
        for (int i = 0; i < Q; i++) {
            Queue<Integer> queue1 = new LinkedList<>(); Queue<Integer> queue2 = new LinkedList<>();
            boolean[] vis1 = new boolean[N+1], vis2 = new boolean[N+1];
            a = readInt(); b = readInt();
            queue1.add(a); queue2.add(b); vis1[a] = true; vis2[b] = true;
            while (!queue1.isEmpty() || !queue2.isEmpty()) {
                if (!queue1.isEmpty()) {
                    int curr = queue1.poll();

                }
            }
        }
    }

    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens())
            st = new StringTokenizer(br.readLine().trim());
        return st.nextToken();
    }
    static long readLong () throws IOException {
        return Long.parseLong(next());
    }
    static int readInt () throws IOException {
        return Integer.parseInt(next());
    }
    static double readDouble () throws IOException {
        return Double.parseDouble(next());
    }
    static char readCharacter () throws IOException {
        return next().charAt(0);
    }
    static String readLine () throws IOException {
        return br.readLine().trim();
    }
}
