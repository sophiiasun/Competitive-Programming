package Atcoder_DP;

import java.util.*;

public class Frog2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), K = sc.nextInt();
        int[] stones = new int[N+1];
        for (int i = 1; i <= N; i++)
            stones[i] = sc.nextInt();

        int[] dis = new int[N+1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[1] = 0;
        for (int i = 2; i <= N; i++) {
            for (int j = 1; j <= K; j++) {
                int mark = i - j;
                if (mark > 0)
                    dis[i] = Math.min(dis[i], dis[mark] + Math.abs(stones[mark]-stones[i]));
                else break;
            }
        }

        System.out.println(dis[N]);
    }
}
