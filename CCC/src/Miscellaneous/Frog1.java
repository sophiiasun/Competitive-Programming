package Miscellaneous;

import java.util.*;

public class Frog1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] stones = new int[N+1];
        for (int i = 1; i <= N; i++)
            stones[i] = sc.nextInt();

        int[] dis = new int[N+1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[1] = 0;
        dis[2] = Math.abs(stones[1] - stones[2]);
        for (int i = 3; i <= N; i++) {
            int tmp1 = Math.abs(stones[i] - stones[i-1]);
            int tmp2 = Math.abs(stones[i] - stones[i-2]);
            dis[i] = Math.min(dis[i-1]+tmp1, dis[i-2]+tmp2);
        }

        System.out.println(dis[N]);
    }
}
