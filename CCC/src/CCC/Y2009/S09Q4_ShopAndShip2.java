package CCC.Y2009;

import java.util.*;
import java.io.*;

public class S09Q4_ShopAndShip2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int T = Integer.parseInt(br.readLine());
        int[][] arr = new int[N+1][N+1];
        String[] in;
        for (int i = 0; i < T; i++) {
            in = br.readLine().split(" ");
            int a = Integer.parseInt(in[0]), b = Integer.parseInt(in[1]), c = Integer.parseInt(in[2]);
            arr[a][b] = c;
            arr[b][a] = c;
        }
        int K = Integer.parseInt(br.readLine());
        int[] city = new int[K];
        int[] price = new int[K];
        for (int i = 0; i < K; i++) {
            in = br.readLine().split(" ");
            city[i] = Integer.parseInt(in[0]); price[i] = Integer.parseInt(in[1]);
        }
        int D = Integer.parseInt(br.readLine());

        boolean[] vis = new boolean[N+1];
        int[] cost = new int[N+1];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[D] = 0;

        for (int i = 0; i < N; i++) {
            int min = Integer.MAX_VALUE;
            int index = -1;
            for (int j = 1; j <= N; j++) {
                if (!vis[j] && cost[j] < min) {
                    min = cost[j];
                    index = j;
                }
            }
            if (index == -1)
                break;
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
}
