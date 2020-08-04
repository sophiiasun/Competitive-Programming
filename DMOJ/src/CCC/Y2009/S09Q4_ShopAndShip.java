package CCC.Y2009;

import java.util.*;
import java.io.*;

public class S09Q4_ShopAndShip {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = readInt(), T = readInt(), a, b, c;
        int[][] arr = new int[N+1][N+1];
        for (int i = 0; i < T; i++) {
            a = readInt(); b = readInt(); c = readInt();
            arr[a][b] = arr[b][a] = c;
        }
        int K = readInt();
        int[] city = new int[K], price = new int[K], cost = new int[N+1];
        for (int i = 0; i < K; i++) {
            city[i] = readInt(); price[i] = readInt();
        }
        int D = readInt();

        boolean[] vis = new boolean[N+1];
        Arrays.fill(cost, Integer.MAX_VALUE); cost[D] = 0;

        for (int i = 0; i < N; i++) { // Dijkstra
            int min = Integer.MAX_VALUE, index = -1;
            for (int j = 1; j <= N; j++) {
                if (!vis[j] && cost[j] < min) {
                    min = cost[j];
                    index = j;
                }
            }
            if (index == -1) break;
            vis[index] = true;
            for (int j = 1; j <= N; j++) {
                if (!vis[j] && arr[index][j] > 0 && cost[index] + arr[index][j] < cost[j])
                    cost[j] = cost[index] + arr[index][j];
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < K; i++) {
            if (cost[city[i]] != Integer.MAX_VALUE)
                min = Math.min(min, cost[city[i]] + price[i]);
        }

        System.out.println(min);
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
