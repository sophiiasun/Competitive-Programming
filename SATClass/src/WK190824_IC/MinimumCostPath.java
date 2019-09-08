package WK190824_IC;

import java.util.*;

public class MinimumCostPath {

    private static Scanner sc = new Scanner(System.in);
    private static int c = sc.nextInt();
    private static int r = sc.nextInt();
    private static int[][] arr = new int[c][r];
    private static int[][] cost = new int[c][r];

    public static void main(String[] args) {
        for (int i = 0; i < c; i++) {
            for (int j = 0; j < r; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < c; i++) {
            for (int j = 0; j < r; j++) {
                if (i == 0 && j == 0) {
                    cost[0][0] = arr[0][0];
                } else if (j == 0) {
                    cost[i][0] = cost[i - 1][0] + arr[i][0];
                } else if (i == 0) {
                    cost[0][j] = cost[0][j - 1] + arr[0][j];
                } else {
                    cost[i][j] = getMin(cost[i][j - 1], cost[i - 1][j], cost[i - 1][j - 1]) + arr[i][j];
                }
            }
        }

        for (int i = 0; i < c; i++) {
            System.out.println(Arrays.toString(cost[i]));
        }

        System.out.println(cost[c - 1][r - 1]);

    }

    private static int getMin(int a, int b, int c) {
        int iRet;
        iRet = Math.min(a, b);
        iRet = Math.min(iRet, c);
        return iRet;
    }

}
