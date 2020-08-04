package CCC.Y2013;

import java.util.*;
import java.io.*;

public class S13Q4_WhoIsTaller {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    static ArrayList<Integer>[] arr;
    static int N, M, P, Q;

    public static void main(String[] args) throws IOException {
        N = readInt(); M = readInt();
        arr = new ArrayList[N+1];
        for (int i = 1; i <= N; i++)
            arr[i] = new ArrayList<>();
        for (int i = 0; i < M; i++)
            arr[readInt()].add(readInt());
        P = readInt(); Q =readInt();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(P); queue.add(Q);
        boolean[] vis = new boolean[N+1];
        while(!queue.isEmpty()) {
            int curr = queue.poll();
            for (int i : arr[curr]) {
                if (!vis[i]) {
                    vis[i] = true;
                    if (i == P) {
                        System.out.println("no"); System.exit(0);
                    } else if (i == Q) {
                        System.out.println("yes"); System.exit(0);
                    }
                    queue.add(i);
                }
            }
        }
        System.out.println("unknown");
    }

    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens())
            st = new StringTokenizer(br.readLine().trim());
        return st.nextToken();
    }
    static int readInt() throws IOException {
        return Integer.parseInt(next());
    }
}
