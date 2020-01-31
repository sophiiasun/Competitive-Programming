package WK190810.Knapsack;

import java.util.*;

public class Simple {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int W = sc.nextInt(), N = sc.nextInt();
        int[][] arr = new int[N][W + 1];
        int[] arrV = new int[N];
        int[] arrW = new int[N];

        for (int i = 0; i < N; i++) {
            arrV[i] = sc.nextInt();
            arrW[i] = sc.nextInt();
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= W; j++) {
                if (i == 0) {
                    if (arrW[i] > j) {
                        arr[i][j] = 0;
                    } else {
                        arr[i][j] = arrV[i];
                    }
                } else {
                    if (arrW[i] > j) {
                        arr[i][j] = arr[i - 1][j];
                    } else {
                        arr[i][j] = Integer.max(arrV[i] + arr[i - 1][j - arrW[i]], arr[i - 1][j]);
                    }
                }
            }
        }
        for(int i = 0; i < N; i++)
            System.out.println(Arrays.toString(arr[i]));
        System.out.println(arr[N - 1][W]);
    }

}
