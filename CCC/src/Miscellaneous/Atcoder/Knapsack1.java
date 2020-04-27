package Miscellaneous.Atcoder;

import java.util.*;

public class Knapsack1 {  // 0/1 Knapsack DP Solution
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), W = sc.nextInt(), arr[][] = new int[N+1][2];
        for (int i = 1; i <= N; i++) {
            arr[i][0] = sc.nextInt(); arr[i][1] = sc.nextInt();
        }
        Arrays.sort(arr, (int[]a, int[]b)->a[0]-b[0]);
        long[][] dp = new long[N+1][W+1]; // arr: 0=weight, 1=value
        for (int i = 1; i <= N; i++) {
            int v = arr[i][1], w = arr[i][0];
            for (int j = 1; j <= W; j++) {
                if (w > j) dp[i][j] = dp[i-1][j];
                else dp[i][j] = Math.max(v+dp[i-1][j-w], dp[i-1][j]);
            }
        }
        System.out.println(dp[N][W]);
    }
}
