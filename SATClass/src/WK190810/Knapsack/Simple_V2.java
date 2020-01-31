package WK190810.Knapsack;

import java.util.*;

public class Simple_V2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), W = sc.nextInt();
        int[][] table = new int[N][W];
        int[] arrW = new int[N], arrV = new int[N];
        for (int i = 0; i < N; i++) {
            arrW[i] = sc.nextInt();
            arrV[i] = sc.nextInt();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= W; j++) {

            }
        }
    }
}
