package DMOPC.Y2015;

import java.util.*;
import java.io.*;

public class DMOPC15_AriadnesThread {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<20);
    static StringTokenizer st;

    static int N, Q, arr1[][], dis[], root = -1;

    public static void main(String[] args) throws IOException {
        N = readInt(); dis = new int[N+1];
        int n, a, b, c; boolean[] check = new boolean[N+1];
        for (int i = 1; i <= N; i++) {
            n = readInt(); arr1[i] = new int[n];
            for (int j = 1; j <= n; j++) { arr1[i][j] = readInt(); check[arr1[i][j]] = true; }
        }
        for (int i = 1; root==-1; i++) root = !check[i] ? i : -1; // find root
        BFS(); Q = readInt();
        for (int i = 1; i <= Q; i++) {
            a = readInt(); b = readInt();

        }
    }

    static boolean LCA (int a, int b) {
        boolean ba = false, bb = false;
//        for (int i : )
        return false;
    }

    static void BFS () {
        Arrays.fill(dis, -1);
        Queue<Integer> queue = new LinkedList<>();
        queue.add(root); dis[root] = 0;
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            for (int i : arr1[curr]) {
                if (dis[i] == -1) {
                    dis[i] = dis[curr] + 1;
                    queue.add(i);
                }
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
