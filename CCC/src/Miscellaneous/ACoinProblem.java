package Miscellaneous;

import java.util.*;
import java.io.*;

public class ACoinProblem {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in = br.readLine().split(" ");
        int N = Integer.parseInt(in[0]), V = Integer.parseInt(in[1]);
        in = br.readLine().split(" ");
        int[] coins = new int[N];
        for (int i = 0; i < N; i++)
            coins[i] = Integer.parseInt(in[i]);

        int C, L; int[] costs;
        for (int v = 0; v < V; v++) {
            in = br.readLine().split(" ");
            C = Integer.parseInt(in[0]); L = Integer.parseInt(in[1]);
            costs = new int[C+1];
            Arrays.fill(costs, Integer.MAX_VALUE);
            costs[0] = 0;
                for (int i = 1; i <= C; i++) {
                    for (int j = 0; j < L; j++) {
                        int tmp = i-coins[j];
                        if (tmp >= 0 && costs[tmp] != Integer.MAX_VALUE)
                            costs[i] = Math.min(costs[i], costs[tmp] + 1);
                    }
                }
            if (costs[C] != Integer.MAX_VALUE)
                System.out.println(costs[C]);
            else System.out.println(-1);
        }
    }
}
