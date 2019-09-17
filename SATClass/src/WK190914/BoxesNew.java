package WK190914;

import java.util.*;

public class BoxesNew {

    private static int[][] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        arr = new int[N][3];
        for(int i = 0; i < N; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
            arr[i][2] = sc.nextInt();
        }

        Arrays.sort(arr, (a, b) -> Double.compare(a[0], b[0]));

        int[] aCnt = new int[N];
        for(int i = 0; i < N; i++) {
            if (i == 0)
                aCnt[i] = 1;
            else
                aCnt[i] = getLargestStack(i, aCnt);
        }
    }

    private static int getLargestStack(int N, int[] aCnt) {
        int iRet = 1;
        for (int i = 0; i < N; i++) {
            if (arr[i] < arr[N] && aCnt[i] + 1) {

            }
        }
    }

}
