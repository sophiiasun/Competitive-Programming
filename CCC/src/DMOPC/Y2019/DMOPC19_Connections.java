package DMOPC.Y2019;

import java.io.*;
import java.util.*;

public class DMOPC19_Connections {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = readInt(), pop[] = new int[N+1], a, b;
        ArrayList<Integer>[] adj = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            pop[i] = readInt(); adj[i] = new ArrayList<>();
        }
        for (int i = 1; i < N; i++) {
            a = readInt(); b = readInt();
            adj[a].add(b); adj[b].add(a);
        }
        long ans = Integer.MAX_VALUE    ;



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
